package xml.verificador;

import java.io.File;

public class XMLVerificadorFile extends XMLVerificador {

	private File arquivoXml;

	public XMLVerificadorFile(String arquivoXml) {
		this.setArquivoXml(new File(arquivoXml));
	}

	public File getArquivoXml() {
		return arquivoXml;
	}

	public void setArquivoXml(File arquivoXml) {
		this.arquivoXml = arquivoXml;
	}

}
