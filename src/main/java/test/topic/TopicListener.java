package test.topic;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


	public class TopicListener implements MessageListener{
	
		public void onMessage(Message msg) {
			try{
			if(msg instanceof TextMessage){
				TextMessage textMessage  = (TextMessage) msg;
				System.out.println("Consume the message:::::" + textMessage.getText());
			}
			
		}catch(Exception e){
			System.out.println("Something went wrong....");
			e.printStackTrace();
		}
	
	}
}
	