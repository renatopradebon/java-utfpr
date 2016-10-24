/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejb;

import br.com.ejb.data.entity.DetalheCompra;
import br.com.ejb.data.entity.Produto;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author renatopradebon
 */
@Stateful
@LocalBean
public class EjbProcessoCompra {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Collection<DetalheCompra> carrinhoCompra;

    public EjbProcessoCompra() {
        this.carrinhoCompra = new ArrayList<>();
    }

    public Collection<DetalheCompra> getAll() {
        return carrinhoCompra;
    }

    public void adicionaCompra(Produto produto) {
        Boolean jaExisteNoCarrinho = Boolean.FALSE;

        for (DetalheCompra detalhe : getAll()) {
            if (detalhe.getProduto().getCodigo() == produto.getCodigo()) {
                detalhe.setQuantidade(detalhe.getQuantidade() + 1);
                jaExisteNoCarrinho = Boolean.TRUE;
                
            }
        }

        if (!jaExisteNoCarrinho) {
            DetalheCompra detalheCompra = new DetalheCompra(produto);
            carrinhoCompra.add(detalheCompra);
        }
    }

}
