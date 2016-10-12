
package integrador.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de efetuarDeposito complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="efetuarDeposito">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bs_numeroConta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bs_valorDepositado" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "efetuarDeposito", propOrder = {
    "bsNumeroConta",
    "bsValorDepositado"
})
public class EfetuarDeposito {

    @XmlElement(name = "bs_numeroConta")
    protected long bsNumeroConta;
    @XmlElement(name = "bs_valorDepositado")
    protected double bsValorDepositado;

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

    /**
     * Obtém o valor da propriedade bsValorDepositado.
     * 
     */
    public double getBsValorDepositado() {
        return bsValorDepositado;
    }

    /**
     * Define o valor da propriedade bsValorDepositado.
     * 
     */
    public void setBsValorDepositado(double value) {
        this.bsValorDepositado = value;
    }

}
