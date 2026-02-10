pipeline {
    agent any

    stages {

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                junit testResults: 'target/surefire-reports/*.xml',
                      allowEmptyResults: true
            }
        }

        stage('archive') {
            steps {
                bat 'mvn package'
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
           
        }

         stage('Generate Cucumber Report') {
            steps {
                cucumber reportTitle: 'My Cucumber Report',
                         fileIncludePattern: 'target/cucumber-report.json'
            }
        }
    }

    post {
        success {
            echo '✅ BUILD SUCCESS'
        }
        failure {
            echo '❌ BUILD FAILED'
        }
    }
}
