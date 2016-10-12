/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.wsinterface;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import integrador.log.Transacao;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Machado
 */
public class BancarioServiceLog {
    public void addLog(Transacao transacao) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:4000/log");
        resource.type(MediaType.APPLICATION_XML);
        Transacao s = resource.post(Transacao.class,transacao);
        System.out.println(s);
    }
}
