
package integrador.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultarSaldoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultarSaldoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bs_saldoConta" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarSaldoResponse", propOrder = {
    "bsSaldoConta"
})
public class ConsultarSaldoResponse {

    @XmlElement(name = "bs_saldoConta")
    protected double bsSaldoConta;

    /**
     * Obtém o valor da propriedade bsSaldoConta.
     * 
     */
    public double getBsSaldoConta() {
        return bsSaldoConta;
    }

    /**
     * Define o valor da propriedade bsSaldoConta.
     * 
     */
    public void setBsSaldoConta(double value) {
        this.bsSaldoConta = value;
    }

}
