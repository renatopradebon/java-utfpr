package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		writer.println("<!DOCTYPE HTML>");
		writer.println("<html>");
		writer.println("    <head>");
		writer.println("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
		writer.println("        <title>Servlet</title>");
		writer.println("    </head>");
		writer.println("    <body>");
		writer.println("        <h1>Links</h1>");
		writer.println("        <a href=\"/Exercicio2/ListaCidades\">Lista de Cidades</a><br/>");
		writer.println("        <a href=\"http://www.correios.com.br/para-voce\">Correios</a><br/>");
		writer.println(
				"        <a href=\"http://www2.correios.com.br/sistemas/rastreamento/\">Correios - Rastreamento de Objetos</a><br/>");
		writer.println("    </body>");
		writer.println("</html>");
	}
}
