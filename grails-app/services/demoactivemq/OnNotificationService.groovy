package demoactivemq

import grails.transaction.Transactional

@Transactional
class OnNotificationService {

    static transactional=false
    /*boolean transactional = false
    static exposes = ['jms']
    static destination = "queue.notification"

    def onMessage(it){
	    println "GOT MESSAGE: $it"
    }*/
    def testIt (it) {
	println "GOT MESSAGE: $it"
    }
}
