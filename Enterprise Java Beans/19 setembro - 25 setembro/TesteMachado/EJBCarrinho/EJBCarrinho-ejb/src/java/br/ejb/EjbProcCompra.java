/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.data.entity.DetCompra;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author Machado
 */
@Stateful
@LocalBean
public class EjbProcCompra {
    
    private java.util.Collection<br.data.entity.DetCompra> lcompra;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public EjbProcCompra() {
        this.lcompra = new java.util.ArrayList<>();
    }
    
    public java.util.Collection<br.data.entity.DetCompra> getAll(){
        return lcompra;
    }
    
    public void addProduto(br.data.entity.Produto produto){
        boolean loc = false;
        for (DetCompra detCompra : lcompra) {
            if (detCompra.getProduto().getCodigo()==produto.getCodigo()){
                detCompra.setQuantidade(detCompra.getQuantidade()+1);
                loc = true;
            }
        }
        
        if (!loc){
            br.data.entity.DetCompra dc = new br.data.entity.DetCompra(produto);
            lcompra.add(dc);
        }
    }
    
    public void removeProduto(br.data.entity.Produto produto){
        boolean loc = false;
        for (DetCompra detCompra : lcompra) {
            if (detCompra.getProduto().getCodigo()==produto.getCodigo()){
                detCompra.setQuantidade(detCompra.getQuantidade()-1);
                loc = true;
            }
        }

        if (!loc){
            br.data.entity.DetCompra dc = new br.data.entity.DetCompra(produto);
            lcompra.remove(dc);
        }
    }
    
    
    
}
