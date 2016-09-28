package abccontratacao.wsimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import abccontratacao.wsinterface.ABCContratacaoService;
import abccontratacao.wsinterface.Pessoa;

@WebService(endpointInterface = "abccontratacao.wsinterface.ABCContratacaoService")
public class ABCContratacaoServiceImpl implements ABCContratacaoService {

	@Resource
	private WebServiceContext wsContext;
	ArrayList<Pessoa> consultas = new ArrayList<Pessoa>();

	@Override
	public String poderContratar(String nome, int idade, String cpf, char sexo, String setor) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new Exception("Parâmetro 'nome' obrigatório.");

		if (idade < 0 || idade > 99)
			throw new Exception("Idade inválida.");

		String resposta = retornarSituacao(idade);

		inserirPessoa(nome, idade, cpf, sexo, setor, resposta);

		return resposta;
	}

	private void inserirPessoa(String nome, int idade, String cpf, char sexo, String setor, String resposta) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setIdade(idade);
		pessoa.setNome(nome);
		pessoa.setSetor(setor);
		pessoa.setSexo(sexo);
		pessoa.setResposta(resposta);

		setConsultas(pessoa);
	}

	@Override
	public List<Pessoa> consultar(String setor) {
		if (setor == null || setor.trim().equals("") || setor.trim().equals("all"))
			return consultas;
		setor = setor.trim();
		List<Pessoa> filtrado = new ArrayList<Pessoa>();
		for (Pessoa p : consultas) {
			if (p.getSetor().equalsIgnoreCase(setor))
				filtrado.add(p);
		}

		return filtrado;
	}

	public String retornarSituacao(int idade) {

		return idade <= 15 ? "Não empregar"
				: (idade <= 17 ? "Tempo parcial" : (idade <= 60 ? "Tempo integral" : "Não empregar"));
	}

	public ArrayList<Pessoa> getConsultas() {
		return consultas;
	}

	public void setConsultas(Pessoa pessoa) {
		this.consultas.add(pessoa);
	}

}
