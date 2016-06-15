
package com.javaes.controle;

import com.javaes.dados.ImagemDAO;
import com.javaes.modelo.Imagem;
import com.javaes.util.DAOFactory;

/**
 *
 * @author javaES
 */
public class ImagemRN
{
  private ImagemDAO imagemDAO;
    
    public ImagemRN()
    {
        this.imagemDAO                 = DAOFactory.criarImagemDAO();
    }
    
     public void salvar(Imagem imagem) 
    {
        this.imagemDAO.salvar(imagem);
    }
    
    public void excluir(Imagem imagem)
    {
        this.imagemDAO.excluir(imagem);
    }  
    
    public Imagem getImagem(long idImagem)
    {
        return this.imagemDAO.getImagem(idImagem);
    }
}
