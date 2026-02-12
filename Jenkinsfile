pipeline {
    agent any

    stages {

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn package'
            }
        }

      stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                                 allowEmptyArchive: true
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                cucumber reportTitle: 'My Cucumber Report',
                         fileIncludePattern: 'target/example-report.json'
            }
        }

     
    }

    post {
        success {
            bat '''
            curl -X POST -H "Content-type: application/json" --data "{\\"text\\":\\"Build SUCCESS 🚀\\"}" https://hooks.slack.com/services/NEW/WEBHOOK/URL
            '''
        }
        failure {
            bat '''
            curl -X POST -H "Content-type: application/json" --data "{\\"text\\":\\"Build FAILED ❌\\"}" https://hooks.slack.com/services/NEW/WEBHOOK/URL
            '''
        }
    }  
}
