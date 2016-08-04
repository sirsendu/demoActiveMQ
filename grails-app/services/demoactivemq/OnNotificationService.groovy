package demoactivemq

import grails.transaction.Transactional


@Transactional
class OnNotificationService {

    def testIt (it) {
	println "GOT MESSAGE: $it"
    }
}
