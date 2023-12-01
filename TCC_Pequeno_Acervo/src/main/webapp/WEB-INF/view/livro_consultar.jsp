<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/reset.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/style.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/css.css"/>'>
<title>Livros no Acervo</title>
</head>
<body>
  <header>
  		<div class="container">
	        <nav class="botoes">
	            <ul>        
	                <li><a href="login">Login</a>
	            </ul>
	        </nav>
	    </div> 
           <div class = "caixa">
				<h1> <img src=./resources/images/fatec-zl.png src = "fatec-zl.png" alt="Logo inicial"> </h1>
				<nav>
					<ul>
						<li><a href="index">Inicio</a>
						<li><a href = "livro_consultar">Livros</a></li>	
					</ul>
				</nav>
			</div>
     </header>
      
 <!--  
     <form action="livro_consultar" method="post">
        
      <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>  
	  </div> 
	  
	  <br>
	  <br>
	  <br>
	  <br>	 
	   
	  <div align="center">
		<c:if test="${not empty livros }">
			<table border="1">
				<thead>
					<tr>
						<th hidden="hidden">ID</th>
					    <th>Titulo</th>
					    <th>ISBN</th>
					    <th>Quantidade</th>
						<th>Editora</th>					    
						<th>Nome do Autor</th>
						<th>Tombo</th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${livros }" var="l">
						<tr>
							<td hidden="hidden"><c:out value="${l.idLivro }"></c:out></td>
                            <td><c:out value="${l.titulo }"></c:out></td>
                            <td><c:out value="${l.isbn }"></c:out></td>
                            <td><c:out value="${l.quantidade }"></c:out></td>
                            <td><c:out value="${l.editora }"></c:out></td>
                            <td><c:out value="${l.nomeAutor }"></c:out></td>
                            <td><c:out value="${l.tombo }"></c:out></td>
                            <td><c:out value="${l.disponibilidade }"></c:out></td>
                            
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>	
	 </div>	 
	   
	  
      </form>
      -->
    
      
      	<main>
      	 <section class = "principal">
			<ul class = "livros">
				<li>
					<h2>O Gênio Do Crime</h2>
					<img src = "./resources/images/genio.jpg"> 
					<p class = "descrição"></p>
					
				</li>
			
				<li>
					<h2>O Pequeno Principe</h2>
					<img src = "./resources/images/pequeno_principe.jpg"> 
					<p class = "descrição"></p>
					
				</li>
				<li>
					<h2>Sistemas Operacionais Modernos</h2>
					<img src = "./resources/images/sistemas_operacionais.jpg">
					<p class = "descrição"></p>
					
				</li>
				<li>
					<h2>O Paraiso Perdido</h2>
					<img src = "./resources/images/O_paraiso_perdido.jpg">
					<p class = "descrição"></p>
					
				</li>
				<li>
					<h2>Mapa do Universo Marvel</h2>
					<img src = "./resources/images/universo_marvel.jpg">
					<p class = "descrição"></p>
					
				</li>		
					
				<li><a href = "login">Clique aqui para ver nosso catalogo</a></li>
			</ul>
			</section>
		</main>
      
        <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>
		</footer> 
</body>
</html>