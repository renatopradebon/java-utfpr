package imcservice.wsimplementation;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import imcservice.wsinterface.DadosImc;
import imcservice.wsinterface.IMCServiceInterface;

@WebService(endpointInterface = "imcservice.wsinterface.IMCServiceInterface")
public class IMCServiceImpl implements IMCServiceInterface {
	@Resource
	private WebServiceContext wsContext;
	ArrayList<DadosImc> dados = new ArrayList<DadosImc>();

	@Override
	public double calcularIMC(String nome, double peso, double altura) throws Exception {
		if (peso <= 0 || altura <= 0)
			throw new Exception("peso ou altura invalido");

		DadosImc pessoa = new DadosImc();
		pessoa.setNome(nome);
		pessoa.setPeso(peso);
		pessoa.setAltura(altura);
		pessoa.setData(new Date());
		double imc = peso / (altura * altura);
		pessoa.setImc(imc);

		dados.add(pessoa);

		return imc;
	}

	@Override
	public DadosImc[] consultar() {
		DadosImc[] ret = new DadosImc[dados.size()];
		dados.toArray(ret);
		return ret;
	}

}
