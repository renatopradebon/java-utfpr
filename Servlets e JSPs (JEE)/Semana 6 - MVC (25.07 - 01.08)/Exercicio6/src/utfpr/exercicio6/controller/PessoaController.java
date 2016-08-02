package utfpr.exercicio6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utfpr.exercicio6.model.Pessoa;
import utfpr.exercicio6.model.PessoaModel;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/view/pessoa")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String sexo = request.getParameter("sexo");

		Pessoa pessoa = new Pessoa();

		pessoa.setIdade(idade);
		pessoa.setNome(nome);
		pessoa.setSexo(sexo);

		PessoaModel pessoaModel = new PessoaModel();

		pessoaModel.save(pessoa);

		RequestDispatcher rd = request.getRequestDispatcher("/view/cadastro-sucesso.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String busca = request.getParameter("nome") == null ? "" : request.getParameter("nome");

		System.out.println("nome => " + busca);

		PessoaModel pessoaModel = new PessoaModel();

		List<Pessoa> pessoa = pessoaModel.busca(busca);

		request.setAttribute("lista", pessoa);
		request.getRequestDispatcher("/view/listar-pessoa.jsp").forward(request, response);
	}

}
