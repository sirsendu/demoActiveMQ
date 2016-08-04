package demoactivemq

import com.dd.TradeDTO
import grails.transaction.Transactional

import javax.jms.ObjectMessage
import javax.jms.TextMessage
import org.codehaus.groovy.grails.web.json.JSONObject


@Transactional
class OnNotificationService {

  //  static transactional=false
   // static exposes = ['jms']
  //  static destination = "trade"

  
    public void onMessage( message) {
		try {
			if (message instanceof TextMessage) {
			    String dto =  ((TextMessage)message).getObject();
		                 // String dto =  ((TextMessage)message).getText()
				  System.out.println(dto);
			}
			else {
			    println "Message "+new JSONObject(message)
			}
			 
			//Save the new trade
			//tradeService.saveTrade(dto);
			
			//Broadcast new trade to all clients
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
   
    }
    def testIt (it) {
	println "GOT MESSAGE: $it"
    }
}
