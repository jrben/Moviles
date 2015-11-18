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
            <li><a href="#">Index</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Corporate</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </div>
      </li>
      <li>
        <label for="blog">Blog</label>
        <input type="radio" name="verticalMenu" id="blog" />
        <div>
          <ul>
            <li><a href="#">Articles</a></li>
            <li><a href="#">Inspiration</a></li>
            <li><a href="#">Tutorials</a></li>
          </ul>
        </div>
      </li>
      <li>
        <label for="work">Work</label>
        <input type="radio" name="verticalMenu" id="work" />
        <div>
          <ul>
            <li><a href="#">Client Login</a></li>
            <li><a href="#">Get Quote</a></li>
            <li><a href="#">Portfolio</a></li>
          </ul>
        </div>
      </li>
    </ul>
  </nav>
</div>
