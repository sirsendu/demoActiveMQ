// Place your Spring DSL code here
import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.activemq.command.ActiveMQQueue
import org.springframework.jms.connection.SingleConnectionFactory
import org.springframework.jms.listener.DefaultMessageListenerContainer

import demoActiveMQ.CustomMessageQueue


beans = {

    jmsConnectionFactory(SingleConnectionFactory) {
	targetConnectionFactory = { ActiveMQConnectionFactory cf ->
	    brokerURL = 'vm://localhost'
	    // brokerURL = 'tcp://localhost:8161?jms.useAsyncSend=true'
	}
    }

    consumer(demoActiveMQ.CustomMessageQueue){
	onNotificationService = ref('onNotificationService') //if there are other beans to wire by name
    }
    messageListenerContainer(DefaultMessageListenerContainer) {
	connectionFactory = ref("jmsConnectionFactory")
	destinationName= 'customMessage'
	messageListener = ref("consumer")
	concurrentConsumers = 50
	receiveTimeout =10000
	idleConsumerLimit = 5
	idleTaskExecutionLimit =10
    }
    /*queue(ActiveMQQueue){
	it.constructorArgs = [CustomMessageQueue.QUEUE_NAME]
    }*/
}
