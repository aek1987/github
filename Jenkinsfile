pipeline {

        environment {
        VERSION = "v1.0.0"  // Définir ici la version ou la récupérer dynamiquement
    }
    
    stages {

        stage('Clean first') {
            steps {
                bat 'mvn clean'
                echo '${version}'
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


   stage('Create Git Tag') {
  

    steps {
        script {
         // Créer le tag local
            bat "git tag -a ${version} -m \"Release ${}\""

            // Pousser le tag sur GitHubgit 
            bat "git push origin ${version}"
        }
    }
}}}

 
version