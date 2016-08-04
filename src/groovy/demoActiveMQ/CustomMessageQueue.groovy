package demoActiveMQ


import javax.jms.JMSException
import javax.jms.Message
import javax.jms.MessageListener
import javax.jms.ObjectMessage
import javax.jms.TextMessage

import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.stereotype.Component

import demoactivemq.OnNotificationService

public class CustomMessageQueue implements MessageListener {

    //public static final String destinationName  = "customMessage";


    private OnNotificationService onNotificationService;
    
    public OnNotificationService getOnNotificationService() {
        return onNotificationService;
    }

    public void setOnNotificationService(OnNotificationService onNotificationService) {
        this.onNotificationService = onNotificationService;
    }

    @Override
    public void onMessage(Message message) {
	try {
	    def dto
	    //TradeDTO dto = (TradeDTO) ((ObjectMessage)message).getObject();
	    if (message instanceof TextMessage) {
		dto =  ((TextMessage)message).getText();
		// String dto =  ((TextMessage)message).getText()
		onNotificationService.testIt(new JSONObject(dto))
		System.out.println(dto);
	    }
	    else {
		println "Message "+message
	    }
 
	    //Save the new trade
	    onNotificationService.testIt(dto)

	    //Broadcast new trade to all clients
	} catch (JMSException e) {
	    throw new RuntimeException(e);
	}

    }
}

