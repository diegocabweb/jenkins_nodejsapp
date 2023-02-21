job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/diegocabweb/jenkins_nodejsapp.git', 'master') { node ->
            node / gitConfigName('diegocabweb')
            node / gitConfigEmail('diegocabweb@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
//    publishers {
//	slackNotifier {
//            notifyAborted(true)
//            notifyEveryFailure(true)
//            notifyNotBuilt(false)
//            notifyUnstable(false)
//            notifyBackToNormal(true)
//            notifySuccess(true)
//            notifyRepeatedFailure(false)
//            startNotification(false)
//            includeTestSummary(false)
//            includeCustomMessage(false)
//            customMessage(null)
//            sendAs(null)
//            commitInfoChoice('NONE')
//            teamDomain(null)
//            authToken(null)
//        }
//    }
}
