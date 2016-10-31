/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Machado
 */
@Stateless
@LocalBean
public class EjbProduto {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public java.util.Collection<br.data.entity.Produto> getAll(){
        return new br.data.crud.CrudProduto().getAll();
    }
}
