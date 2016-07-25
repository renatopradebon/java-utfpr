package utfpr.exercicio4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaginaProibida
 */
@WebServlet("/Erro")
public class PaginaProibida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		writer.println("<!DOCTYPE HTML>");
		writer.println("<html>");
		writer.println("    <head>");
		writer.println("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
		writer.println(
				"        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
		writer.println(
				"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
		writer.println(
				"        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");
		writer.println("        <title>Servlet</title>");
		writer.println("    </head>");
		writer.println("    <body>");
		writer.println("    	<div class=\"container\">");
		writer.println("    		<div class=\"alert alert-danger\">");
		writer.println("    			<strong>Erro!</strong> Você não tem permissão para acessar essa página.");
		writer.println("    		</div>");
		writer.println("        <a href=\"" + request.getContextPath() + "/Login\">Voltar</a><br/>");
		writer.println("    	</div>");
		writer.println("    </body>");
		writer.println("</html>");
	}

}
