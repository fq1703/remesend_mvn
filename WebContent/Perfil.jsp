<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Perfil</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>


	<%
		String usuario = (String) session.getAttribute("a_mensaje");
		
		if (usuario == null) {
			usuario = "";
		}

		String correo = (String) session.getAttribute("correo_login");
		if (correo == null) {
			correo = "";

		}

		int dni= 0; 
		if (request.getAttribute("req_dni")==null){
			
			dni = 0; 
			
		}else{
			
			 dni = (Integer) request.getAttribute("req_dni"); 
			
		}
		

		String pais = (String) request.getAttribute("req_pais");
		if (pais == null) {
			pais = "";

		}

		String ciudad = (String) request.getAttribute("req_ciudad");
		if (ciudad == null) {
			ciudad = "";

		}

		String direc = (String) request.getAttribute("req_direc");
		if (direc == null) {
			direc = "";

		}

		String postal = (String) request.getAttribute("req_post");
		if (postal == null) {
			postal = "";

		}

		int telef; 
		if (request.getAttribute("req_telef")==null){
			
			 telef = 0;
		}else{
			 telef = (Integer) request.getAttribute("req_telef");
		}
		
		int dia; 
		if (request.getAttribute("req_dia")==null){
			
			 dia = 0;
			
		}else{
			
			 dia = (Integer) request.getAttribute("req_dia"); 
		}
		
		int mes; 
		if (request.getAttribute("req_mes")==null){
			
			mes = 0;
			
		}else{
			mes = (Integer) request.getAttribute("req_mes");
		}
		
		int año; 
		if (request.getAttribute("req_año") ==null){
			
			año = 0; 
		}else{
			
			año = (Integer) request.getAttribute("req_año");
		}
		

		String grabado = (String) request.getAttribute("grabado");
		if (grabado == null) {
			grabado = "";

		}
		
		String logout = "logout"; 
		
		String welcome = "Bienvenido, ";
	%>

	<div id="cabecera" class="cabecera" style="height: 83px">

		<a href="Menu.jsp"><img src="img/remesend6.jpg" style="vertical-align:middle; margin-top:0.5px"/></a>

		<span class="normal" style="font-size:16px; font-weight:bold;"><%=welcome%><%=usuario%></span> 
		
		<a href="logout?param=<%=logout%>" style="margin-left: 750px; color:white;">Cerrar sesión</a>


	</div>


	<div id="cuerpo" style="height: 582px; background-color: #ebebeb"
		align="left">

		<br>

		<p class="otro">Por favor termina de completar tus datos. Recuerda
			que todos los campos son obligatorios.</p>

		<br>
		<form method="post" action="actualizardatos">
			<table border="0" style="margin-left:25px">


				<tr>
					<td align="left">Nombres</td>
					<td align="center"><input type="text" name="user" size="30"
						style="text-align: left" value="<%=usuario%>"></td>

				</tr>
				<tr>
					<td><br></td>
				</tr>

				<tr>

					<td align="left">E-mail</td>
					<td align="center" valign="middle"><input type="text"
						name="email" size="30" style="text-align: left"
						value="<%=correo%>" disabled></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>

				<tr>

					<td align="left">DNI</td>
					<td align="center" valign="middle"><input type="text"
						name="dni" size="30" style="text-align: left" value=<%=dni%>></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>


				<tr>

					<td align="left">País</td>
					<td align="center" valign="middle"><input type="text"
						name="pais" size="30" style="text-align: left" value="<%=pais%>"></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>

				<tr>

					<td align="left">Ciudad</td>
					<td align="center" valign="middle"><input type="text"
						name="ciudad" size="30" style="text-align: left"
						value="<%=ciudad%>"></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>


				<tr>

					<td align="left">Dirección</td>
					<td align="center" valign="middle"><input type="text"
						name="direccion" size="30" style="text-align: left"
						value="<%=direc%>"></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>


				<tr>

					<td align="left">Código Postal</td>
					<td align="center" valign="middle"><input type="text"
						name="postal" size="30" style="text-align: left"
						value="<%=postal%>"></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>


				<tr>

					<td align="left">Teléfono</td>
					<td align="center" valign="middle"><input type="text"
						name="telefono" size="30" style="text-align: left"
						value=<%=telef%>></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>

			</table>

			<table style="margin-left:25px">
				<tr>

					<td align="left">Fecha Nacim.</td>
					<td align="center" valign="middle"><input type="text"
						name="dia" size="2" style="text-align: left" value=<%=dia%>></td>
					<td align="center" valign="middle"><input type="text"
						name="mes" size="2" style="text-align: left" value=<%=mes%>></td>
					<td align="center" valign="middle"><input type="text"
						name="año" size="4" style="text-align: left" value=<%=año%>></td>
				</tr>

				<tr>
					<td><br></td>
					
				</tr>


				<tr>
					<td align="right" colspan="5"><input type="submit"
						value="Grabar">
				</tr>


			</table>


		</form>

		<p class="error"><%=grabado%></p>


	</div>

</body>
</html>