<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Interfaz Transferencia 2</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<%
		String user = (String) session.getAttribute("a_mensaje");
		if (user == null) {
			user = "";
		}
		
		String nombrecompleto = (String) session.getAttribute("ses_nombrecompleto");  
		if (nombrecompleto == null){
			
			nombrecompleto = user; 
			
		}
		
		
		String correo = (String) session.getAttribute("correo_login");
		if (correo == null) {
			correo = "";

		}
		
		String email = (String) session.getAttribute("ses_email");  
		if (email == null){
			
			email = correo; 
			
		}
		
		String ncuenta = (String) session.getAttribute("ses_ncuenta");  
		if (ncuenta == null){
			
			ncuenta = ""; 
			
		}
		
		String logout = "logout"; 
		String welcome = "Bienvenido, ";
		
	%>


	<div id="cabecera" class="cabecera" style="height: 83px">

		<a href="Menu.jsp"><img src="img/remesend6.jpg" style="vertical-align:middle; margin-top:0.5px"/></a>

		<span class="normal" style="font-size:16px; font-weight:bold;"><%=welcome%><%=user%></span> 
		
		<a href="logout?param=<%=logout%>" style="margin-left: 750px; color:white;">Cerrar sesión</a>


	</div>


	<div id="cuerpo" style="height: 582px; background-color: #ebebeb"
		align="left">


		<form method="post" action="guardarcuenta">

			<br>

			<table border="0">

				<tr>
					<td align="left">Nombre completo del titular de la cuenta</td>
					
				</tr>
				<tr>
					<td align="right" colspan="2"><input name="nombrecompleto" type="text" size="50" 
					/></td>
				</tr>
				<tr>
				<td></td>
				</tr>
			
				<tr>
					<td align="left">Correo electrónico</td>
					
				</tr>
				<tr>
					<td align="left" colspan="2"><input name="email" type="text" size="20"
					/></td>
				</tr>
				
				<tr>
				<td></td>
				</tr>			

				<tr>
					<td align="left">Número de la cuenta</td>
					
				</tr>
				<tr>
					<td align="right" colspan="2"><input name="ncuenta" type="text" size="50"
					 /></td>
				</tr>

			<tr><td><br></td>

			<tr><td><br></td>


				<tr>
					<td align="left" colspan="2"><a href="Transferencia.jsp" >Atrás </a></td>
					<td align="right" colspan="2"><button type="submit">Siguiente paso </button></td>
				</tr>


			</table>
		</form>





	</div>
</body>
</html>