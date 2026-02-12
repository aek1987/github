pipeline {
    
    stages {

        stage('Clean first') {
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
    environment {
        VERSION = "v1.0.0"  // Définir ici la version ou la récupérer dynamiquement
    }
    steps {
        script {
            // Créer un tag local jjjjj
            bat "git tag -a %VERSION% -m \"Release %VERSION%\""

            // Pousser le tag vers GitHub
            bat "git push origin %VERSION%"
        }
    }
}}}

 
