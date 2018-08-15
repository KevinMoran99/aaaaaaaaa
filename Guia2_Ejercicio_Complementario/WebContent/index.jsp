<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javabeans.*,java.util.*,modelo.*,java.text.SimpleDateFormat"%>
<%@taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jmesa.css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.bgiframe.pack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jmesa.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jmesa.js"></script>
<script>
	function onInvokeAction(id) { 
		setExportToLimit(id, '');
		createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
		var parameterString = createParameterStringForLimit(id); 
		location.href = document.pages.selectIndex.value + parameterString;
	}
</script>
</head>
<body>
	<center>
		<br/><br/>
		<a href="Controlador?operacion=formAdd">Nueva venta</a>
		<br/><br/>
		
		<%
		Operaciones oper = new Operaciones();
		ArrayList<VentaBean> ventas = (ArrayList)oper.getVentas();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		if (ventas.size() > 0) {
		%>
		
			<table border="1">
			<tr>
				<th>Linea</th>
				<th>Fecha de venta</th>
				<th>Descripcion</th>
				<th></th>
				<th></th>
			</tr>
			
			<%
			for (VentaBean temp : ventas) {
	        %>
	        	<tr>
	        		<td><%=oper.getLinea(temp.getId_linea()).getLinea() %></td>
	        		<td><%=formatter.format(temp.getFecha_venta()) %></td>
	        		<td><%=temp.getDescripcion() %></td>
	        		<td><a href="${pageContext.request.contextPath}/Controlador?operacion=formUpdate&id=<%=temp.getId_venta() %>">Modificar</a></td>
	        		<td><a href="${pageContext.request.contextPath}/Controlador?operacion=opDelete&id=<%=temp.getId_venta() %>">Eliminar</a></td>
	        	</tr>
	        <%
	        } 
		}
	    %>
		
		</table>
		
	</center>
</body>
</html>