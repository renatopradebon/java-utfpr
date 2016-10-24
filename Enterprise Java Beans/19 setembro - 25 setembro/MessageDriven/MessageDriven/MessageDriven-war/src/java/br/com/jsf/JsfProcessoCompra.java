/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf;

import br.com.ejb.EjbProcessoCompra;
import br.com.ejb.data.entity.DetalheCompra;
import br.com.ejb.data.entity.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author renatopradebon
 */
@Named(value = "jsfProcessoCompra")
@SessionScoped
public class JsfProcessoCompra implements Serializable {

    @EJB
    private EjbProcessoCompra ejbProcessoCompra;

    /**
     * Creates a new instance of JsfProcessoCompra
     */
    public JsfProcessoCompra() {
    }
    
    public void adicionaProduto(Produto produto){
        ejbProcessoCompra.adicionaCompra(produto);
    }
    
    public Collection<DetalheCompra> getAll(){
        return ejbProcessoCompra.getAll();
    }
    
}
