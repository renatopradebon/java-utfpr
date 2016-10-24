/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejb.data.crud;

import br.com.ejb.data.entity.Produto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author renatopradebon
 */
public class CrudProduto {

    public Collection<Produto> getAll() {
        
        Collection<Produto> listaProduto = new ArrayList<>();
        listaProduto.add(new Produto(1, "Mouse"));
        listaProduto.add(new Produto(2, "Teclado"));
        listaProduto.add(new Produto(3, "Monitor"));
        listaProduto.add(new Produto(4, "Notebook"));
        listaProduto.add(new Produto(5, "Gabinete"));
        listaProduto.add(new Produto(6, "Celular Motorola Moto X"));
        listaProduto.add(new Produto(7, "Celular LG Nexus4"));
        listaProduto.add(new Produto(8, "CPU"));
        listaProduto.add(new Produto(9, "Memória"));
        listaProduto.add(new Produto(10, "HD"));

        return listaProduto;
    }
}
