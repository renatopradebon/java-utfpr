/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author Machado
 */
@Named(value = "beanCorreios")
@RequestScoped
public class BeanCorreios {

    @Resource(mappedName = "jms/MyTopic")
    private Topic myTopic;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    /**
     * Creates a new instance of BeanCorreios
     */
    public BeanCorreios() {
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
