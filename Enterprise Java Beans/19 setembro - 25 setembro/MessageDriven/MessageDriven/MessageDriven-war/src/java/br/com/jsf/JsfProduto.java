/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf;

import br.com.ejb.EjbProduto;
import br.com.ejb.data.entity.Produto;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author renatopradebon
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
    
    public Collection<Produto> getAll(){
        return ejbProduto.getAll();
    }
    
}
