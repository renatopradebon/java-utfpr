
package integrador.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de criarConta complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="criarConta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bs_nomeCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bs_saldoInicial" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarConta", propOrder = {
    "bsNomeCliente",
    "bsSaldoInicial"
})
public class CriarConta {

    @XmlElement(name = "bs_nomeCliente")
    protected String bsNomeCliente;
    @XmlElement(name = "bs_saldoInicial")
    protected double bsSaldoInicial;

    /**
     * Obtém o valor da propriedade bsNomeCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsNomeCliente() {
        return bsNomeCliente;
    }

    /**
     * Define o valor da propriedade bsNomeCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsNomeCliente(String value) {
        this.bsNomeCliente = value;
    }

    /**
     * Obtém o valor da propriedade bsSaldoInicial.
     * 
     */
    public double getBsSaldoInicial() {
        return bsSaldoInicial;
    }

    /**
     * Define o valor da propriedade bsSaldoInicial.
     * 
     */
    public void setBsSaldoInicial(double value) {
        this.bsSaldoInicial = value;
    }

}
