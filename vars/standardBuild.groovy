def call(Map config) {
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Main') {
            sh config.main
        }
        stage('Post') {
            echo '''Successfully built for config.environment'''
        }
    }
}
