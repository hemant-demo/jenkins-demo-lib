def call(Map config) {
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Compile') {
            sh config.compile
        }
        stage('Test') {
            sh config.test
        }
        stage('Post') {
            echo "Successfully built for ${config.environment}"
            steps {
                cleanWs()
                }
           }
        }
    }

