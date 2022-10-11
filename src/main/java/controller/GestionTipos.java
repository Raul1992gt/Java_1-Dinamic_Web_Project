package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Tipo;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImpl;

/**
 * Servlet implementation class GestionTipos
 */
@WebServlet("/tipos")
public class GestionTipos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionTipos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntTipoDao tdao = new TipoDaoImpl();
		

		List<Tipo> listaTipo = tdao.mostrarTodos();

		request.setAttribute("tipos",listaTipo);
		request.getRequestDispatcher("tipos.jsp").forward(request, response);
		
		
	}

}
