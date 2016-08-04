package demoactivemq

import com.google.gson.Gson
import javax.jms.JMSException
import javax.jms.Message
import javax.jms.Session
import javax.jms.TextMessage

import org.springframework.jms.core.MessageCreator


class NotificationController {

    def standardJmsTemplate
    def index2 = {
		//def message = "Hi, this is a Hello World with JMS & ActiveMQ, " + new Date()
		//sendMessage("seda:input", message)
		//sendJMSMessage("activemq:input.queue", "Message")
		//sendJMSMessage("activemq:input.queue", "Message")
		//render "ACK"
	Gson gson = new Gson();

	
	// 2. Java object to JSON, and assign to a String
	final String jsonInString = gson.toJson(request.JSON);
		standardJmsTemplate.defaultDestinationName = 'customMessage'
		//Now create the actual message you want to send
		//TextMessage txtMessage = session.createTextMessage();
		//txtMessage.setText(jsonInString);
     
		//Set the reply to field to the temp queue you created above, this is the queue the server
		//will respond to
		//txtMessage.setJMSReplyTo(standardJmsTemplate.getDefault);
		//
		standardJmsTemplate.send(new MessageCreator() {
		    
					   @Override
					   public Message createMessage(Session session) throws JMSException {
		   
						//Map map =   request.JSON as Map
					        //return session.createTextMessage(jsonInString)
					       TextMessage txtMessage = session.createTextMessage();
					       txtMessage.setText(jsonInString)
					       return txtMessage
					   }
				   });
			       render "ACK"
	}
}
