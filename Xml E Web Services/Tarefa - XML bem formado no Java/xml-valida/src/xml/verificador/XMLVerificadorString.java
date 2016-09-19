package xml.verificador;

import java.io.StringReader;

import org.xml.sax.InputSource;

public class XMLVerificadorString extends XMLVerificador {

	private InputSource stringXml;

	public XMLVerificadorString(String stringXml) {
		this.setStringXml(new InputSource(new StringReader(stringXml)));
	}

	public InputSource getStringXml() {
		return stringXml;
	}

	public void setStringXml(InputSource stringXml) {
		this.stringXml = stringXml;
	}

}
