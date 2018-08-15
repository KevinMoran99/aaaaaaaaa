<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="mensa" scope="request" class="javabeans.MensajeBean"/>
<jsp:setProperty name="mensa" property="*"/>
<% 
	if(request.getParameter("texto") != null) { 
%>
		<jsp:forward page="Controlador?operacion=grabar"/>
<%
	} 
%>
<body>
	<center>
		<h1>Generación de mensajes</h1>
		<form method="post">
			<br/><br/>
			<b>Datos del mensaje:</b><br/><br/>
			Introduzca destinatario: <input type="text" name="destino"><br/>
			Introduzca remitente: <input type="text" name="remite"><br/>
			Introduzca texto: <textarea name="texto" id="texto"></textarea><br/><hr><br/>
			<input type="submit" name="submit" value="Enviar">
			<input type="reset" value="Reset">
		</form>
	</center>
</body>
</html>