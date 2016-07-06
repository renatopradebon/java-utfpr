package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaCidades
 */
@WebServlet(description = "Listagem de Cidades", urlPatterns = { "/ListaCidades" })
public class ListaCidades extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Cidade.findAll");

		List<Cidade> cidades = query.getResultList();

		writer.println("<!DOCTYPE HTML>");
		writer.println("<html>");
		writer.println("    <head>");
		writer.println("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
		writer.println("        <title>Lista de Cidades</title>");
		writer.println("    </head>");
		writer.println("    <body>");
		writer.println("        <a href=\"/Exercicio2/Menu\">Menu</a>");
		writer.println("        <h1>Lista de Cidades</h1>");
		writer.println("        <ul>");

		for (Cidade c : cidades) {
			writer.println("<li>" + c.getId() + " - " + c.getNome() + "/" + c.getEstado().getUf() + "</li>");
		}

		writer.println("        </ul>");
		writer.println("    </body>");
		writer.println("</html>");
	}
}
