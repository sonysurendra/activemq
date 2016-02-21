package test.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicReceiver {

	public static void main(String[] args) throws Exception {
		// Get the Connection Factory
					ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
				
				// Get the connection
					Connection connection = connectionFactory.createConnection();
				// Start the Connection
					connection.start();
					
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					
				//Topic
					Destination topic = session.createTopic("Topic1");
					
				//Queue Consumer
					MessageConsumer messageConsumer = session.createConsumer(topic);
					
					messageConsumer.setMessageListener(new TopicListener());
					/*Message msg = messageConsumer.receive();
					
					while(msg != null){
						
						if(msg instanceof TextMessage){
							TextMessage textMessage  = (TextMessage) msg;
							System.out.println("Consume the message:::::" + textMessage.getText());
						}
						msg = messageConsumer.receive();
					}*/
					

	}

}
