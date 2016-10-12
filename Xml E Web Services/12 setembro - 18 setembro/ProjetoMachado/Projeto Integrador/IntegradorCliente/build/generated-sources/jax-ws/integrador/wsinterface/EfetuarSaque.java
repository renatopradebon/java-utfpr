
package integrador.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de efetuarSaque complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="efetuarSaque">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bs_numeroConta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bs_valorSacado" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "efetuarSaque", propOrder = {
    "bsNumeroConta",
    "bsValorSacado"
})
public class EfetuarSaque {

    @XmlElement(name = "bs_numeroConta")
    protected long bsNumeroConta;
    @XmlElement(name = "bs_valorSacado")
    protected double bsValorSacado;

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
     * Obtém o valor da propriedade bsValorSacado.
     * 
     */
    public double getBsValorSacado() {
        return bsValorSacado;
    }

    /**
     * Define o valor da propriedade bsValorSacado.
     * 
     */
    public void setBsValorSacado(double value) {
        this.bsValorSacado = value;
    }

}
