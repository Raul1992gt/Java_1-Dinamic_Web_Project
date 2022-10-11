package modelo.daos;

import java.util.List;

import modelo.beans.Evento;

public interface IntTipoCliente {

	int apuntarEvento(Evento evento);
	int borrarEvento(Evento evento);
	List<Evento> mostrarEventos(int idUsuario);
	
}
