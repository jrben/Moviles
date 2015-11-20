 <%@ page import="Hotel.modelo.vo.*, java.util.*" %>
 <link href="CSS/estilos.css" media="all" rel="stylesheet" type="text/css" />
 <center>
    <h1 class="title">HOTEL</h1>
    <img src="./Imagenes/Hotel.bmp" alt="Hotel" />
 </center>
<div class="wrapper">
  <nav class="vertical">
    <ul>
      <li>
        <label for="home">Home</label>
        <input type="radio" name="verticalMenu" id="home" />
        <div>
          <ul>
            <li><a href="#">Acerca de Nosotros</a></li>
            <li><a href="#">Item</a></li>
            <li><a href="#">Contactenos</a></li>
          </ul>
        </div>
      </li>
      <li>
        <label for="blog">Servicios</label>
        <input type="radio" name="verticalMenu" id="servicios" />
        <div>
          <ul>
            <li><a href="#">Reservar Habitacion</a></li>
            <li><a href="#">Modificar Reserva</a></li>
          </ul>
        </div>
      </li>
      <li>
        <label for="work">Cuenta</label>
        <input type="radio" name="verticalMenu" id="cuenta" />
        <div>
          <ul>
            <li><a href="#">Registrarse</a></li>
            <li><a href="#">Iniciar Sesion</a></li>
          </ul>
        </div>
      </li>
    </ul>
  </nav>
</div>
