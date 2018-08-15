<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nomensajes</title>
</head>
<body>
	<center>
		<h2>Losiento, <%=request.getParameter("nombre") %> no tienemensajes</h2>
		<br><br><br>
		<a href="inicio.html">Inicio</a>
	</center>
</body>
</html>