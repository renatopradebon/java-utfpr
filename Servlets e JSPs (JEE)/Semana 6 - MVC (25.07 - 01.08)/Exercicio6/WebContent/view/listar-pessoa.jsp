<%@page import="java.util.List" %>

<%@page import="utfpr.exercicio6.controller.PessoaController" %>
<%@page import="utfpr.exercicio6.model.Pessoa" %>

<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<title>Exercício 6 - MVC - Listar Pessoas</title>
	</head>
	<body>
		<div class="container">
			<h1>Exercício 6 - MVC - Listar Pessoas</h1>
			<ul class="nav nav-pills">
			  <li role="presentation"><a href="../">Menu</a></li>
			  <li role="presentation"><a href="./cadastrar-pessoa.jsp">Cadastrar Pessoa</a></li>
			  <li role="presentation" class="active"><a href="./pessoa">Listar Pessoas</a></li>			  
			</ul>
			
			<form action="pessoa" method="get" class="form-horizontal" name="listarPessoa">
				<div class="form-group">
					<div class="input-group">
						<label for="nome">Nome:</label>
						<input type="text" name="nome" class="form-control">
					</div>
				</div>				
				<div class="form-group">
					<input type="submit" value="Enviar" class="btn btn-default">
				</div>	
			</form>			
			
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
				List <Pessoa> pessoaLista = (List <Pessoa>) request.getAttribute("lista");
				if (pessoaLista.isEmpty()) { %>
				<tr>
		          <th scope="row" colspan="4">Sem resultados.</th>		          
			    </tr>
				<% } else {
					for (Pessoa pessoa : pessoaLista) { %>
						<tr>
				          <th scope="row"><%= pessoa.getId() %></th>
				          <td><%= pessoa.getNome() %></td>
				          <td><%= pessoa.getIdade() %></td>
				          <td><%= pessoa.getSexoExtenso() %></td>
				        </tr>
					<%
					}
				}
				%>
				</tbody>
			</table>
		</div>
	</body>
</html>