def call(Map config) {
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Main') {
            echo '''Building config.environment'''
            sh config.mainscript
        }
        stage('Post') {
            echo '''Successfully built for config.environment'''
        }
    }
}
