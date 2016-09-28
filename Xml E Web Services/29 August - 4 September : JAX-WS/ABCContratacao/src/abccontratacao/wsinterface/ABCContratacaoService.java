package abccontratacao.wsinterface;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface ABCContratacaoService {

	public @WebResult(name = "abc_resposta") String poderContratar(@WebParam(name = "abc_nome") String nome,
			@WebParam(name = "abc_idade") int idade, @WebParam(name = "abc_cpf") String cpf,
			@WebParam(name = "abc_sexo") char sexo, @WebParam(name = "abc_setor") String setor) throws Exception;

	public @WebResult(name = "abc_Pessoa") List<Pessoa> consultar(@WebParam(name = "abc_setor") String setor);

}