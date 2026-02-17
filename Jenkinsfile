pipeline {
    agent any

    environment {
        VERSION = "v1.7"  // Version définie ici
    }



    stages {

        stage('Clean first') {
            steps {
                bat 'mvn clean'
                echo "${VERSION}"
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                cucumber reportTitle: 'My Cucumber Report',
                         fileIncludePattern: 'target/example-report.json'
            }
        }

    /*    stage('slack') {
            steps {
                bat """
                curl -X POST ^
                -H "Content-type: application/json" ^
                --data "{\\"text\\":\\"Deploying! Version ${VERSION}\\"}" ^
                %SLACK_WEBHOOK%
                """
            }
        }*/

        stage('Create Git Tag') {
            steps {
                script {
                    // Créer le tag local ffff
                    bat "git tag -a ${VERSION} -m \"Release ${VERSION}\""

                    // Pousser le tag vers GitHub
                    bat "git push origin ${VERSION}"
                }
            }
        }
/**jjjj
**/

stage('Create Release Tag') {
    steps {
        script {
          

            bat """
curl -X POST https://github.com/aek1987/github/releases ^

-H "Authorization: Bearer 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" ^
-H "Accept: application/vnd.github+json" ^
-H "Content-Type: application/json" ^
-d "{\\"tag_name\\":\\"%{VERSION}\\",\\"name\\":\\"Release v%{VERSION}\\",\\"body\\":\\"Production release\\",\\"draft\\":false,\\"prerelease\\":false}"
"""
        }
    }
        
    }
}
}
