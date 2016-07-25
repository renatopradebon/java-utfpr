package utfpr.exercicio4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
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
		writer.println("        <title>Login</title>");
		writer.println("    </head>");
		writer.println("    <body>");
		writer.println("    	<div class=\"container\">");
		writer.println("        	<h1>Login de Acesso</h1>");
		writer.println("        	<form action=\"./ProcessaLogin\" method=\"post\" "
				+ "enctpy=\"multipart/form-data\" accept-charset=\"utf-8\">");
		writer.println("            	<div class=\"form-group\">");
		writer.println("        			<label for=\"usuario\">Usuário</label>");
		writer.println("					<input type=\"text\" name=\"usuario\">");
		writer.println("        			<label for=\"senha\">Senha</label>");
		writer.println("					<input type=\"password\" name=\"senha\">");
		writer.println("            	</div>");
		writer.println("        		<input type=\"submit\" value=\"Entrar\" class=\"btn btn-default\">");
		writer.println("        	</form>");
		writer.println("    	</div>");
		writer.println("    </body>");
		writer.println("</html>");
	}

}
