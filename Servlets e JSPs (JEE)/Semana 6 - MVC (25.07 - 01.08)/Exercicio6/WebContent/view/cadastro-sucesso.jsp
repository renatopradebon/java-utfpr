<%@page contentType="text/html;" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<title>Exercício 6 - MVC - Cadastrar Pessoa</title>
	</head>
	<body>
		<div class="container">
			<h1>Exercício 6 - MVC - Cadastrar Pessoa</h1>
			<ul class="nav nav-pills">
			  <li role="presentation"><a href="../">Menu</a></li>
			  <li role="presentation" class="active"><a href="./cadastrar-pessoa.jsp">Cadastrar Pessoa</a></li>
			  <li role="presentation"><a href="./pessoa">Listar Pessoas</a></li>			  
			</ul>
			<p class="bg-success">Pessoa cadastrada com sucesso!</p>
			
			<p class="bg-info">Deseja cadastrar uma nova? 
			  <a href="./cadastrar-pessoa.jsp">Sim</a>
			  <a href="./pessoa">Não</a>
			</p>
		</div>
	</body>
</html>