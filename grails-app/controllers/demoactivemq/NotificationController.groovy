package demoactivemq

class NotificationController {

    def index = {
		def message = "Hi, this is a Hello World with JMS & ActiveMQ, " + new Date()
		//sendMessage("seda:input", message)
		//sendJMSMessage("activemq:input.queue", "Message")
		sendJMSMessage("activemq:input.queue", "Message")
		render "ACK"
	}
}
