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
<title>Gerenciamento de Emprestimos</title>
</head>
<body>
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
				<nav>
					<ul>
           
              		  <li><a href="livro_listar">Livros</a>
               
               		  <li><a href="usuario_listar">Usuarios</a>
              
               		  <li><a href="emprestimo_listar">Emprestimos</a>

					</ul>
				</nav>
			</div>
		</header>
     

<!--      
     <form action="emprestimo_listar" method="get">
      <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>  
	  </div> 
     </form>
 --> 
 <main>
      	 <section class = "principal">
     <div class ="tabela" align="center">
		<form action="gerar_relatorio_emprestimo" method="post" target="_blank">
			<table>
			    <tr><td>Informe a data para gerar o relatorio do periodo:</td></tr>
				<tr>			    
					<td>
						<input type="date" id="data" name="data" placeholder="data">
					</td>
					<td>
						<button type="submit" id="botao" name="botao" value="Gerar">Gerar Realatorio</button>
					</td>
				</tr>
			</table>
		</form>
   
	</div>
     <form action="emprestimo_listar" method="post">   
           <button type="submit" id="botao" name="botao" value="Adicionar">Cadastrar Emprestimo</button>
     </form>
     
     <form action="emprestimo_listar" method="get">
     
	  
	  <br>
	  <br>
	  <br>
	  <br>	  
	  <div class = "tabela"align="center">
		<c:if test="${not empty emprestimos }">
			<table border="1">
				<thead>
					<tr>
						<th hidden="hidden">ID Emprestimos</th>
					    <th>Data do Emprestimo</th>
					    <th>Data da Devolução</th>					    
						<th>Titulo</th>
						<th>Usuario Requerente</th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${emprestimos }" var="e">
						<tr>
							<td hidden="hidden"><c:out value="${e.idEmprestimo }"></c:out></td>
                            <td><c:out value="${e.dataEmprestimo }"></c:out></td>
                            <td><c:out value="${e.dataDevolucao }"></c:out></td>
                            <td><c:out value="${e.titulo }"></c:out></td>
                            <td><c:out value="${e.usuario }"></c:out></td>
                            <td><c:out value="${e.estado }"></c:out></td>
                            
                            <td>
                            <a href="emprestimo_listar?cmd=alterar&idEmprestimo=${e.idEmprestimo }">ALTERAR</a>
                            </td>
                            
                            <td>
                            <a href="emprestimo_listar?cmd=excluir&idEmprestimo=${e.idEmprestimo }">EXCLUIR</a>
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>	
	 </div>
	 
	 	  
     </form>
     
     <br />
	 <br />
	 <br />
	 <br />
	 <br />
	 <br />
	 <br />
	 <br />

	 <div align="center">
		<c:if test="${not empty saida }">
			<H2><c:out value="${saida }" /></H2>
		</c:if>
     </div> 
	 
	 <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
     </div>   
	
	 

	
	<br />
	<br />
	</section>
	</main>
	 <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

	</footer>
 
</body>
</html>