package Hotel.modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hotel.modelo.vo.Cliente;


public class ServicioCliente {
	boolean existe = false;
	public boolean existeCliente(String username)
	{
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel","root","root");
			System.out.println("Conexión exitosa");
			PreparedStatement st = connection.prepareStatement("SELECT u FROM Usuario u WHERE u.username = '"+username+"'");
			st.execute();
			ResultSet rs = st.getResultSet();
			if(rs.next()){
				existe=true;
			}
			st.close();
			connection.close();
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return existe;
			
  	    	
	}
	
	public boolean ingresarCliente(Cliente usr){

    	
    	if(existeCliente(usr.getUsername())==false){
    		Cliente usuario = new Cliente();
    		usuario.setUsername(usr.getUsername());
    		usuario.setNombre(usr.getNombre());
    		usuario.setPassword(usr.getPassword());

    		return true;
    	}
    	else{
    		return false;
    	}
	}
	
	public int datosCliente(String username, String password)
	{
		Cliente Clientes= new Cliente();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel","root","root");
		System.out.println("Conexión exitosa");
		PreparedStatement st = connection.prepareStatement("SELECT u FROM Usuario u WHERE u.username = '"+username+"' AND u.password = '"+ password+"'");
		st.execute();
		ResultSet rs = st.getResultSet();
		if(st.getResultSet().next())
    	{
    		return -1;
    	}
    	else
    	{
    		int id=-1;
    		List<Cliente> lista=(List<Cliente>)st.getResultSet();
    	    for( Cliente u:lista )
    	    {    	    	
    	    	id=u.getId_cliente();
    	    }
    	    return id;
    	}  
	}catch(Exception e){
		e.printStackTrace();
	}
		return Clientes;
	}
}


