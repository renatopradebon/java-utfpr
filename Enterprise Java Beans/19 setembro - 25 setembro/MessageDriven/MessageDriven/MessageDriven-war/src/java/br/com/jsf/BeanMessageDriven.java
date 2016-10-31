/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author renatopradebon
 */
public class BeanMessageDriven {
    
    @Resource(mappedName = "jms/MyTopic")
    private Topic myTopic;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    /**
     * Creates a new instance of BeanCorreios
     */
    public BeanMessageDriven() {
    }
    
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void send(){
        this.sendJMSMessageToMyTopic(mensagem);
    }

    private void sendJMSMessageToMyTopic(String messageData) {
        context.createProducer().send(myTopic, messageData);
    }
    
}
