package br.integrador.implementacoes;

import javax.jws.WebService;

import br.integrador.dao.ContaDAO;
import br.integrador.interfaces.BancarioService;

@WebService//(endpointInterface = "br.integrador.interfaces")
public class BancarioServiceImplements implements BancarioService {

	private ContaDAO contasDao;

	public BancarioServiceImplements() {
		contasDao = new ContaDAO();
	}

	@Override
	public long criarConta(String nome, double saldo) throws Exception {
		return contasDao.criarContaDAO(nome, saldo);
	}

	@Override
	public double consultarSaldo(long numConta) throws Exception {
		return contasDao.consultarSaldoDAO(numConta);
	}

	@Override
	public String efetuarDeposito(long numConta, double valor) throws Exception {
		return contasDao.efetuarDepositoDAO(numConta, valor);
	}

	@Override
	public String efetuarSaque(long numConta, double valor) throws Exception {
		return contasDao.efetuarSaqueDAO(numConta, valor);
	}

	@Override
	public String fecharConta(long numConta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
