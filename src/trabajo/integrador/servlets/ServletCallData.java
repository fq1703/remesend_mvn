package trabajo.integrador.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trabajo.integrador.dto.Datos;

/**
 * Servlet implementation class ServletCallData
 */
public class ServletCallData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCallData() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/remesend_db?user=root&password=";

	private Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Datos obtenerperfil(String user) {

		Datos d = new Datos();

		String sql = "SELECT * FROM remesend_db.tbcompletardatos where correo=?";

		ResultSet rs;
		PreparedStatement ps = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (rs == null) {
				d = null;
			} else {
				rs.next();
				d.setId_datos(rs.getInt(1));
				d.setId_usuario(rs.getInt(2));
				d.setNombre(rs.getString(3));
				d.setCorreo(rs.getString(4));
				d.setPais(rs.getString(5));
				d.setCiudad(rs.getString(6));
				d.setDireccion(rs.getString(7));
				d.setCod_post(rs.getString(8));
				d.setDni(rs.getInt(9));
				d.setDnac(rs.getInt(10));
				d.setMnac(rs.getInt(11));
				d.setAnac(rs.getInt(12));
				d.setTelef(rs.getInt(13));

			}

			rs.close();
			conn.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return d;

	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	


		HttpSession sesion = request.getSession(true);

		
		
		String user = (String) sesion.getAttribute("correo_login");
		
		
		
		Datos datos = obtenerperfil(user);
		
		request.setAttribute("req_dni", datos.getDni()); 
		request.setAttribute("req_pais", datos.getPais()); 
		request.setAttribute("req_ciudad", datos.getCiudad()); 
		request.setAttribute("req_direc", datos.getDireccion()); 
		request.setAttribute("req_post", datos.getCod_post()); 
		request.setAttribute("req_telef", datos.getTelef()); 
		request.setAttribute("req_dia", datos.getDnac()); 
		request.setAttribute("req_mes", datos.getMnac());
		request.setAttribute("req_año", datos.getAnac());
		
		request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
		

	}

}
