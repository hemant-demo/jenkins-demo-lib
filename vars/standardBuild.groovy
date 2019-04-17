def call(Map config) {
    node {
        environment {
            def workspace = "${env.WORKSPACE}"
    }
        stage('Cleaning Up Workspace'){
            echo "Variable testing ${env.workspace}"
            echo "Cleaning up ${WORKSPACE}"
            // clean up our workspace 
           deleteDir()
            // clean up tmp directory 
            dir("${workspace}@tmp") {
                deleteDir()            
            }   
            
        }
        stage('Checkout') {
            echo "cheking out in ${WORKSPACE}"
            checkout scm
        }
        stage('Compile') {
            echo "Compiling in ${WORKSPACE}"
            sh config.compile
        }
        stage('Test') {
            echo "Runing test in ${WORKSPACE}"
            //echo "Testing variable workspace ${workspace}"
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

