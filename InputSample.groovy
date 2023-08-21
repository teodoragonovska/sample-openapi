pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/teodoragonovska/iwec-samples.git'
            }
        }
        
        stage('Print File') {
            steps {
                bat 'type file.txt'
            }
        }
        
        stage('Build') {
            steps {
                bat 'echo "Building the project"'
            }
        }
    }

    post {
        always {
            input 'Deploy to production?'
            echo 'This will always run'
        }
    }
}
