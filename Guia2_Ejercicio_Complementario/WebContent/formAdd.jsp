<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javabeans.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="venta" scope="request" class="javabeans.VentaBean"/>
<jsp:setProperty name="venta" property="*"/>
<% 
	if(request.getParameter("descripcion") != null) { 
%>
		<jsp:forward page="Controlador?operacion=opAdd"/>
<%
	} 
%>
<body>
<center>
	<h1>Nueva venta</h1>
	<form method="post">
		<br/><br/>
		Descripción: <textarea name="descripcion" id="descripcion"></textarea><br/>
		<br/>
		Linea de venta: 
		<select name="id_linea" id="id_linea">
		<%
			ArrayList lineas = (ArrayList)request.getAttribute("lineas");
			
			for (int i=0; i < lineas.size(); i++) {
				LineaBean l = (LineaBean)lineas.get(i);
				
				%>
				<option value="<%= l.getId_linea() %>"><%= l.getLinea() %></option>
				<%
				
			}
		%>
		</select>
		<br/><hr><br/>
		<input type="submit" name="submit" value="Enviar">
		<input type="reset" value="Reset">
	</form>
</center>
</body>
</html>