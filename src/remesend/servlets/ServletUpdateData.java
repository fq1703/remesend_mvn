package remesend.servlets;

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

import remesend.dto.Datos;
import remesend.dto.Usuario;


/**
 * Servlet implementation class ServletUpdateData
 */
public class ServletUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpdateData() {
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

	public boolean actualizar(String user, String nombres, String email,
			int dni, String pais, String ciudad, String direccion,
			String postal, int telefono, int dia, int mes, int año) {

		boolean flag = false;

		String sql = "SELECT * FROM remesend_db.tbusuarios where usuario=?";
		Usuario usuario = new Usuario();
		ResultSet rs;
		PreparedStatement ps = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (rs == null) {
				usuario = null;
			} else {
				rs.next();
				usuario.setId_usuario(rs.getInt(1));
				usuario.setUsuario(rs.getString(2));
				usuario.setPassword(rs.getString(3));
				usuario.setNombre(rs.getString(4));
				usuario.setTipou(rs.getString(5));
			}
			rs.close();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql3 = "INSERT INTO remesend_db.tbcompletardatos VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		String sql6 = "SELECT COUNT(ID_USUARIO) FROM remesend_db.tbcompletardatos WHERE id_usuario=?";

		String sql4 = "SELECT MAX(id_datos) FROM remesend_db.tbcompletardatos";

		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps6 = null;

		ResultSet rs2;
		ResultSet rs5;
		int count = 0;
		int maxid = 0;

		try {
			conn = this.getConnection();

			ps3 = conn.prepareStatement(sql4);

			rs2 = ps3.executeQuery();

			if (rs2 == null) {
				maxid = 1;
			} else {
				rs2.next();
				maxid = rs2.getInt(1);
				maxid = maxid + 1;

			}

			ps6 = conn.prepareStatement(sql6);
			ps6.setInt(1, usuario.getId_usuario());
			rs5 = ps6.executeQuery();
			rs5.next();
			count = rs5.getInt(1);

			if (count == 0) {

				ps2 = conn.prepareStatement(sql3);

				ps2.setInt(1, maxid);
				ps2.setInt(2, usuario.getId_usuario());
				ps2.setString(3, usuario.getNombre());
				ps2.setString(4, usuario.getUsuario());
				ps2.setString(5, "");
				ps2.setString(6, "");
				ps2.setString(7, "");
				ps2.setString(8, "");
				ps2.setInt(9, 0);
				ps2.setInt(10, 0);
				ps2.setInt(11, 0);
				ps2.setInt(12, 0);
				ps2.setInt(13, 0);

				ps2.executeUpdate();

				conn.close();

				ps2.close();

			} else {

				String sql2 = "UPDATE remesend_db.tbcompletardatos "
						+ "SET nombre =?, correo=?, pais=?, ciudad=?,"
						+ " direccion=?, cod_post=?, dni=?, dnac=?, mnac=?, anac=?, telef=? where correo=?";

				String sql5 = "UPDATE remesend_db.tbusuarios SET usuario=?, nombre=? where usuario=?";
				PreparedStatement ps4 = null;

				ps = conn.prepareStatement(sql2);
				ps4 = conn.prepareStatement(sql5);

				ps.setString(1, nombres);
				ps.setString(2, email);
				ps.setString(3, pais);
				ps.setString(4, ciudad);
				ps.setString(5, direccion);
				ps.setString(6, postal);
				ps.setInt(7, dni);
				ps.setInt(8, dia);
				ps.setInt(9, mes);
				ps.setInt(10, año);
				ps.setInt(11, telefono);
				ps.setString(12, user);
				ps4.setString(1, email);
				ps4.setString(2, nombres);
				ps4.setString(3, user);
				ps.executeUpdate();
				ps4.executeUpdate();
				conn.close();
				ps.close();
				ps4.close();
				flag = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * try { conn = this.getConnection();
		 * 
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 **/

		return flag;

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

	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);

		String user = (String) sesion.getAttribute("correo_login");
		
		String mensaje;

		String nombres = request.getParameter("user");
		String email = request.getParameter("email");
		int dni = Integer.parseInt(request.getParameter("dni"));
		String pais = request.getParameter("pais");
		String ciudad = request.getParameter("ciudad");
		String direccion = request.getParameter("direccion");
		String postal = request.getParameter("postal");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		int dia = Integer.parseInt(request.getParameter("dia"));
		int mes = Integer.parseInt(request.getParameter("mes"));
		int año = Integer.parseInt(request.getParameter("año"));

		boolean resultado = actualizar(user, nombres, email, dni, pais, ciudad, direccion, postal, telefono, dia, mes, año);

		if (resultado) {
			mensaje = "Datos guardados con exito";

		} else {

			mensaje = "Hubo un problema. Intentar de nuevo";

		}

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

		request.setAttribute("grabado", mensaje);

		request.getRequestDispatcher("/Perfil.jsp").forward(request, response);

	}
}
