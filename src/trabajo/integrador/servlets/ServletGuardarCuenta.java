package trabajo.integrador.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletGuardarCuenta
 */
public class ServletGuardarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletGuardarCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		
		String nombrecompleto = request.getParameter("nombrecompleto");
		String correofinal = request.getParameter("email");
		String ncuenta = request.getParameter("ncuenta");
		
		sesion.setAttribute("ses_nombrecompleto", nombrecompleto); 
		sesion.setAttribute("ses_correofinal", correofinal); 
		sesion.setAttribute("ses_ncuenta", ncuenta); 
		
		
		request.getRequestDispatcher("/Transferencia3.jsp").forward(request,
				response);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
