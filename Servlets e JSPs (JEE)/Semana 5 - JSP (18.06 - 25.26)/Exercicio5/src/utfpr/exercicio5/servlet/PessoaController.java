package utfpr.exercicio5.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utfpr.exercicio5.modelo.Pessoa;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/PessoaController")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
		EntityManager manager = factory.createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		// OBJETO NO ESTADO NEW
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setIdade(Integer.parseInt(request.getParameter("idade")));
		pessoa.setSexo(request.getParameter("sexo"));

		// OBJETO NO ESTADO MANAGED
		manager.persist(pessoa);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		System.out.println("Pessoa id: " + pessoa.getId());

		manager.close();
		factory.close();

		response.sendRedirect("CadastroComSucesso.jsp");
	}
}
