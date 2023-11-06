<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>TURBRASIL | Criar passagem</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Atualizar passagem</h1>
		</header>
		
		<jsp:include page="../../components/menu.jsp">
			<jsp:param name="home" value="../../index.jsp" />
			<jsp:param name="passagems" value="passagem" />
		</jsp:include>
		
		<div class="container py-3">
            <form action="./passagem-update">
	            <h2 class="text-center">Atualizar</h2>
	            <input type="hidden" id="id" name="id" class="form-control" value="${passagem.id}" />
<!-- 	            <div class="form-group mb-3"> -->
<!-- 	                <label for="nome" class="form-label"> -->
<!-- 	                    id -->
<!-- 	                </label> -->
<!-- 	                <input type="text" id="id" name="id" class="form-control" value="${passagem.id}" readonly/> --%>
<!-- 	            </div> -->
	            <div class="form-group mb-3">
	                <label for="nome" class="form-label">
	                    Destino
	                </label> 
	                <input type="text" id="Desitno" name="Destino" class="form-control" value="${passagem.nome}" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="email" class="form-label">
	                    DataPassagem
	                </label>
	                <input type="DataPassagem" id="DataPassagem" name="DataPassagem" class="form-control" value="${passagem.email}" />
	            </div>
	            
	            <button type="submit" class="btn btn-primary">
	                Enviar
	            </button>
	            <a href="./passagem" class="btn btn-danger" style="margin-left: 10px">
	                Cancelar
	            </a>
            </form>
        </div>
		
    </main>
    
	<footer>
		<img
			src="./assets/img/recode.svg"
			alt="recodePro" />
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>