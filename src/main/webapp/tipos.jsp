<%@page import="modelo.beans.Tipo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión Tipos Evento</title>
</head>
<body>

	<% List<Tipo> listaTipo = (List<Tipo>)request.getAttribute("tipos"); %> 
	
	<h1><a href="index.jsp">Aplicación de Gestión de los Tipos de Eventos</a></h1>
	
	<h2>Listado de Tipos</h2>
	<h3><a href="FormAltaTipo.jsp">Nuevo Tipo</a></h3>
	
	<table border="2">
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Descripcion</th>
		<th colspan="3">Opciones</th>
	</tr>
	<%for (Tipo ele: listaTipo){ %>
	<tr>
		<td><%= ele.getIdTipo() %></td>
		<td><%= ele.getNombre() %></td>
		<td><%= ele.getDescripcion() %></td>
		<td><a href="tipos?opcion=editar&id= <%=ele.getIdTipo() %>">Editar</a></td>
		<td><a href="tipos?opcion=eliminar&id= <%= ele.getIdTipo() %>">Eliminar</a></td>
		<td><a href="tipos?opcion=cancelar=">Cancelar</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>