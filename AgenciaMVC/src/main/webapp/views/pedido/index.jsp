<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<title>TURBRASIL | Pedidos</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Pedidos</h1>
		</header>

		<jsp:include page="../../components/menu.jsp">
			<jsp:param name="home" value="./index.jsp" />
			<jsp:param name="cliente" value="cliente" />
			<jsp:param name="passagem" value="passagem" />
			<jsp:param name="pedido" value="pedido" />
		</jsp:include>

		<section class="container">

			<div class="p-4">
				<button data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary mb-2 botao1"> Novo Livro </button>
					
				<table class="table table-responsive table-hover">
					<thead class="table-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">Nome</th>
							<th scope="col">contato</th>
							<th scope="col">Destino</th>
							<th scope="col">DataPassagem</th>
							<th scope="col">DAtaPedido</th>
							<th scope="col">numPedido</th>
						</tr>
					</thead>
					<tbody>

						<jstl:forEach items="${listaLivros}" var="l">
							<tr>
								<td>${l.id}</td>
								<td>${l.nome}</td>
								<td>${l.contato}</td>
								<td>${l.Destino}</td>
								<td>${l.DataPassagem}</td>
								<td>${l.DataPedido}</td>
								<td>${l.numPedido}</td>
								<td>
									<div class="d-flex">
										<button data-bs-toggle="modal"
											data-bs-target="#exampleModal${l.id}" class="mx-1" title="Editar">
											<i class="ri-file-edit-line"></i>
										</button> <a href="livro-delete?id=${l.id}" class="mx-1"
											title="Cancelar"
											onclick="return confirm('Deseja excluir o autor ${l.nome}.')">
											<i class="ri-delete-bin-2-line"></i>
										</a>
										
										<!-- Modal -->
										<div class="modal fade" id="exampleModal${l.id}" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h1 class="modal-title fs-5" id="exampleModalLabel">Modal
															title</h1>
														<button type="button" class="btn-close" data-bs-dismiss="modal"
															aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<form action="livro-update">
												            <h2 class="text-center">Atualizar</h2>
												            <input type="hidden" id="id" name="id" class="form-control" value="${l.id}" />
												            <div class="form-group mb-3">
												                <label for="nome" class="form-label">
												                    Nome
												                </label>
												                <input type="text" id="nome" name="nome" class="form-control" value="${l.nome}" />
												            </div>
												            
												            <div class="form-group mb-3">
												                <label for="email" class="form-label">
												                    contao
												                </label>
												                <input type="text" id=" contao" name=" contao" class="form-control" value="${l.contato}" />
												            </div>
												            <div class="form-group mb-3">
												                <label for="email" class="form-label">
												                    Destino
												                </label>
												                <input type="text" id=" Destino" name=" Destino" class="form-control" value="${l. Destino}" />
												            </div>
												            
												            <div class="form-group mb-3">
												                <label for="senha" class="form-label">
												                    DataPassagen
												                </label>
												                <input type="number" id=" DataPassagen" name=" DataPassagen" class="form-control" step="0.01" value="${l. DataPassagen}" />
												            </div>
												            
												             <div class="form-group mb-3">
												                <label for="senha" class="form-label">
												                    DataPedido
												                </label>
												                <input type="number" id=" DataPedido" name=" DataPedido" class="form-control" step="0.01" value="${l. DataPedido}" />
												            </div>
												            
												             <div class="form-group mb-3">
												                <label for="senha" class="form-label">
												                    numPedido
												                </label>
												                <input type="number" id="numPedido" name="numPedido" class="form-control" step="0.01" value="${l.numPedido}" />
												            </div>
												
												            <button type="submit" class="btn btn-primary">
												                Enviar
												            </button>
												            <a href="./livro" class="btn btn-danger" style="margin-left: 10px">
												                Cancelar
												            </a>
											            </form>
													</div>
													
												</div>
											</div>
										</div>
										
									</div>
								</td>
							</tr>
						</jstl:forEach>

					</tbody>
				</table>
			</div>
		</section>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Modal
							title</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="livro-create">
				            <h2 class="text-center">Atualizar</h2>
				            <input type="hidden" id="id" name="id" class="form-control" value="" />
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
				                <input type="text" id="contator" name="contato" class="form-control" value="" />
				            </div>
				            <div class="form-group mb-3">
				                <label for="email" class="form-label">
				                    destino
				                </label>
				                <input type="text" id="destino" name="destino" class="form-control" value="" />
				            </div>
				            
				            <div class="form-group mb-3">
				                <label for="senha" class="form-label">
				                    DataPassagem
				                </label>
				                <input type="number" id=" DataPassagem" name=" DataPassagem" class="form-control" step="0.01" value="" />
				            </div>
				            
				            <div class="form-group mb-3">
	                     <label for="senha" class="form-label">
				                    DataPedido
				              </label>
				               <input type="number" id=" DataPedido" name=" DataPedido" class="form-control" step="0.01" value="" />
				            </div>
												            
				            <div class="form-group mb-3">
				             <label for="senha" class="form-label">
				                    numPedido
				              </label>
				               <input type="number" id="numPedido" name="numPedido" class="form-control" step="0.01" value="" />
				            </div>
				
				            <button type="submit" class="btn btn-primary">
				                Enviar
				            </button>
				            <a href="./livro" class="btn btn-danger" style="margin-left: 10px">
				                Cancelar
				            </a>
			            </form>
					</div>
					
				</div>
			</div>
		</div>

	</main>
	<footer>
		<img src="./assets/img/recode.svg" alt="recodePro" />
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"></script>
</body>
</html>