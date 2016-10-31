/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Machado
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/MyTopic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/MyTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class EjbMessageDriven implements MessageListener {
    
    public EjbMessageDriven() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("Informação: O carrinho ultrapassou a marca de 5 carrinhos.");
        
    }
    
}
