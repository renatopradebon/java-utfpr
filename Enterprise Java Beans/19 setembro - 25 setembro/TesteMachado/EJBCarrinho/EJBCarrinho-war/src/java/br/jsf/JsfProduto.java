/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EjbProduto;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Machado
 */
@Named(value = "jsfProduto")
@RequestScoped
public class JsfProduto {

    @EJB
    private EjbProduto ejbProduto;

    /**
     * Creates a new instance of JsfProduto
     */
    public JsfProduto() {
    }
    
    public java.util.Collection<br.data.entity.Produto> getAll(){
        return ejbProduto.getAll();
    }
    
    
}
