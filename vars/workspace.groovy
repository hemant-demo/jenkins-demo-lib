def call() {
      return sh(script: "echo ${WORKSPACE}", returnStdout: true) 
    }
