package trabajo.integrador.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletGuardarTC
 */
public class ServletGuardarTC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuardarTC() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		String montoinicial = request.getParameter("montoinicial");
		String montofinal = request.getParameter("montofinal");
		String monedainicial = request.getParameter("monedainicial");
		String monedafinal = request.getParameter("monedafinal");
		String comision = request.getParameter("comision"); 
		
		sesion.setAttribute("ses_montoinicial", montoinicial); 
		sesion.setAttribute("ses_montofinal", montofinal); 
		sesion.setAttribute("ses_monedainicial", monedainicial); 
		sesion.setAttribute("ses_monedafinal", monedafinal);
		sesion.setAttribute("ses_comision", comision);
		
		
		String tc = "";
		if (monedainicial.equals("PEN")){
			tc = "   vs 192.11 de otros bancos";
		}else{
			tc = "   vs 205.32 de otros bancos";
		}
		
		sesion.setAttribute("ses_tipoc", tc);
		
		
		request.getRequestDispatcher("/Transferencia2.jsp").forward(request,
				response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
