
package integrador.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de efetuarSaqueResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="efetuarSaqueResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bs_resposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "efetuarSaqueResponse", propOrder = {
    "bsResposta"
})
public class EfetuarSaqueResponse {

    @XmlElement(name = "bs_resposta")
    protected String bsResposta;

    /**
     * Obtém o valor da propriedade bsResposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsResposta() {
        return bsResposta;
    }

    /**
     * Define o valor da propriedade bsResposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsResposta(String value) {
        this.bsResposta = value;
    }

}
