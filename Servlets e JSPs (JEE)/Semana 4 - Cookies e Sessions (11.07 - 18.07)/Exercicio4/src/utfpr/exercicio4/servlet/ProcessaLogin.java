package utfpr.exercicio4.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessaLogin
 */
@WebServlet("/ProcessaLogin")
public class ProcessaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("usuario").equals("renato") && request.getParameter("senha").equals("renato")) {
			request.getSession().setAttribute("logado", new Boolean(true));
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
			//response.getWriter().println("<h1>...</h1>");
			response.sendRedirect("Conteudo");

		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//			response.getWriter().println("<h1>Você não tem permissão para acessar o conteúdo!!</h2>");
			response.sendRedirect("Erro");
		}

	}

}
