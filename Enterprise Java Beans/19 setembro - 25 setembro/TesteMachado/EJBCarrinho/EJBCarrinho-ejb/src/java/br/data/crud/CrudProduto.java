/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

/**
 *
 * @author Machado
 */
public class CrudProduto {
    public java.util.Collection<br.data.entity.Produto> getAll(){
        java.util.Collection<br.data.entity.Produto> lprod;
        lprod = new java.util.ArrayList<>();
        lprod.add(new br.data.entity.Produto(1, "Monitor"));
        lprod.add(new br.data.entity.Produto(2, "NoteBook"));
        lprod.add(new br.data.entity.Produto(3, "No-break"));
        lprod.add(new br.data.entity.Produto(4, "Mouse"));
        lprod.add(new br.data.entity.Produto(5, "WebCam"));
        lprod.add(new br.data.entity.Produto(6, "Memoria"));
        lprod.add(new br.data.entity.Produto(7, "CPU"));
        lprod.add(new br.data.entity.Produto(8, "Caixa de som"));
        lprod.add(new br.data.entity.Produto(9, "Pendriver"));
        return lprod;
    }
    
}
