pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/Laura4lilavati/Demo-Serenity-Cucumber.git'
      }
    }
    stage('Build & Test') {
      steps {
        bat 'mvn clean verify'
      }
    }
    }
  }
}
