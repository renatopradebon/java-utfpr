/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author renatopradebon
 */
public class TestaCidade {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
        EntityManager manager = factory.createEntityManager();

        //Query query = manager.createQuery("select c.id, c.nome from Cidade c");
        
        Query query = manager.createNamedQuery("Cidade.findAll");

        List<Cidade> cidades = query.getResultList();

        for (Cidade c : cidades) {
            System.out.println("Cidade: " + c.getNome() );
        }
    }

}
