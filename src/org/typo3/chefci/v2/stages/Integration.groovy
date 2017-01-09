package org.typo3.chefci.v2.stages

class Integration extends AbstractStage {

    Integration(Object script, String stageName) {
        super(script, stageName)
    }

    @Override
    void execute() {
        script.stage(stageName) {
            testkitchen()
        }
    }

    private def testkitchen(){
        script.node {
            script.script {
                wrap([$class: 'AnsiColorBuildWrapper', colorMapName: "XTerm"]) {
                    result = script.sh(script: 'kitchen test --destroy always', returnStatus: true)
                    if (result != 0) {
                        script.echo "kitchen returned non-zero exit status"
//                        echo "Archiving test-kitchen logs"
//                        archive(includes: ".kitchen/logs/${instanceName}.log")
                        script.error("kitchen returned non-zero exit status")
                    }
                }
            }
        }
    }

}
