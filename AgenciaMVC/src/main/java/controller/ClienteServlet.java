package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.ClienteDAO;
import modelos.Cliente;

@WebServlet(urlPatterns = { "/cliente", "/cliente-create", "/cliente-edit", "/cliente-update", "/cliente-delete" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO udao = new ClienteDAO();
	Cliente usuario = new Cliente();

	public ClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/cliente":
			read(request, response);
			break;
		case "/cliente-create":
			create(request, response);
			break;
		case "/cliente-edit":
			edit(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
		case "/cliente-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> lista = udao.read();

		request.setAttribute("listaUsuarios", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/index.jsp");
		rd.forward(request, response);

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setContato(request.getParameter("contato"));

		udao.create(usuario);
		response.sendRedirect("cliente");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		usuario = udao.readById(id);
		
		request.setAttribute("usuario", usuario);

		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setContato(request.getParameter("contato"));

		udao.update(usuario);
		response.sendRedirect("usuario");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		udao.delete(id);
		response.sendRedirect("usuario");
	}

}