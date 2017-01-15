package org.typo3.chefci.v2.stages

public class HelloWorld implements Stage {
    StageInfo info;
    
    HelloWorld(Object script, String stageName) {
        info = new StageInfo(script, stageName)
    }

    @Override
    void execute() {
        info.script.stage(info.stageName) {
            info.script.echo "Hiho!"
        }
    }

}
