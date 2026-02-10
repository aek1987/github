pipeline {
    agent any

    tools {
        maven 'Maven'   // Nom configuré dans Jenkins (Global Tool Configuration)
        jdk 'JDK17'     // Optionnel si déjà dans PATH
    }

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
                bat 'mvn test'
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
