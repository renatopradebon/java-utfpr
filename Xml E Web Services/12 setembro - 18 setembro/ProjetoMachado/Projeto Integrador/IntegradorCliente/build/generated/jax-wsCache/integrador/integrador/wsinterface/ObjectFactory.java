
package integrador.wsinterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the integrador.wsinterface package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EfetuarDepositoResponse_QNAME = new QName("http://wsinterface.integrador/", "efetuarDepositoResponse");
    private final static QName _CriarConta_QNAME = new QName("http://wsinterface.integrador/", "criarConta");
    private final static QName _FecharContaResponse_QNAME = new QName("http://wsinterface.integrador/", "fecharContaResponse");
    private final static QName _CriarContaResponse_QNAME = new QName("http://wsinterface.integrador/", "criarContaResponse");
    private final static QName _EfetuarSaque_QNAME = new QName("http://wsinterface.integrador/", "efetuarSaque");
    private final static QName _FecharConta_QNAME = new QName("http://wsinterface.integrador/", "fecharConta");
    private final static QName _ConsultarSaldoResponse_QNAME = new QName("http://wsinterface.integrador/", "consultarSaldoResponse");
    private final static QName _EfetuarSaqueResponse_QNAME = new QName("http://wsinterface.integrador/", "efetuarSaqueResponse");
    private final static QName _EfetuarDeposito_QNAME = new QName("http://wsinterface.integrador/", "efetuarDeposito");
    private final static QName _Exception_QNAME = new QName("http://wsinterface.integrador/", "Exception");
    private final static QName _ConsultarSaldo_QNAME = new QName("http://wsinterface.integrador/", "consultarSaldo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: integrador.wsinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CriarConta }
     * 
     */
    public CriarConta createCriarConta() {
        return new CriarConta();
    }

    /**
     * Create an instance of {@link EfetuarDepositoResponse }
     * 
     */
    public EfetuarDepositoResponse createEfetuarDepositoResponse() {
        return new EfetuarDepositoResponse();
    }

    /**
     * Create an instance of {@link CriarContaResponse }
     * 
     */
    public CriarContaResponse createCriarContaResponse() {
        return new CriarContaResponse();
    }

    /**
     * Create an instance of {@link EfetuarSaque }
     * 
     */
    public EfetuarSaque createEfetuarSaque() {
        return new EfetuarSaque();
    }

    /**
     * Create an instance of {@link FecharContaResponse }
     * 
     */
    public FecharContaResponse createFecharContaResponse() {
        return new FecharContaResponse();
    }

    /**
     * Create an instance of {@link FecharConta }
     * 
     */
    public FecharConta createFecharConta() {
        return new FecharConta();
    }

    /**
     * Create an instance of {@link ConsultarSaldoResponse }
     * 
     */
    public ConsultarSaldoResponse createConsultarSaldoResponse() {
        return new ConsultarSaldoResponse();
    }

    /**
     * Create an instance of {@link EfetuarSaqueResponse }
     * 
     */
    public EfetuarSaqueResponse createEfetuarSaqueResponse() {
        return new EfetuarSaqueResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ConsultarSaldo }
     * 
     */
    public ConsultarSaldo createConsultarSaldo() {
        return new ConsultarSaldo();
    }

    /**
     * Create an instance of {@link EfetuarDeposito }
     * 
     */
    public EfetuarDeposito createEfetuarDeposito() {
        return new EfetuarDeposito();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EfetuarDepositoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "efetuarDepositoResponse")
    public JAXBElement<EfetuarDepositoResponse> createEfetuarDepositoResponse(EfetuarDepositoResponse value) {
        return new JAXBElement<EfetuarDepositoResponse>(_EfetuarDepositoResponse_QNAME, EfetuarDepositoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarConta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "criarConta")
    public JAXBElement<CriarConta> createCriarConta(CriarConta value) {
        return new JAXBElement<CriarConta>(_CriarConta_QNAME, CriarConta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FecharContaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "fecharContaResponse")
    public JAXBElement<FecharContaResponse> createFecharContaResponse(FecharContaResponse value) {
        return new JAXBElement<FecharContaResponse>(_FecharContaResponse_QNAME, FecharContaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarContaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "criarContaResponse")
    public JAXBElement<CriarContaResponse> createCriarContaResponse(CriarContaResponse value) {
        return new JAXBElement<CriarContaResponse>(_CriarContaResponse_QNAME, CriarContaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EfetuarSaque }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "efetuarSaque")
    public JAXBElement<EfetuarSaque> createEfetuarSaque(EfetuarSaque value) {
        return new JAXBElement<EfetuarSaque>(_EfetuarSaque_QNAME, EfetuarSaque.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FecharConta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "fecharConta")
    public JAXBElement<FecharConta> createFecharConta(FecharConta value) {
        return new JAXBElement<FecharConta>(_FecharConta_QNAME, FecharConta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "consultarSaldoResponse")
    public JAXBElement<ConsultarSaldoResponse> createConsultarSaldoResponse(ConsultarSaldoResponse value) {
        return new JAXBElement<ConsultarSaldoResponse>(_ConsultarSaldoResponse_QNAME, ConsultarSaldoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EfetuarSaqueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "efetuarSaqueResponse")
    public JAXBElement<EfetuarSaqueResponse> createEfetuarSaqueResponse(EfetuarSaqueResponse value) {
        return new JAXBElement<EfetuarSaqueResponse>(_EfetuarSaqueResponse_QNAME, EfetuarSaqueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EfetuarDeposito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "efetuarDeposito")
    public JAXBElement<EfetuarDeposito> createEfetuarDeposito(EfetuarDeposito value) {
        return new JAXBElement<EfetuarDeposito>(_EfetuarDeposito_QNAME, EfetuarDeposito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsinterface.integrador/", name = "consultarSaldo")
    public JAXBElement<ConsultarSaldo> createConsultarSaldo(ConsultarSaldo value) {
        return new JAXBElement<ConsultarSaldo>(_ConsultarSaldo_QNAME, ConsultarSaldo.class, null, value);
    }

}
