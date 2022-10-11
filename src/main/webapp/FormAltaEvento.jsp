<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Eventos</title>
</head>
<body>
<h1>Formulario Eventos</h1>
	<form>
	  <p>Nombre: <input type="text" name="nombre" size="40"></p>
	  <p>Descripcion: <input type="text" name="descrpcion" size="40"></p>
	  <p>Fecha de Inicio: <input type="date" name="fehcaInicio"></p>
	  <p>Duración: <input type="number" name="duracion"> (minutos)</p>
	  <p>Dirección: <input type="text" name="direccion"></p>
	  <p>Estado: <input type="text" name="estado"></p>
	  <p>Destacado: 
	  		<input type="radio" name="destacado" value="s"> Destacado
    		<input type="radio" name="destacado" value="n"> No destacado
   	  </p>
      <p>Aforo máximo: <input type="number" name="aforoMaximo"></p>
      <p>Mínimo de asistencia: <input type="number" name="minAsistencia"></p>
      <p>Precio: <input type="number" name="precio"></p>
      <p>Tipo:
      	<select name="tipoEvento">
      		<option value="concierto">Concierto</option>
      		<option value="despedida">Despedida</option>
      		<option value="cumpleaños">Cumpleaños</option>
      		<option value="boda">Boda</option>
      	</select>
	  <p>
	    <input type="submit" value="Enviar">
	    <input type="reset" value="Borrar">
	  </p>
	</form>
	<div>
	<p><a href="eventos">Volver atrás</a></p>
	<p><a href="index.jsp">Ir a inicio</a></p>
	</div>
</body>
</html>