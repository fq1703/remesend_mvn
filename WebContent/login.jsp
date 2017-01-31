<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Remesend</title>
	<link href="css/estilos.css" rel="stylesheet" type="text/css" />

</head>
<body>
	
	<div id="cabecera" class="cabecera" style="height: 83px">
	
	<img src="img/remesend6.jpg" style="margin-top: 0.5px"/>
	
	
	</div>
	
	<div id="cuerpo" style="background-color: #ebebeb">
	
	<div style= "height: 582px" align="center">
		<form method="post" action="login">

			
			<table border="0" class="etiqueta">
				
				<tr>
				
				<td align="center"> 
				<br>
				<img src="img/Login.jpg" />
				</td>
				</tr>
				
				<tr>
					
					<td align="center"><input type="text" name="user" size="30"
						style="text-align: left" placeholder="Correo electronico o nombre de usuario"></td>
				
				</tr>
				<tr>
				<td><br></td>
				</tr>
				<tr>
					
					<td align="center" valign="middle"><input type="password"
						name="password" size="30" style="text-align: left" placeholder="Contraseña"></td>
				</tr>
				
				<tr>
				<td><br></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="Ingresar">
				</tr>
				
				<%
					String mensaje = (String) request.getAttribute("a_mensaje");
					if (mensaje == null) {
						mensaje = "";
					}
				%>
				<tr>
				
					<td colspan="2" align="left" class="error"><%=mensaje%></td>
				</tr>

			</table>

		</form>

	</div>
</div>

</body>
</html>