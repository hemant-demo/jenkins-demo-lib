def call() {
    node{
    echo "Variable testing for Workspace"
    sh '''
    ls -alh
    '''
    //return sh(script: "ls -alh", returnStdout: true) 
    }
}
