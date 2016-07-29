package demoactivemq


import org.apache.camel.builder.RouteBuilder

class SimpleRouteRoute extends RouteBuilder {
    def grailsApplication
    @Override
    void configure() {
		def config = grailsApplication?.config
	println "configure.. simple route"
	
	from('activemq:input.queue').to('bean:onNotificationService?method=testIt')
	//from('activemq:input.queue').to('bean:onNotificationService?method=testIt')
    }
}