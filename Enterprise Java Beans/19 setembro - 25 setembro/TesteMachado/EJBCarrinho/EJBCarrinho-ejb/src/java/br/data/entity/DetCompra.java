/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

/**
 *
 * @author Machado
 */
public class DetCompra {
    private Produto produto;
    private int quantidade;

    public DetCompra() {
    }

    public DetCompra(Produto produto) {
        this.produto = produto;
        this.quantidade = 1;
    }
 
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
