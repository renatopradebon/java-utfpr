<%@page contentType="text/html;" pageEncoding="UTF-8" %>
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
			<h1>Exercício 5 - Cadastrar Pessoa</h1>
			<ul class="nav nav-pills">
			  <li role="presentation"><a href="./">Menu</a></li>
			  <li role="presentation" class="active"><a href="./CadastrarPessoa.jsp">Cadastrar Pessoa</a></li>
			  <li role="presentation"><a href="./ListarPessoa.jsp">Listar Pessoas</a></li>			  
			</ul>
			<form action="PessoaController" method="post" class="form-horizontal" name="addPessoa">
				<div class="form-group">
					<div class="input-group">
						<label for="nome">Nome:</label>
						<input type="text" name="nome" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<label for="idade">Idade:</label>
						<input type="text" name="idade" class="form-control">
					</div>
				</div>
				<div class="form-group">						
				    <label for="sexo">Sexo:</label>
				    <div class="radio">
			        	<input type="radio" name="sexo" id="masculino" aria-label="Masculino" value="M">
			        	<label for="masculino">Masculino</label>
				    </div>
				    <div class="radio">   
			        	<input type="radio" name="sexo" id="feminino" aria-label="Feminino" value="F">
			        	<label for="feminino">Feminino</label>
					</div>
	      		</div>
				<div class="form-group">
					<input type="submit" value="Enviar" class="btn btn-default">
				</div>	
			</form>
		</div>
	</body>
</html>