package org.typo3.chefci.v2.stages

public class HelloWorld implements Stage {

    HelloWorld(script, String stageName) {
        super(script, stageName)
    }

    @Override
    void execute() {
        script.stage(stageName) {
            script.echo "Hiho!"
        }
    }

}
