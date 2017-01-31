<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar transacción</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>


	<%
		String user = (String) session.getAttribute("a_mensaje");
		if (user == null) {
			user = "";
		}

		String correo = (String) session.getAttribute("correo_login");
		if (correo == null) {
			correo = "";

		}
		
		String logout = "logout"; 
		
		String welcome = "Bienvenido, ";
	%>

	<div id="cabecera" class="cabecera" style="height: 83px">

		<a href="Menu.jsp"><img src="img/remesend6.jpg" style="vertical-align:middle; margin-top:0.5px"/></a>

		<span class="normal" style="font-size:16px; font-weight:bold;"><%=welcome%><%=user%></span> 
		
		<a href="logout?param=<%=logout%>" style="margin-left: 750px; color:white;">Cerrar sesión</a>


	</div>


	<div id="cuerpo" style="background-color: #ebebeb">

		<div style="height: 582px" align="center">
			<br><br> <label
				style="color: #0c59cf; font-family: Helvetica; font-size: 20px; text-align: center; font-weight:bold">¿Qué deseas hacer?</label> 
				<br><br><br> 
				<a
				href="llamardatos?usuario=<%=correo%>"><img alt="Administrar perfil"
				src="img/Perfil.png"></a> 
				<br>
				<br>
				<a href="Transferencia.jsp"><img
				alt="Realizar transferencia" src="img/Transf_blue_final.png"></a>


		</div>

	</div>

</body>
</html>