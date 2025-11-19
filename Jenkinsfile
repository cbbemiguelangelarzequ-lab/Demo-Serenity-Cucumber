pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // He cambiado esto para que apunte a TU repositorio
                git 'https://github.com/aarteagavargas/Demo-Serenity-Cucumber.git'
            }
        }
        stage('Build & Test') {
            steps {
                // Ejecuta las pruebas con Maven
                bat 'mvn clean verify'
            }
        }
        stage('Report') {
            steps {
                // ESTA ES LA PARTE CORREGIDA QUE DABA ERROR
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity Report'
                ]
            }
        }
    }
}
