<%@page import="javabeans.*,java.util.*"%>
<%@taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa"%>
<%@page import="javabeans.*,java.util.*"%>
<%@taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ver</title>
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
		<% String nombre = request.getParameter("nombre"); %>
		<h1>Mensaje para <%=nombre%></h1>
		<% boolean men = false;
		ArrayList mensajes = (ArrayList)request.getAttribute("mensajes");
		if (mensajes != null) {
			for (int i=0; i < mensajes.size(); i++) {
				MensajeBean m = (MensajeBean)mensajes.get(i);
				if(mensajes.size() != 0) {
					men = true;
				}
			}
		}
		
		if (!men) { %>
			<jsp:forward page="nomensajes.jsp"/>
		
		<%
		}
		%>
		
		<form name="mensajesForm" action="${pageContext.request.contextPath}/Controlador">
			<input type="hidden" name="operacion" value="ver"/>
			<input type="hidden" name="nombre" value="<%=request.getParameter("nombre") %>"/>
			
			<jmesa:tableModel id="tag" items="${mensajes}" var="bean">
				<jmesa:htmlTable>
					<jmesa:htmlRow>
						<jmesa:htmlColumn property="remite" title="Remitente"/>
						<jmesa:htmlColumn property="destino" title="Destinatario"/>
						<jmesa:htmlColumn property="texto" title="Mensaje"/>
					</jmesa:htmlRow>
				</jmesa:htmlTable>
			</jmesa:tableModel>
		</form>
		<br><br>
		
		<a href="inicio.html">Inicio</a>
	</body>
</html>