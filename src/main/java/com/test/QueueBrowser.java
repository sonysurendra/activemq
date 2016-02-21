package com.test;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueBrowser {

	public static void main(String[] args) throws Exception {
		// Get the Connection Factory
					ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
				
				// Get the connection
					Connection connection = connectionFactory.createConnection();
				// Start the Connection
					connection.start();
					
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					
				//Queue
					Queue queue = session.createQueue("requestQ1");
					
					javax.jms.QueueBrowser browser = session.createBrowser(queue);
					
					Enumeration enumeration = browser.getEnumeration();
					
					
					while(enumeration.hasMoreElements()){
						TextMessage message = (TextMessage) enumeration.nextElement();
						System.out.println("From Q Browser Msg :::::" + message.getText());
						}
					
	}

}
