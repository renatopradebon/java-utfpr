<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<title>Exercício 7 - MVC - Listar Pessoas</title>
	</head>
	<body>
		<div class="container">
			<h1>Exercício 7 - MVC - Listar Pessoas</h1>
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
					<c:forEach var="pessoa" items="${lista}">
						<c:choose>
							<c:when test="${lista.indexOf(pessoa) == 0}">
								<tr>
								     <th scope="row" colspan="4">Sem resultados. => ${lista.indexOf(pessoa)}</th>
								</tr>
							</c:when>
							<c:when test="${lista.indexOf(pessoa) > 0}">		   
								<tr>
								  	<th scope="row">${pessoa.id}</th>
									<th>${pessoa.nome}</th>
									<th>${pessoa.idade}</th>
									<th>${pessoa.sexo}</th>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>