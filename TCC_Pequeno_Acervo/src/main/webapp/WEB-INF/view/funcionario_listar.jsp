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
<title>Gerenciamento de Funcionarios</title>
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
               
               			<li><a href="administrador_acesso">Inicio</a>
               
               			
					</ul>
				</nav>
			</div>
     </header>
      
     <main>
      	 <section class = "principal">
     <form action="funcionario_listar" method="post">
     
         
     <button type="submit" id="botao" name="botao" value="Adicionar" >Adicionar Funcionario</button>

      
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
		<c:if test="${not empty funcionarios }">
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
					<c:forEach items="${funcionarios }" var="f">
						<tr>
							<td hidden="hidden"><c:out value="${f.idFuncionario }"></c:out></td>
                            <td><c:out value="${f.nome }"></c:out></td>
                            <td><c:out value="${f.usuario }"></c:out></td>
                            <td><c:out value="${f.senha }"></c:out></td>
                            <td><c:out value="${f.cpf }"></c:out></td>
                            <td><c:out value="${f.dataNasc }"></c:out></td>
                            <td><c:out value="${f.cep }"></c:out></td>
                            <td><c:out value="${f.logradouro }"></c:out></td>
                            <td><c:out value="${f.numero_endereco }"></c:out></td>
                            <td><c:out value="${f.telefone }"></c:out></td>
                            
                            <td>
                            <a href="funcionario_listar?cmd=alterar&idFuncionario=${f.idFuncionario }">ALTERAR</a>
                            </td>
                            
                            <td>
                            <a href="funcionario_listar?cmd=excluir&idFuncionario=${f.idFuncionario }">EXCLUIR</a>
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
</body>
</html>