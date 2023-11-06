package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.pedidoDAO;
import modelos.pedido;

@WebServlet(urlPatterns = { "/pedido", "/pedido-create", "/pedido-update", "/pedido-delete" })
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	pedidoDAO ldao = new pedidoDAO();
	pedido pedi = new pedido();
	
    public PedidoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action = request.getServletPath();

		switch (action) {
		case "/pedido":
			read(request, response);
			break;
		case "/pedido-create":
			create(request, response);
			break;
		case "/pedido-update":
			update(request, response);
			break;
		case "/pedido-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<pedido> lista = ldao.read();

		request.setAttribute("listapedido", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/pedido/index.jsp");
		rd.forward(request, response);

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pedi.setDataPedido(request.getParameter("DataPedido"));
		

		ldao.create(pedi);
		response.sendRedirect("pedi");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		pedi.setId(Integer.parseInt(request.getParameter("id_pedido")));
		pedi.setDataPedido(request.getParameter("DataPedido"));
		
		ldao.update(pedi);
		response.sendRedirect("pedi");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ldao.delete(id);
		response.sendRedirect("achar");
	}

}
