// vars/buildCommitSha.groovy
def call() {
      node {
        stage('Git-Log') {
            return sh(script: "git log -n 1 --pretty=format:'%h'", returnStdout: true)
        }
    }
    }
