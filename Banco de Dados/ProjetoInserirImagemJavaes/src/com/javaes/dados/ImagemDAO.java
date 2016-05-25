package com.javaes.dados;

import com.javaes.modelo.Imagem;

/**
 *
 * @author javaes
 */
public interface ImagemDAO
{
    public void salvar(Imagem imagem);
    public void excluir(Imagem imagem);
    public Imagem getImagem(Long idImagem);
}
