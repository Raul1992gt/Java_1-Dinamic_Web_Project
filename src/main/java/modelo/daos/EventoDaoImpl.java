package modelo.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.beans.Evento;
import modelo.beans.Tipo;

public class EventoDaoImpl implements IntEventoDao{
	
	private List<Evento> lista;
	
	public EventoDaoImpl() {
		lista = new ArrayList<>();
		
		cargarDatos();
	}

	private void cargarDatos() {
		
		IntTipoDao iTipos = new TipoDaoImpl();
		
		lista.add(new Evento(1,"evento1","es el primer evento",new Date(),350,"C/calle nº1","Activo","Destacado",50,10,1000,iTipos.buscarTipo(1)));
		lista.add(new Evento(2,"evento2","es el segundo evento",new Date(),350,"C/calle nº2","Activo","Destacado",50,10,2000,iTipos.buscarTipo(1)));
		lista.add(new Evento(3,"evento3","es el tercer evento",new Date(),350,"C/calle nº3","Activo","Destacado",50,10,3000,iTipos.buscarTipo(2)));
		lista.add(new Evento(4,"evento4","es el cuarto evento",new Date(),350,"C/calle nº4","Activo","Destacado",50,10,4000,iTipos.buscarTipo(2)));
		lista.add(new Evento(5,"evento5","es el quinto evento",new Date(),350,"C/calle nº5","Activo","Destacado",50,10,5000,iTipos.buscarTipo(3)));
		lista.add(new Evento(6,"evento6","es el sexto evento",new Date(),350,"C/calle nº6","Activo","Destacado",50,10,6000,iTipos.buscarTipo(3)));
		lista.add(new Evento(7,"evento6","es el sexto evento",new Date(),350,"C/calle nº6","Activo","Destacado",50,10,7000,iTipos.buscarTipo(4)));
		lista.add(new Evento(8,"evento6","es el sexto evento",new Date(),350,"C/calle nº6","Activo","Destacado",50,10,8000,iTipos.buscarTipo(4)));
		
	}

	

	@Override
	//Método listar todos los eventos
	public List<Evento> buscarEventos() {
		//Condición si es null mostramos mensaje
		if(lista == null) {
			System.out.println("lista vacía");
		}
		return lista;
	}

	@Override
	//Método para crear nuevo Evento
	public int nuevoEvento(Evento evento) {
		//Condición si el evento existe devolvemos 0 y no se añade
		if(lista.contains(evento))
			return 0;
		else
			//Añadimos evento, ponemos la expresión regular ?1:0 porque add(evento) devuelve boolean
			//En este caso devuelve 1 si se puede añadir y 0 en caso contrario
			return lista.add(evento)?1:0;
	}

	@Override
	//Método para eliminar evento buscado por ID
	public int eliminarEvento(int idEvento) {
		Evento eventoAux = new Evento(); //Creo evento auxiliar
		eventoAux.setIdEvento(idEvento); //Le asigno el id que nos pasan por parámetro
		int pos = lista.indexOf(eventoAux); //Creo variable para saber el indice del evento buscado con el id
		//Retornamos 0 y no eliminamos si no existe
		if(pos==-1)
			return 0;
		else
			//eliminamos y usamos las expresiones regulares para convertir a int
			return (lista.remove(pos) !=null) ?1:0;
	}

	@Override
	//Método editar evento pasando el evento por parámetro
	public int editarEvento(Evento evento) {
		//sabemos la posición del evento buscado
		int pos = lista.indexOf(evento);
		//Si es menor a 1 no existe
		if(pos==-1)
			return 0;
		//Accedemos a la posicion con pos y modificamos el evento
		else
			return(lista.set(pos, evento) != null)?1:0;				
	}

	@Override
	//Método eliminar evento, pasando evento
	public boolean eliminarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		
		if(pos==-1)
			return false;
		else
			return(lista.remove(evento));
	}

	@Override
	//Buscar evento con iD por parámetro
	public Evento buscarEvento(int idEvento) {
		//Creamos y asignamos el id al nuevo evento
		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		//Buscamos la posición del evento
		int pos = lista.indexOf(aux);
		
		//Si la posición es -1 devuelvo 0 (por que no existe)
		if(pos==-1)
				return null;
		//si no, le buscamos por el index
		else
			return (lista.get(pos));
					
		
	}

	@Override
	//Método cancelar evento
	public Evento cancelarEvento(int idEvento) {
		//Creo evento auxiliar y le introduzco el id pasado por parámetro
		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		//Busco la posción del evento
		int pos = lista.indexOf(aux);
		//Si la posición es -1 no existe, por el contrario, modificamos su estado a Cancelado
		if(pos == -1)
			return null;
		else
			aux.setEstado("Cancelado");
			return aux;
	}

	

}
