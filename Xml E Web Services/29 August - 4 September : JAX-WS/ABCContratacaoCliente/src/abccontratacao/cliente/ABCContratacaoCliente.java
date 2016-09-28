package abccontratacao.cliente;

import javax.xml.rpc.ServiceException;

import abccontratacao.wsimplementation.ABCContratacaoServiceImplServiceLocator;
import abccontratacao.wsinterface.ABCContratacaoService;
import abccontratacao.wsinterface.Pessoa;

public class ABCContratacaoCliente {

	ABCContratacaoServiceImplServiceLocator acessor;
	ABCContratacaoService servico;

	public ABCContratacaoCliente() throws ServiceException {
		// obtencao da interface do servico
		acessor = new ABCContratacaoServiceImplServiceLocator();
		servico = acessor.getABCContratacaoServiceImplPort();
	}

	public void consultarContratacaoPessoa() {
		try {
			// chamando a operacao poderContratar do servico
			String resposta = servico.poderContratar("Joana", 18, "123456789-09", 2, "Desenvolvimento");
			System.out.println("resposta do servico: " + resposta);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void consultarTodos() {
		try {
			// chamando a operacao consultar do servico
			Pessoa[] pessoas = servico.consultar("all");

			for (Pessoa itemPessoa : pessoas) {
				System.out.println("------------------------Dados----------------------");
				System.out.println("Nome = " + itemPessoa.getNome());
				System.out.println("Idade = " + itemPessoa.getIdade());
				System.out.println("CFP = " + itemPessoa.getCpf());
				System.out.println("Sexo = " + itemPessoa.getSexoExtenso());
				System.out.println("Setor = " + itemPessoa.getSetor());
				System.out.println("Resposta = " + itemPessoa.getResposta());
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws ServiceException {
		ABCContratacaoCliente teste = new ABCContratacaoCliente();		
		teste.consultarContratacaoPessoa();
		teste.consultarTodos();
	}

}
