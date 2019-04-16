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
        
        stage('Package') {
            sh config.package
        }
        stage('Post') {
            sh config.postScript
        }
    }
}
