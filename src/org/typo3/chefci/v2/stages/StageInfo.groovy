package org.typo3.chefci.v2.stages

class StageInfo implements Serializable {

    def stageName
    def script

    StageInfo(script, String stageName) {
        this.script = script
        this.stageName = stageName
    }
}
