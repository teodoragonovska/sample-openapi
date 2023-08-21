pipeline {
    agent any
    parameters {
        string(name: 'NAME', defaultValue: 'Teodora', description: 'Your name')
        choice(name: 'COLOR', choices: ['Red', 'Blue', 'Green'], description: 'Your favorite color')
    }
    stages {
        stage('Build') {
            steps {
                echo "Hello, ${params.NAME}!"
                echo "Your favorite color is ${params.COLOR}."
            }
        }
    }
}
