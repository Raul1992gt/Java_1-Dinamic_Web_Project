<%@page import="modelo.daos.EventoDaoImpl"%>
<%@page import="modelo.daos.IntEventoDao"%>
<%@page import="modelo.beans.Evento"%>
<%@page import="modelo.beans.Tipo"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión Eventos</title>
</head>
<body>
	<% List<Evento> listaEvento = (List<Evento>)request.getAttribute("eventos"); %>
	
	<h1><a href="index.jsp">Aplicación de Gestión de Eventos</a></h1>
	<h2>Listado de Eventos Activos</h2>
	<h3><a href="FormAltaEvento.jsp">Nuevo Evento</a></h3>
	<table border="2">
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Precio</th>
		<th colspan="3">Opciones</th>
	</tr>
	<%for (Evento ele: listaEvento){ %>
	<tr>
		<td><%= ele.getIdEvento() %></td>
		<td><%= ele.getNombre() %></td>
		<td><%= ele.getPrecio() %></td>
		<td><a href="eventos?opcion=editar&id= <%=ele.getIdEvento() %>">Editar</a></td>
		<td><a href="eventos?opcion=eliminar&id= <%= ele.getIdEvento() %>">Eliminar</a></td>
		<td><a href="eventos?opcion=cancelar&id= <%= ele.getIdEvento() %>">Cancelar</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>