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
<title>Gerenciamento de Livro</title>
</head>
<body>
<form action="funcionario_acesso" method="post">
	<header>
	    	<div class="container">
	        	<nav class="botoes">
	            	<ul>        
	                	<li><a href="deslogar">Sair</a>
	                </ul>
	            </nav>
	        </div> 

		<div class = "caixa">
			<h1> <img src=./resources/images/fatec-zl.png src = "fatec-zl.png" alt="Logo inicial"> </h1>
			<nav >
           		<ul>
	               <li><a href="funcionario_acesso">Inicio</a>
	           
	               <li><a href="livro_listar">Livros</a>
	               
	               <li><a href="usuario_listar">Usuarios</a>
	              
	               <li><a href="emprestimo_listar">Emprestimos</a>
          		</ul>
      		</nav>
		</div>
		</header>
    </form>

<main>
      	 <section class = "principal">
     <form action="livro_listar" method="post">
     
         
     <button type="submit" id="botao" name="botao" value="Adicionar" >Adicionar Livro</button>

      
      <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>  
	  </div> 
	  
	  <br>
	  <br>
	  <br>
	  <br>	  
	  <div class ="tabela" align="center">
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
                            
                            <td>
                            <a href="livro_listar?cmd=alterar&idLivro=${l.idLivro }">ALTERAR</a>
                            </td>
                            
                            <td>
                            <a href="livro_listar?cmd=excluir&idLivro=${l.idLivro }">EXCLUIR</a>
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>	
	 </div>	  
	  
      </form> 
      </section>
      </main>
		<footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

		</footer>    
</body>
</html>