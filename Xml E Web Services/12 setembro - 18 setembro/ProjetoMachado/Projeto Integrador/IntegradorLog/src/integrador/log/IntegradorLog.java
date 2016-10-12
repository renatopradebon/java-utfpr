/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.log;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;


/**
 *
 * @author Machado
 */
public class IntegradorLog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        try {
            System.out.println("Iniciar o servico log: http://localhost:4000");			
            HttpServer server = HttpServerFactory.create("http://localhost:4000/");			
            server.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }
    
}
