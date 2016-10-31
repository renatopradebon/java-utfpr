/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EjbProcCompra;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author Machado
 */
@Named(value = "jsfProcComprab")
@SessionScoped
public class JsfProcComprab implements Serializable {

    @Resource(mappedName = "jms/MyTopic")
    private Topic myTopic;
    
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    @EJB
    private EjbProcCompra ejbProcCompra;    

    /**
     * Creates a new instance of JsfProcComprab
     */
    public JsfProcComprab() {
    }
    
    public void add(br.data.entity.Produto produto){
        ejbProcCompra.addProduto(produto);
        if (ejbProcCompra.getAll().size() > 5) {
             context.createProducer().send(myTopic, "");
        }
    }
    
    public java.util.Collection<br.data.entity.DetCompra> getAll(){
        return ejbProcCompra.getAll();
    }   
    
    public void remove(br.data.entity.Produto produto){
        ejbProcCompra.removeProduto(produto);
    }    
}
