pipeline {
    agent any

    stages {

        stage('Clean first') {
            steps {
                bat 'mvn clean'
            }
        }
///********************//
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

     
    

    stage('slack') {
    steps {
        bat """
        curl -X POST ^
        -H "Content-type: application/json" ^
        --data "{\\"text\\":\\"Deploying!\\"}" ^
        %SLACK_WEBHOOK%
        """
    }
}

 
}}
