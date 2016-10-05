package webservicecomarquivos.wsinterface;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author andre endo
 * 
 * Esse arquivo representa a interface do servico 
 */
@WebService
@MTOM           //Essa anotacao indica que o servico ira manipular arquivos
public interface FileService {
   
    /**
     * 
     * @param nomeArquivo nome do arquivo que sera salvo no servidor
     * @param arquivo o arquivo de dados em si
     * @return uma mensagem confirmando se a operacao foi realizada
     * 
     * AO USAR ARQUIVOS COM JAX-WS, EH IMPORTANTE RESSALTAR O USO DA CLASSE "DATAHANDLER"
     * E NAO "FILE". NESSE SERVICO, UMA OPERACAO SALVA O ARQUIVO NO SERVIDOR E A 
     * OUTRA FAZ O DOWNLOAD DO ARQUIVO.
     */
    public @WebResult(name="fs_salvou") String 
        salvarArquivo(@WebParam(name="fs_nomeArquivo") String nomeArquivo, @WebParam(name="fs_arquivoEnviado") DataHandler arquivo);
    
    /**
     * 
     * @param nomeArquivo que sera feito o download
     * @return o arquivo que esta no servidor e foi salvo pela operacao anterior
     * @throws Exception se o arquivo nao existe ou eh um diretorio
     */
    public @WebResult(name="fs_arquivoRetornado") DataHandler 
        downloadArquivo(@WebParam(name="fs_nomeArquivo") String nomeArquivo)
                throws Exception;
}