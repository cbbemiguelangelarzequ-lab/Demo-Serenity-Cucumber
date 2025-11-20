pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9' 
        jdk 'JDK-21'      
    }
    
    environment {
        MAVEN_OPTS = '-Xmx1024m'
        SERENITY_PROJECT_NAME = 'SWAG LABS Automation'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Obteniendo código del repositorio...'
                git branch: 'master', url: 'https://github.com/cbbemiguelangelarzequ-lab/Demo-Serenity-Cucumber.git'
            }
        }
        
        stage('Build & Test') {
            steps {
                echo 'Compilando y ejecutando pruebas...'
                script {
                    try {
                        bat 'mvn clean verify -Dwebdriver.driver=chrome -Dheadless.mode=true'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        error "Las pruebas fallaron: ${e.message}"
                    }
                }
            }
        }
        
        stage('Generate Report') {
            steps {
                echo 'Generando reportes de Serenity...'
                bat 'mvn serenity:aggregate'
            }
        }
        
        stage('Publish Report') {
            steps {
                echo 'Publicando reportes HTML...'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Serenity Test Report',
                        reportTitles: 'Serenity BDD Report'
                    ])
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline finalizado.'
            
            archiveArtifacts artifacts: 'target/site/serenity/**/*', allowEmptyArchive: true
            
            cleanWs(patterns: [[pattern: 'target/surefire-reports/**', type: 'INCLUDE']])
        }
       
    }
}
