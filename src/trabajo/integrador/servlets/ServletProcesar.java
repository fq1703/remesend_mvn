package trabajo.integrador.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;



import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletProcesar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProcesar() {
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

	@SuppressWarnings("restriction")
	public void enviarmail(String nomcompleto, String correofinal,
			String nrocuenta, String montoinicial, String montofinal,
			String monedainicial, String monedafinal, String nomusuario, String usuario) {

		String texto = "SOLICITADO POR: " + nomusuario + " / " + usuario + "\n" +
				"NOMBRE DEL TITULAR DE LA CUENTA: " + nomcompleto + "\n" + "CORREO TITULAR: "
				+ correofinal + "\n" + "NRO CUENTA: " + nrocuenta + "\n"
				+ "MONTO A TRANSFERIR: " + montofinal + " " + monedafinal
				+ "\n" + "MONTO ORIGINAL: " + montoinicial + " "
				+ monedainicial;

		try {

			String host = "smtp.gmail.com";
			String user = "remesend@gmail.com";
			String password = "Remesend123";
			String to = usuario;
			String to2 = "remesend@gmail.com"; 
			String from = "remesend@gmail.com";
			String asunto = "Se ha registrado una nueva transacción";
			String mensaje = texto;
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			java.security.Security
					.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session sesion = Session.getDefaultInstance(props, null);
			sesion.setDebug(sessionDebug);
			Message msg = new MimeMessage(sesion);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to), new InternetAddress(to2) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(asunto);
			msg.setSentDate(new Date());
			msg.setText(mensaje);

			Transport transport = sesion.getTransport("smtp");
			transport.connect(host, user, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertardata (String usuario, String montoinicial, String monedainicial,
			String montofinal, String monedafinal, String nrocuenta){
		
		
		String sql = "SELECT ID_USUARIO FROM remesend_db.tbusuarios where usuario=?";
		String sql2 = "INSERT INTO remesend_db.tbtransaccion VALUES (?,?,?,?,?,?,?,?)";
		String sql3 = "SELECT MAX(ID_TX) FROM remesend_db.tbtransaccion";
		
		ResultSet rs;
		ResultSet rs3;
		
		PreparedStatement ps = null;
		
		PreparedStatement ps2 = null;
		
		PreparedStatement ps3 = null;
		
		int idusuario; 
		int idtx = 0; 
		
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario);
			
			rs = ps.executeQuery();
			if (rs == null) {
				idusuario = 0;
			} else {
				rs.next();
				idusuario = rs.getInt(1);
			}
			
			ps3 = conn.prepareStatement(sql3);
			rs3 = ps3.executeQuery();
			
			if (rs3 == null){
				idtx = 1; 
			}else{
				rs3.next(); 
				idtx = rs3.getInt(1); 
				idtx = idtx + 1; 
			}
			
			
			ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, idtx);
			ps2.setInt(2, idusuario);
			ps2.setString(3, usuario);
			ps2.setString(4, montoinicial);
			ps2.setString(5, monedainicial);
			ps2.setString(6, montofinal);
			ps2.setString(7, monedafinal);
			ps2.setString(8, nrocuenta);
			
			ps2.executeUpdate(); 
			
			rs.close();
			rs3.close();
			conn.close();
			ps.close();
			ps2.close();
			ps3.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);

		String nomusuario = (String) ses.getAttribute("a_mensaje");
		String usuario = (String) ses.getAttribute("correo_login"); 
		String nomcompleto = (String) ses.getAttribute("ses_nombrecompleto");
		String correofinal = (String) ses.getAttribute("ses_correofinal");
		String nrocuenta = (String) ses.getAttribute("ses_ncuenta");
		String montoinicial = (String) ses.getAttribute("ses_montoinicial");
		String montofinal = (String) ses.getAttribute("ses_montofinal");
		String monedainicial = (String) ses.getAttribute("ses_monedainicial");
		String monedafinal = (String) ses.getAttribute("ses_monedafinal");

		//Insertar datos en BD 
		insertardata(usuario, montoinicial, monedainicial, montofinal, monedafinal, nrocuenta);
		
		//Se envia mail
		enviarmail(nomcompleto, correofinal, nrocuenta,
				montoinicial, montofinal, monedainicial, monedafinal, nomusuario, usuario);

		
		//Se muestra la pagina con el mensaje 
		request.getRequestDispatcher("/Transferencia4.jsp").forward(request,
				response);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
