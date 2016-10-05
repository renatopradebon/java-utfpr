package webservicecomarquivos.wsimplementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import webservicecomarquivos.wsinterface.FileService;

/**
 *
 * @author andre endo
 * 
 * Esse classe representa a implementacao da logica do servico
 */
@WebService(endpointInterface = "webservicecomarquivos.wsinterface.FileService")
public class FileServiceImpl implements FileService
{
    public static final String DIRETORIO_SALVAR_ARQS = "./arquivos/";
    
    @Override
    public String salvarArquivo(String nomeArquivo, DataHandler arquivoDataHandler) {
        try {
            System.out.println("O arquivo que serah salvo se chama:" + nomeArquivo);
            System.out.println("Assinatura do objeto DataHandler:" + arquivoDataHandler);
            
            //nesse passo, o arquivo eh salvo na pasta arquivos do projeto
            //confira dp da execucao se o arquivo foi salvo
            FileOutputStream fos = new FileOutputStream(DIRETORIO_SALVAR_ARQS + nomeArquivo);
            arquivoDataHandler.writeTo(fos);
            return "salvo";
        } catch (IOException ex) {
            System.out.println("Ocorreu uma excecao.");
            return "erro";
        }
    }

    @Override
    public DataHandler downloadArquivo(String nomeArquivo) 
        throws Exception
    {
        File arquivo = new File(DIRETORIO_SALVAR_ARQS + nomeArquivo);
        if(! arquivo.exists())
            throw new Exception("Esse arquivo nao existe.");
        
        if(arquivo.isDirectory())
            throw new Exception("O valor informado eh um diretorio.");
        
        //Encapsula o arquivo no servidor para ser enviado ao cliente
        FileDataSource dataSource = new FileDataSource(arquivo);
        DataHandler arquivoDataHandler = new DataHandler(dataSource);
        
        return arquivoDataHandler;
    }
}
