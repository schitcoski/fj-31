package br.com.caelum.loja.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



@MessageDriven(activationConfig= {
		@ActivationConfigProperty(
				propertyName="destinationType",
				propertyValue="javax.jms.Qeue"),
		@ActivationConfigProperty(
				propertyName="destination",
				propertyValue="queue/loja")})
public class Financeiro implements MessageListener {

	public void onMessage(Message message) {
		try{
			String text = ((TextMessage)message).getText();
			System.out.println("Financeiro processando informação: " + text);
		}catch (JMSException e){
			throw new EJBException(e);
		}
		
	}


}
