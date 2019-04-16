def call(Map config) {
    node {
        stage('Cleaning Up Workspace'){
            echo "Cleaning up ${WORKSPACE}"
            // clean up our workspace 
           deleteDir()
            // clean up tmp directory 
            dir("${workspace}@tmp") {
                deleteDir()            
            }   
            
        }
        stage('Checkout') {
            def WORKSPACE=pwd
            echo "cheking out in ${WORKSPACE}"
            checkout scm
        }
        stage('Compile') {
            echo "Compiling in ${WORKSPACE}"
            sh config.compile
        }
        stage('Test') {
            echo "Runing test in ${WORKSPACE}"
            sh config.test
        }
        stage ('Package'){
            echo "Building snapshot in ${WORKSPACE}"
        sh config.package
        }
        stage('Post') {
            echo "Successfully built for ${config.environment}"
      }
   }
}

