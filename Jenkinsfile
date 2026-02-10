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
        always {
            // Lire les tests JUnit Maven (pas le JSON Cucumber)
            script {
                junit allowEmptyResults: true,
                      testResults: 'target/surefire-reports/*.xml'
            }
        }

        success {
            echo '✅ BUILD SUCCESS'
        }

        failure {
            echo '❌ BUILD FAILED'
        }
    }
}
