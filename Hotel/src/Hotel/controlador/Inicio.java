package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hotel.modelo.servicio.ServicioCliente;
import Hotel.modelo.vo.Cliente;


@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);	
		
		ServicioCliente servicio = new ServicioCliente();
		Cliente cliente = new Cliente();		

		cliente.setUsername(request.getParameter("username"));		
		
		int idCliente=servicio.datosCliente(request.getParameter("username"),request.getParameter("password"));
		//si los datos ingresados son correctos
		if(idCliente>0){
			session.setAttribute("username", cliente.getUsername());
			session.setAttribute("idCliente", idCliente);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home");
			rd.forward(request, response);
		}
		//si los datos ingresados son incorrectos
		else
		{
			request.setAttribute("error","ERROR<br>Los datos ingresados son incorrectos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

}
