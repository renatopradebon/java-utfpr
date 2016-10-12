/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import integrador.wsimplementation.BancarioServiceImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Machado
 */
public class IntegradorService {
        public static void main(String[] args) {
            try {
                System.out.println("Iniciar o servico - Integrador: http://localhost:3000/integrador");
                BancarioServiceImpl servico = new BancarioServiceImpl();
                Endpoint.publish("http://localhost:3000/integrador", servico);
		
            } catch (Exception ex) {
		ex.printStackTrace();
            }
    }    
}
