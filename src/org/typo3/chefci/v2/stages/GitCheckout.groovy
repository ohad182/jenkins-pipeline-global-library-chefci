package org.typo3.chefci.v2.stages

class GitCheckout implements Stage {
    StageInfo info;
    
    GitCheckout(Object script, String stageName) {
        info = new StageInfo(script, stageName)
    }

    @Override
    void execute() {
        info.script.stage(stageName) {
            info.script.node {
                //script.checkout(script.scm)
                // we e.g. have a .kitchen.docker.yml left from the last run. Remove that.
                //script.sh("git clean -fdx")
                info.script.echo "git checkout"
            }
        }
    }

}
