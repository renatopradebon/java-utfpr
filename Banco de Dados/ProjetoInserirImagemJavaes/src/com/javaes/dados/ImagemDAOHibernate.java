
package com.javaes.dados;

import com.javaes.modelo.Imagem;
import com.javaes.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author yoda
 */
public class ImagemDAOHibernate implements ImagemDAO
{
     private Session session;
    private SessionFactory sf;
    
    public ImagemDAOHibernate(){}
    
       public Session getSession()
    {
        return session;
    }

    public void setSession(Session session) 
    {
        this.session = session;
    }

    @Override
    public void salvar(Imagem imagem) 
    {
        try
        {
            this.sf                                                 = HibernateUtil.getSessionFactory();
            this.sf.getCurrentSession().beginTransaction();
            this.session.save(imagem);
            this.sf.getCurrentSession().getTransaction().commit();
        }
        catch(Exception erro)
        {
            this.session.beginTransaction().rollback();
        }
        finally
        {
            this.sf.getCurrentSession().close();
        }
    }

    @Override
    public void excluir(Imagem imagem) 
    {
        try
        {
            this.sf                                                 = HibernateUtil.getSessionFactory();
            this.sf.getCurrentSession().beginTransaction();
            this.session.delete(imagem);
            this.sf.getCurrentSession().getTransaction().commit();
        }
            catch(Exception erro)
        {
            this.session.beginTransaction().rollback();
        }
          finally
        {
            this.sf.getCurrentSession().close();
        }
    }   
    
    @Override
    public Imagem getImagem(Long idImagem)
    {
        try 
        {
            this.sf                                                 = HibernateUtil.getSessionFactory();
            this.sf.getCurrentSession().beginTransaction();
            Imagem imagem                                           = (Imagem) session.get(Imagem.class, idImagem);
            this.sf.getCurrentSession().getTransaction().commit();
            return imagem;
        } 
        catch (HibernateException e)
        {
            e.printStackTrace();
        } 
        finally 
        {
            this.sf.getCurrentSession().close();
        }
        return null;
    }
}
