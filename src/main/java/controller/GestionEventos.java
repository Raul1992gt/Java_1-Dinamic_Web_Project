package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/eventos")
public class GestionEventos extends HttpServlet {
	
	IntEventoDao edao = new EventoDaoImpl();
	
	List<Evento> listaEvento = edao.buscarEventos();
	
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("eventos", listaEvento);
		request.getRequestDispatcher("eventos.jsp").forward(request, response);
		
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "eliminar":				
			procedicimentoElminarEvento(request, response);						
			break;
		case "editar":
			procedicimentoEditarEvento(request, response);
			break;
		case "alta":
			procedicimentoAltaEvento(request, response);
			break;
		case "cancelar":
			procedimientoCancelarEvento(request,response);
			break;
		default:
			System.out.println("Opción errónea: "+ opcion);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void procedicimentoElminarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Asigno a event1 el evento buscado por el método usando el parámetro recibido por el request ("id") 
		//El parámetro es de tipo String por lo que le convertimos a int
		Evento event1 = edao.buscarEvento(Integer.parseInt(request.getParameter("id")));
		//Creo variable mensaje para mostrar dependendiendo de la condición
		String mensaje = null; 
		if(edao.eliminarEvento(event1))
			mensaje = "Evento eliminado";
		else
			mensaje = "Evento no se ha podido eliminar";
	
		//Creo atributo con el mensaje 
		request.setAttribute("mensaje", mensaje);
		//Volvemos a cargar la página
		request.getRequestDispatcher("eventos").forward(request, response);
	}
	
	protected void procedicimentoAltaEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	protected void procedicimentoEditarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void procedimientoCancelarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}