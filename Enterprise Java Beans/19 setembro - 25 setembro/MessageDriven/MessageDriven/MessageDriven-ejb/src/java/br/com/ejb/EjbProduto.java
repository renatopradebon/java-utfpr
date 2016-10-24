/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejb;

import br.com.ejb.data.crud.CrudProduto;
import br.com.ejb.data.entity.Produto;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author renatopradebon
 */
@Stateless
@LocalBean
public class EjbProduto {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Collection<Produto> getAll() {
        return new CrudProduto().getAll();
    }
}
