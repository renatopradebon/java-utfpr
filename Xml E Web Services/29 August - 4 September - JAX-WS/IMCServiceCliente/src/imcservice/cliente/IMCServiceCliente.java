package imcservice.cliente;

import javax.xml.rpc.ServiceException;

import imcservice.wsimplementation.IMCServiceImplServiceLocator;
import imcservice.wsinterface.DadosImc;
import imcservice.wsinterface.IMCServiceInterface;

public class IMCServiceCliente {

	IMCServiceImplServiceLocator acessor;
	IMCServiceInterface servico;

	public IMCServiceCliente() throws ServiceException {
		acessor = new IMCServiceImplServiceLocator();
		servico = acessor.getIMCServiceImplPort();
	}

	public void consultarIMC() {
		try {
			// chamando a operacao calcularIMC do servico
			double imc = servico.calcularIMC("Bruno Pradebon", 85, 1.80);
			System.out.println("IMC: " + imc);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void consultarTodos() {
		try {
			// chamando a operacao consultar do servico
			DadosImc[] dados = servico.consultar();

			for (DadosImc itemImc : dados) {
				System.out.println("------------------------Dados----------------------");
				System.out.println("Nome = " + itemImc.getNome());
				System.out.println("Peso = " + itemImc.getPeso());
				System.out.println("Altura = " + itemImc.getAltura());
				System.out.println("IMC= " + itemImc.getImc());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws ServiceException {
		IMCServiceCliente imcCliente = new IMCServiceCliente();
		imcCliente.consultarIMC();
		imcCliente.consultarTodos();
	}

}
