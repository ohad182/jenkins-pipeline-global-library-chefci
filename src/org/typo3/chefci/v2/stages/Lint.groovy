package org.typo3.chefci.v2.stages

class Lint implements Stage {
    StageInfo info;
    
    Lint(Object script, String stageName) {
        info = new StageInfo(script, stageName)
    }

    @Override
    void execute() {
        info.script.stage(info.stageName) {
            foodcritic()
            rubocop()
        }
    }

    private def foodcritic(){
        info.script.node {
            info.script.echo('foodcritic .')
        }
    }

    private def rubocop(){
        info.script.node {
            // see also http://atomic-penguin.github.io/blog/2014/04/29/stupid-jenkins-and-chef-tricks-part-1-rubocop/
            info.script.echo('rubocop')
            //script.step([$class: 'WarningsPublisher', canComputeNew: false, canResolveRelativePaths: false, consoleParsers: [[parserName: 'Foodcritic'], [parserName: 'Rubocop']], defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', unHealthy: ''])
            //script.step([$class: 'AnalysisPublisher'])
        }
    }

}
