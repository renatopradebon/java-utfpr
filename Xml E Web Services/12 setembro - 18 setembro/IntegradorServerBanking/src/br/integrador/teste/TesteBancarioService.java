package br.integrador.teste;

import br.integrador.implementacoes.BancarioServiceImplements;

public class TesteBancarioService {

	public static void main(String args[]) throws Exception {

		BancarioServiceImplements banco = new BancarioServiceImplements();
		long contaRenato = banco.criarConta("Renato Pradebon", 1500);
		long contaCarol = banco.criarConta("Carol Pradebon", 2500);

		System.out.println("Conta numero => " + contaRenato);

		System.out.println("Saldo Renato " + banco.consultarSaldo(contaRenato));
//		banco.efetuarDeposito(0, 500);
		banco.efetuarDeposito(contaRenato, 700);
		banco.efetuarDeposito(contaRenato, 300);
		banco.efetuarSaque(contaRenato, 1300);
		System.out.println("Saldo final => " + banco.consultarSaldo(contaRenato));

		System.out.println("Saldo Carol " + banco.consultarSaldo(contaCarol));
		System.out.println(banco.efetuarDeposito(contaCarol, 500));
		banco.efetuarDeposito(contaCarol, 700);
		banco.efetuarDeposito(contaCarol, 300);
		System.out.println(banco.efetuarSaque(contaCarol, 1300));
		System.out.println("Saldo final => " + banco.consultarSaldo(contaCarol));
		
//		System.out.println("-----------------------------------------------");
//		System.out.println("Saldo Renato " + banco.consultarSaldo(contaRenato));
//		System.out.println(banco.fecharConta(contaRenato));
//		System.out.println("Saldo Renato " + banco.consultarSaldo(contaRenato));
	}

}
