package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.modelo.servicio.ServicioCliente;
import Hotel.modelo.vo.Cliente;


@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registro() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		if(request.getParameter("nombreCliente").equals("")||request.getParameter("username").equals("") || request.getParameter("password1").equals("")){
			request.setAttribute("error","ERROR<br>Debe llenar todos los campos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
			rd.forward(request, response);
		}
		else{
			if(request.getParameter("password1").equals(request.getParameter("password2"))){ // comprueba si las contraseñas son iguales
				cliente.setUsername(request.getParameter("username"));
				cliente.setPassword(request.getParameter("password1"));
				cliente.setNombre(request.getParameter("nombreCliente"));
				ServicioCliente s = new ServicioCliente();
				if(s.ingresarCliente(cliente)==true){ // si se ingreso el usuario a la bd
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
				else{ // si no se ingreso porque ya existe el mismo username con otro usuario
					request.setAttribute("error","ERROR<br>Ya existe otro usuario con el mismo username");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
					rd.forward(request, response);
				}
			}
			else{//contraseñas 1 y 2 no coinciden
				request.setAttribute("error","ERROR<br>Las contraseñas ingresadas no coinciden");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
				rd.forward(request, response);
			}
		}

	}

}
