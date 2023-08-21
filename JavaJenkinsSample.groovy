pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                // Specify the directory where the repository should be checked out
                dir('src/main/java/com/example/calculator') {
                    git url: 'https://github.com/tgrip/rest-calculator.git', branch: 'master'
                }
            }
        }
        stage('Build') {
            steps {
                dir('src/main/java/com/example/calculator') {
                    script {
                        // Adjust the script based on the OS
                        if (isUnix()) {
                            sh './mvnw clean package'
                        } else {
                            bat '.\\mvnw clean package'
                        }
                    }
                }
            }
        }
        stage('Test') {
            steps {
                dir('src/main/java/com/example/calculator') {
                    script {
                        // Adjust the script based on the OS
                        if (isUnix()) {
                            sh './mvnw test'
                        } else {
                            bat '.\\mvnw test'
                        }
                    }
                }
            }
        }
        stage('Run') {
            steps {
                dir('src/main/java/com/example/calculator') {
                    script {
                        // Adjust the script based on the OS
                        if (isUnix()) {
                            sh './mvnw spring-boot:run -Dserver.port=8080'
                        } else {
                            bat '.\\mvnw spring-boot:run -Dserver.port=8080'
                        }
                    }
                }
            }
        }
    }
}
