def call(Map config) {
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Main') {
            sh config.compile
        }
        stage('Post') {
            echo '''Successfully built for config.environment'''
        }
    }
}
