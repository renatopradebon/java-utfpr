
package integrador.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de criarContaResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="criarContaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bs_numeroConta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarContaResponse", propOrder = {
    "bsNumeroConta"
})
public class CriarContaResponse {

    @XmlElement(name = "bs_numeroConta")
    protected long bsNumeroConta;

    /**
     * Obtém o valor da propriedade bsNumeroConta.
     * 
     */
    public long getBsNumeroConta() {
        return bsNumeroConta;
    }

    /**
     * Define o valor da propriedade bsNumeroConta.
     * 
     */
    public void setBsNumeroConta(long value) {
        this.bsNumeroConta = value;
    }

}
