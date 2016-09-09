package imcservice.wsinterface;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author andre endo
 */
@WebService
public interface IMCServiceInterface {
    
    public double calcularIMC(@WebParam(name="imc_nome") String nome, 
                              @WebParam(name="imc_peso") double peso, 
                              @WebParam(name="imc_altura") double altura)
            throws Exception;
    
    public DadosImc[] consultar();
}
