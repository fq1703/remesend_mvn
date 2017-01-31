<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Interfaz Transferencia 3</title>
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

		String nombrecompleto = (String) session
				.getAttribute("ses_nombrecompleto");
		String correofinal = (String) session
				.getAttribute("ses_correofinal");
		String ncuenta = (String) session.getAttribute("ses_ncuenta");

		String montoinicial = (String) session
				.getAttribute("ses_montoinicial");
		String montofinal = (String) session.getAttribute("ses_montofinal");
		String monedainicial = (String) session.getAttribute("ses_monedainicial");
		String monedafinal =  (String) session.getAttribute("ses_monedafinal");
		
		String comision =  (String) session.getAttribute("ses_comision");
		
		
		String logout = "logout";
		String welcome = "Bienvenido, ";
		
		String alerta  = (String) request.getAttribute("alerta"); 
		
		String msgtc = (String) session.getAttribute("ses_tipoc");
		 
		String msgcom = "   75% menor vs otros bancos"; 
		
	%>



	<div id="cabecera" class="cabecera" style="height: 83px">

		<a href="Menu.jsp"><img src="img/remesend6.jpg" style="vertical-align:middle; margin-top:0.5px"/></a>

		<span class="normal" style="font-size:16px; font-weight:bold;"><%=welcome%><%=user%></span> 
		
		<a href="logout?param=<%=logout%>" style="margin-left: 750px; color:white;">Cerrar sesión</a>


	</div>


	<div id="cuerpo" style="height: 582px; background-color: #ebebeb"
		align="left">


		<form method="post" action="procesar">


			<br>
			<p style="font-size: 24px; font-color: blue; font-weight: bold;">Resumen</p>

			<table border="0">
			<tr>
					<td width=22.2% align="left">Cantidad a tr </td>
					<td align="left"><input type="text" size="5"  value="<%=monedainicial %>" disabled></td>
					<td ></td>
					<td ><input type="text" size="8" value="<%= montoinicial%>" disabled></td>
					<td ></td>
					<td ><img src="img/minireme.jpg" height="20px" width="20px"></td>
					<td ></td>
					<td align="right"><input type="text" size="5"  value="<%=monedafinal%>" disabled></td>
					<td ></td>
					<td ><input type="text" size="8" value="<%=montofinal%>" disabled></td>

			</tr>
			<tr><td><br></td></tr>
			<tr>
					<td width=22.2% align="left">Comisión </td>
					<td align="left"><input type="text" size="5"  value="<%=monedainicial%>" disabled></td>
					<td ></td>
					<td ><input type="text" size="8" value="<%=comision%>" disabled></td>
			
			</tr>
			
			</table>


			<table border="0">

				
				<tr><td width=25%><br></td></tr>
				<tr>
					<td  align="left">Destinatario</td>
					<td colspan="4"><input type="text" size="40" value="<%=nombrecompleto%>" disabled></td>
					
				</tr>
				<tr><td><br></td></tr>
				<tr>
					<td align="left">Correo</td>
					<td colspan="3"><input type="text" size ="20" value="<%=correofinal%>" disabled></td>
					
				</tr>
				<tr><td><br></td></tr>
				<tr>
					
					<td align="left">Nro. Cuenta</td>
					<td colspan="3"><input type="text" size="30" value="<%=ncuenta%>" disabled></td>
					
				</tr>
				


			</table>
			
			
			<p style="font-size: 24px; font-color: blue; font-weight: bold;">Beneficios</p>
			
			<table>
			<tr>
			<td width=30% align="left">Tipo Cambio </td>
					<td align="left"><input type="text" size="6"  value="197.09" disabled>
					<label style="color:#b70f0a"><%=msgtc %></label></td>
					
			</tr>
			<tr><td><br></td></tr>
			<tr>
			<td align="left">Comisión </td>
					<td align="left"><label style="color:#b70f0a"><%=msgcom %></label></td>
					
			</tr>
			
			
			</table>
			
			<table>
			
				<tr>
					<td><br></td></tr>
				<tr>
					<td align="left" colspan="1"><a href="Transferencia2.jsp">Atrás
					</a></td>
					<td width="300px"></td>
					<td align="right" colspan="2"><button type="submit">Procesar
							transacción</button></td>
				</tr>
			
			</table>
			
			
		</form>


	</div>
</body>
</html>