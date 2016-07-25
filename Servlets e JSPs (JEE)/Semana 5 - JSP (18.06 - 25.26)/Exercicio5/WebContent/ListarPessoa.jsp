<%@page import="java.util.List" %>

<%@page import="javax.persistence.EntityManager" %>
<%@page import="javax.persistence.EntityManagerFactory" %>
<%@page import="javax.persistence.Persistence" %>
<%@page import="javax.persistence.Query" %>

<%@page import="utfpr.exercicio5.modelo.Pessoa" %>

<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<title>Exercício 5 - JSP</title>
	</head>
	<body>
		<div class="container">
			<h1>Exercício 5 - Listar Pessoas</h1>
			<ul class="nav nav-pills">
			  <li role="presentation"><a href="./">Menu</a></li>
			  <li role="presentation"><a href="./CadastrarPessoa.jsp">Cadastrar Pessoa</a></li>
			  <li role="presentation" class="active"><a href="./ListarPessoa.jsp">Listar Pessoas</a></li>			  
			</ul>
		
			<table class="table table-hover">
				<thead>
			        <tr>
			          <th>#</th>
			          <th>Nome</th>
			          <th>Idade</th>
			          <th>Sexo</th>
			        </tr>
		        </thead>
				<tbody>
				<%
					EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
					EntityManager manager = factory.createEntityManager();
					
					Query query = manager.createQuery("SELECT p FROM Pessoa p");
					
					List<Pessoa> pessoas = query.getResultList();
					
					if (pessoas.isEmpty()) { %>
					<tr>
			          <th scope="row" colspan="4">Sem resultados.</th>		          
				    </tr>
					<% } else {
						for (Pessoa pessoa : pessoas) { %>
						<tr>
				          <th scope="row"><%= pessoa.getId() %></th>
				          <td><%= pessoa.getNome() %></td>
				          <td><%= pessoa.getIdade() %></td>
				          <td><%= pessoa.getSexoExtenso() %></td>
				        </tr>
						<% }
					}
				%>
				</tbody>
			</table>
		</div>
	</body>
</html>