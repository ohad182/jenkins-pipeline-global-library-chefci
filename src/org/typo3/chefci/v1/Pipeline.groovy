#!/usr/bin/env groovy

package org.typo3.chefci.v1;

def enterParams(){
    
        parameters {
        stringParam(defaultValue: 'cisco_tesla_bx', description: '', name: 'BOX_NAME')
        stringParam(defaultValue: 'cisco_tesla_bx_v2.3', description: '', name: 'BOX_BRANCH')
          
   
    }
}
def prepare() {
    node {
        //checkout(scm)
        // we e.g. have a .kitchen.docker.yml left from the last run. Remove that.
        //sh("git clean -fdx")
        echo "prepare"
    }
}

def failTheBuild(String message) {

    currentBuild.result = "FAILURE"

    (new SlackPostBuild()).execute()
    
    def messageColor = "\u001B[32m" 
    def messageColorReset = "\u001B[0m"
    echo messageColor + message + messageColorReset
    error(message)
}

def run(Object step){
    try {
        step.execute()
    } catch (err) {
        // unfortunately, err.message is not whitelisted by script security
        //failTheBuild(err.message)
        failTheBuild("Build failed")
    }
}

def execute() {
    //(new SlackPreBuild()).execute()

    this.enterParams()
    this.prepare()

    this.run(new Lint())

    this.run(new BerkshelfInstall())
    this.run(new TestKitchen())
    this.run(new ArchiveArtifacts())

    if (env.BRANCH_NAME == "master") {
        this.run(new BerkshelfUpload())
    }
   // (new SlackPostBuild()).execute()
}

return this;
