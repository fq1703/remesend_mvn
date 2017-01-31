package trabajo.integrador.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trabajo.integrador.dto.Usuario;


/**
 * Servlet implementation class ServletLogueo
 */
public class ServletLogueo extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
  
    public ServletLogueo() {
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
	
    
	public Usuario validarUsuario(String u){ 
		
		String sql = "SELECT * FROM remesend_db.tbusuarios where usuario=?";
		Usuario usuario = new Usuario();
		ResultSet rs;
		PreparedStatement ps = null;
		try{
			conn= this.getConnection();
			ps= conn.prepareStatement(sql);
			ps.setString(1,u);
			rs = ps.executeQuery();
			if(rs == null){
				usuario = null;
			}else{
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
		}catch(SQLException e){
			e.printStackTrace();
		}

		return usuario; 
					
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  HttpSession sesion = request.getSession(true);
			String usuario = request.getParameter("user");
			String contraseña = request.getParameter("password");
			
		
		Usuario u = validarUsuario(usuario); 
				
		String mensaje="";	
		
		if (u.equals(null)) {
			mensaje = "Usuario o clave incorrecta";
			request.setAttribute("a_mensaje", mensaje);
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			
		} else if (contraseña.equals(u.getPassword())) {
			
			sesion.setAttribute("usr_login", u);
			sesion.setAttribute("a_mensaje", u.getNombre());
			sesion.setAttribute("correo_login", u.getUsuario());
			
						
			if (u.getTipou().equals("0")) {
				request.getRequestDispatcher("/Menu.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/iCliente.jsp").forward(request, response);
			}
		}
		else {
			mensaje = "Usuario o clave incorrecta";
			request.setAttribute("a_mensaje", mensaje);
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
		
		
		
		
	}

}
