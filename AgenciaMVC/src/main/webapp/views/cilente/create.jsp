<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="../../assets/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>TURBRASIL | Criar Cliente</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Criar Cliente</h1>
		</header>
		
		<jsp:include page="../../components/menu.jsp">
		<jsp:param name="home" value="./index.jsp" />
			<jsp:param name="passagems" value="passagem" />
			<jsp:param name="pedido" value="pedido" />
			<jsp:param name="cliente" value="cliente" />
				</jsp:include>
		
		<div class="container py-3">
            <form action="../../cliente-create">
	            <h2 class="text-center">Criar</h2>
	            <div class="form-group mb-3">
	                <label for="nome" class="form-label">
	                    Nome
	                </label>
	                <input type="text" id="nome" name="nome" class="form-control" value="" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="email" class="form-label">
	                    contato
	                </label>
	                <input type="contato" id="email" name="contato" class="form-control" value="" />
	            </div>
	
	            <button type="submit" class="btn btn-primary">
	                Enviar
	            </button>
	            <a href="../../cliente" class="btn btn-danger" style="margin-left: 10px">
	                Cancelar
	            </a>
            </form>
        </div>
		
    </main>
    
	<footer>
		<img
			src="../../assets/img/recode.svg"
			alt="recodePro" />
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>