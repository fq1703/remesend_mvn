<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Interfaz Transferencia</title>
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
	
	
	
	<script>
	
		function calcular(){
			
			  
			
			var montoinicial = document.getElementById("montoinicial").value;
			var tipoc = 197.9044;
			var monedainicial = document.getElementById("monedainicial").value; 
			var monedafinal = document.getElementById("monedafinal");
			var resultado = document.getElementById("montofinal");
			var comision = document.getElementById("comision");
			var monedacomision = document.getElementById("monedacomision");
			var com = 0; 
			
			resultadomoneda = "";
			miresultado = montoinicial;
			if (monedainicial == "PEN"){
					resultadomoneda = "CLP";
					com = montoinicial * 0.01;
					miresultado = (montoinicial * tipoc) - ((montoinicial*0.01)* tipoc);
					
					
			}else if (monedainicial == "CLP"){
				
					resultadomoneda = "PEN";
					com = montoinicial * 0.01;
					miresultado = (montoinicial/tipoc) - ((montoinicial*0.01)/tipoc);
					
				
			}
			resultado.value = parseFloat(Math.round(miresultado*100)/100).toFixed(2);
			monedafinal.value = resultadomoneda; 
			comision.value = parseFloat(Math.round(com*100)/100).toFixed(2); 
			monedacomision.value = monedainicial; 
			
		}
	
	</script>
	


	<div id="cabecera" class="cabecera" style="height: 83px">

		<a href="Menu.jsp"><img src="img/remesend6.jpg" style="vertical-align:middle; margin-top:0.5px"/></a>

		<span class="normal" style="font-size:16px; font-weight:bold;"><%=welcome%><%=user%></span> 
		
		<a href="logout?param=<%=logout%>" style="margin-left: 750px; color:white;">Cerrar sesión</a>


	</div>


	<div id="cuerpo" style="height: 582px; background-color: #ebebeb"
		align="left">


		<form method="post" action="guardartc">

			<br>
			<br> 
			
			<table border="0">


				<tr>
					<td align="left">Monto a cambiar</td>
					<td align="center"><input type="text" id="montoinicial" onchange="calcular()" name="montoinicial"
						size="15" style="text-align: right"/></td>

				</tr>
				<tr>
					<td align="left">Moneda inicial</td>
					<td><select id="monedainicial" name="monedainicial" onchange="calcular()">
							<option value="PEN">PEN</option>
							<option value="CLP">CLP</option>
					</select></td>

				</tr>

				<tr>
					<td><img src="img/minireme.jpg" /></td>
				</tr>


				<tr>
					<td align="left">Moneda final</td>
					
					<td align="left"><input type="text" id="monedafinal" name="monedafinal"
						size="3" style="text-align: left"/></td>

				</tr>
				<tr>
					<td align="left">Monto final</td>
					<td align="center"><input type="text" id="montofinal" name ="montofinal"
						size="15" style="text-align: right" /></td>

				</tr>
				
			</table>
			
			<table> 
				<tr>
					<td align="left" width="110px">Comisión </td>
					<td align="center"><input type="text" id="comision" name ="comision"
					size="6" style="text-align: right" /></td>
					<td align="center"><input type="text" id="monedacomision" name ="monedacomision"
					size="3" style="text-align: right" /></td>
				
				
				</tr>
			
				<tr><td><br></td>

				<tr><td><br></td>

				<tr>
					<td align="right" colspan="2"><button type="submit">Siguiente paso </button></td>
				</tr>
			
			</table>
			
			
		</form>





	</div>
</body>
</html>