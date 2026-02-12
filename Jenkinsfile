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
            bat """
            curl -X POST -H "Content-type: application/json" ^
            --data "{\\"text\\":\\"Build SUCCESS 🚀 ${env.JOB_NAME} #${env.BUILD_NUMBER}\\"}" ^
            %SLACK_WEBHOOK%
            """
        }
    }
}
