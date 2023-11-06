package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.passagemDAO;
import dao.pedidoDAO;
import dao.ClienteDAO;
import modelos.passagem;
import modelos.pedido;
import modelos.Cliente;

@WebServlet(urlPatterns = { "/passagem", "/passagem-getCreate", "/passagem-create", "/passagem-edit", "/passagem-update", "/passagem-delete" })
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	passagemDAO cdao = new passagemDAO();
	passagem passage = new passagem ();

        
    public PassagemServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action = request.getServletPath();

		switch (action) {
		case "/passagem":
			read(request, response);
			break;
		
		case "/passagem-create":
			create(request, response);
			break;
		
		case "/passagem-update":
			update(request, response);
			break;
		case "/passagem-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<passagem> lista = cdao.read();

		request.setAttribute("listaLivros", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/livros/index.jsp");
		rd.forward(request, response);

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		passage.setDestino(request.getParameter("Destino"));
		passage.setDataPassagem(request.getParameter("DataPassagem"));
		
		cdao.create(passage);
		response.sendRedirect("passage");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		passage.setId(Integer.parseInt(request.getParameter("id")));
		passage.setDestino(request.getParameter("Destino"));
		passage.setDataPassagem(request.getParameter("DataPassagem"));
	

		cdao.update(passage);
		response.sendRedirect("passage");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cdao.delete(id);
		response.sendRedirect("passage");
	}

}