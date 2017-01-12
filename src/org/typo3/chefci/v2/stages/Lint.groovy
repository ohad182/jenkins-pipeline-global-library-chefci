package org.typo3.chefci.v2.stages

class Lint extends AbstractStage {

    Lint(Object script, String stageName) {
        super(script, stageName)
    }

    @Override
    void execute() {
        script.stage(stageName) {
            foodcritic()
            rubocop()
        }
    }

    private def foodcritic(){
        script.node {
            script.echo('foodcritic .')
        }
    }

    private def rubocop(){
        script.node {
            // see also http://atomic-penguin.github.io/blog/2014/04/29/stupid-jenkins-and-chef-tricks-part-1-rubocop/
            script.echo('rubocop')
            //script.step([$class: 'WarningsPublisher', canComputeNew: false, canResolveRelativePaths: false, consoleParsers: [[parserName: 'Foodcritic'], [parserName: 'Rubocop']], defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', unHealthy: ''])
            //script.step([$class: 'AnalysisPublisher'])
        }
    }

}
