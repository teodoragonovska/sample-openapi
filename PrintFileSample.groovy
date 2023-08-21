pipeline {
    agent any
    tools { git 'Default' }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/teodoragonovska/iwec-samples.git'
            }
        }
        
        stage('Print File') {
            steps {
                bat 'type sample-file.txt'
            }
        }
    }

    post {
        always {
            echo 'Build complete'
        }
        success {
            echo 'Build succeeded'
        }
        failure {
            echo 'Build failed'
        }
    }
}
