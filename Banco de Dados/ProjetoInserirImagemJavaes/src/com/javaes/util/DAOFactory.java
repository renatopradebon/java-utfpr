/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaes.util;

import com.javaes.dados.ImagemDAO;
import com.javaes.dados.ImagemDAOHibernate;



/**
 *
 * @author yoda
 */
public class DAOFactory 
{
     public static ImagemDAO criarImagemDAO()
    {
        ImagemDAOHibernate imagemDAO                              = new  ImagemDAOHibernate();
        imagemDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return imagemDAO;
    }
      
}
