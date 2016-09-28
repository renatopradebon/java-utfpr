package abccontratacao.wsimplementation.cliente;

import abccontratacao.wsimplementation.ABCContratacaoServiceImplService;
import abccontratacao.wsinterface.ABCContratacaoService;

public class ABCContratacaoCliente {

	public static void main(String[] args) {
		try {
			// obtencao da interface do servico
			ABCContratacaoServiceImplService acessor = new ABCContratacaoServiceImplService();
			ABCContratacaoService servico = acessor.getABCContratacaoServiceImplPort();

			// chamando a operacao poderContratar do servico
			// ABCContratacaoService
			String resposta = servico.poderContratar("Joao Carlos", 25, "123456789-09", 1, "RH");
			System.out.println("resposta do servico: " + resposta);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
