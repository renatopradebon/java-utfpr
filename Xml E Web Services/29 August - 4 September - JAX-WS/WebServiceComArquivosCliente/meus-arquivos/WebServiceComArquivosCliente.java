package webservicecomarquivos.cliente;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import webservicecomarquivos.wsimplementation.FileServiceImplService;
import webservicecomarquivos.wsimplementation.FileServiceImplServiceLocator;
import webservicecomarquivos.wsinterface.FileService;

/**
 *
 * @author andre endo
 * 
 *         Essa classe mostra com enviar um arquivo para o servico e recuperar
 *         logo em seguida esse mesmo arquivo
 * 
 *         NAO ESQUECA DE INICIAR O SERVIDOR PRIMEIRO (projeto
 *         "WebServiceComArquivos-servidor")
 */
public class WebServiceComArquivosCliente {

	/**
	 *
	 */
	public static void main(String[] args) {
		try {
			FileServiceImplService fsim = new FileServiceImplServiceLocator();
			FileService servico = fsim.getFileServiceImplPort();

			// enviando o arquivo dessa propria classe para o servico
			File arq = new File("./src/webservicecomarquivos/cliente/WebServiceComArquivosCliente.java");
			byte[] arqEnviado = new byte[(int) arq.length()];
			FileDataSource fileDataSource = new FileDataSource(arq);
			DataHandler dataHandler = new DataHandler(fileDataSource);
			BufferedInputStream bin = new BufferedInputStream(dataHandler.getInputStream());
			bin.read(arqEnviado);

			String msg = servico.salvarArquivo("WebServiceComArquivosCliente.java", arqEnviado);
			System.out.println("resposta da operacao salvarArquivo: " + msg);

			// recuperando de volta o arquivo enviado
			byte resp[] = servico.downloadArquivo("WebServiceComArquivosCliente.java");

			FileOutputStream fos = new FileOutputStream("./meus-arquivos/" + "WebServiceComArquivosCliente.java");
			fos.write(resp);
			fos.flush();

		} catch (Exception ex) {
			System.out.println("Erro");
		}

	}

}
