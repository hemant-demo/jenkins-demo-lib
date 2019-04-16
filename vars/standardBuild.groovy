def call(Map config) {
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Compile') {
            echo '''Building config.environment'''
            sh config.compile
        }
        stage('Test') {
            sh config.test
        }
        
        stage('Package') {
            sh config.pack
        }
        stage('Post') {
            echo '''Successfully built for config.environment'''
        }
    }
}
