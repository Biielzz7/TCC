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
<title>Gerenciamento de Usuarios</title>
</head>
<body>
	<c:out value="${usuario}"></c:out>
	<form action="usuario_acesso" method="post">
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
	   
	               
	               <li><a href="livro_listar">Livros</a>
	               
	               
	               <li><a href="emprestimo_listar">Emprestimos</a>
           		</ul>
           	</nav>
		</div>
	</header>
</form>
      
      <main>
      	 <section class = "principal">
     <form action="usuario_listar" method="post">

      <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>  
	  </div> 
	  
	  <br>
	  <br>
	  <br>
	  <br>	  
	  <div class="tabela" align="center">
		<c:if test="${not empty usuarios }">
			<table border="1">
				<thead>
					<tr>
						<th hidden="hidden">ID</th>
					    <th>Nome</th>
					    <th>Usuario</th>
					    <th>Senha</th>
						<th>CPF</th>					    
						<th>Data de Nascimento</th>
						<th>CEP</th>
						<th>Logradouro</th>
						<th>Numero de Endereço</th>
                        <th>Telefone</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios }" var="u">
						<tr>
							<td hidden="hidden"><c:out value="${u.idUsuario }"></c:out></td>
                            <td><c:out value="${u.nome }"></c:out></td>
                            <td><c:out value="${u.usuario }"></c:out></td>
                            <td><c:out value="${u.senha }"></c:out></td>
                            <td><c:out value="${u.cpf }"></c:out></td>
                            <td><c:out value="${u.dataNasc }"></c:out></td>
                            <td><c:out value="${u.cep }"></c:out></td>
                            <td><c:out value="${u.logradouro }"></c:out></td>
                            <td><c:out value="${u.numero_endereco }"></c:out></td>
                            <td><c:out value="${u.telefone }"></c:out></td>
                            
                            <td>
                            <a href="usuario_listar?cmd=alterar&idUsuario=${u.idUsuario }">ALTERAR</a>
                            </td>
                            
                            <td>
                            <a href="usuario_listar?cmd=excluir&idUsuario=${u.idUsuario }">EXCLUIR</a>
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