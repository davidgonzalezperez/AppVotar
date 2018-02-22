<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comienza la Valoracion</title>
</head>
<body>
<h2>Encuesta de valoración</h2> 


<p>Debe asignar un número de 0 a 10 en las casillas que se indican a continuacion, siendo 0 la nota mas baja y 10 la mas alta.</p>
<form action="Servlet" method="post">

<p>Vote por favor:</p>
<br>
Introduce el nombre del equipo a valorar(Equipo 1, Equipo 2,Equipo 3...etc)<br> <input type="text" name="equipo"><br/><br/>
<p>
1. Presentacion del proyecto.<br/>
<input type="text" name="presentacion"><br/><br/>
2. Seguridad de la pagina web.<br/>
<input type="text" name="seguridad"><br/><br/>
3. Es original?Que te parece su diseño?.<br/>
 <input type="text" name="diseño"><br/><br/>
4.Accesibilidad<br/>
<input type="text" name="accesibilidad"><br/><br/>
5. Funcionalidad<br/>
<input type="text" name="funcionalidad"><br/><br/>

<input type="submit" value="Enviar votación">
</form>
</p>
</body>
</html>