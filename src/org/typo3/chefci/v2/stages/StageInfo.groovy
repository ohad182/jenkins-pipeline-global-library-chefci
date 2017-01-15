package org.typo3.chefci.v2.stages

abstract class StageInfo extends Serializable {

    def stageName
    def script

    StageInfo(script, String stageName) {
        this.script = script
        this.stageName = stageName
    }
}
