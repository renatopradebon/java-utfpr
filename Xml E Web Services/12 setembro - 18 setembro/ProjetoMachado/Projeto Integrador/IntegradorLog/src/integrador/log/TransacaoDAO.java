/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.log;

import java.io.File;
import java.io.FileReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Machado
 */
public class TransacaoDAO {
    private static final String XML_FILE = "./LogBancario.xml";
    private TransacaoStore transactionStore;
 
    public TransacaoDAO() {
        
        try {
            JAXBContext context = JAXBContext.newInstance(TransacaoStore.class);
            Unmarshaller um = context.createUnmarshaller();
            transactionStore = (TransacaoStore)
            um.unmarshal(new FileReader(XML_FILE));
        } catch (Exception e) {
            //empty store
            transactionStore = new TransacaoStore();
            transactionStore.setNome("log");
            transactionStore.setTransactionList( new ArrayList<Transacao>() );
        }
    }  
        
    public List<Transacao> getTodasTransacoes() {
	return transactionStore.getTransactionList();
    }    
    
    public List<Transacao> getTransacao(Long numConta) {
        List<Transacao> todasTransacoes = getTodasTransacoes();
        List<Transacao> transacoesEspecificas = new ArrayList<Transacao>();
        
        for (Transacao t : todasTransacoes) {
             if (t.getNumeroConta() == numConta) 
                transacoesEspecificas.add(t);
        }        
            return transacoesEspecificas;
    }
    

    private void saveXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(TransacaoStore.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(transactionStore, new File(XML_FILE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }      
    	
    public void save(Transacao transacao) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = formatter.format( new Date( System.currentTimeMillis() ) );
    	transacao.setData(data);

    	transactionStore.getTransactionList().add(transacao);
    	
    	saveXML();
    }

}
