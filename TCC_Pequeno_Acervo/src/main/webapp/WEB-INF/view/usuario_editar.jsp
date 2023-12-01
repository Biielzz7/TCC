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
<title>Edição de Usuario</title>
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
			 <nav >
           	 	<ul>
	          
	               
	               <li><a href="usuario_livro_consultar">Livros</a>
	               
	               <li><a href="usuario_editar">Informações</a>
	               
	               <li><a href="usuario_emprestimo">Emprestimos</a>

           		</ul>
           	</nav>
		</div>
	</header>

<main>
      	 <section class = "principal">
     <form action="usuario_editar" method="post">
     
     <p class = "tabela"align="center">Editar Informações</p>
     
     <div class = "tabela" align ="center">
           <table class = "tabela">
           
                   <tr>
                        <td hidden="hidden" ><input type="number" id="idUsuario" name="idUsuario" placeholder="ID"
                        value='<c:out value="${usuario.idUsuario }"></c:out>'></td>
                   </tr>
                              
                   <tr>
                        <td><input type="text" id="nome" name="nome" placeholder="Nome"
                        value='<c:out value="${usuario.nome }"></c:out>' required></td>
                   </tr> 
                   
                   <tr>   
                        <td><input type="text" id="cpf" name="cpf" placeholder="CPF"
                        value='<c:out value="${usuario.cpf }"></c:out>' required></td>                       
                   </tr>
                   
                   <tr>    
                        <td><input type="text" id="cep" name="cep" placeholder="CEP"
                        value='<c:out value="${usuario.cep }"></c:out>' required></td>
                   </tr>
                   
                   <tr>     
                        <td><input type="date" id="dataNasc" name="dataNasc" placeholder="Data de Nascimento"
                        value='<c:out value="${usuario.dataNasc }"></c:out>' required></td>
                    </tr>
                    
                    <tr>
                        <td><input type="text" id="logradouro" name="logradouro" placeholder="Logradouro"
                        value='<c:out value="${usuario.logradouro }"></c:out>' required ></td>
                    </tr>
                    
                    <tr>    
                        <td><input type="number" id="numero_endereco" name="numero_endereco" placeholder="Numero do endereço"
                        value='<c:out value="${usuario.numero_endereco }"></c:out>' required></td>
                    </tr>
                    
                    <tr>
                        <td><input type="number" id="telefone" name="telefone" placeholder="Telefone do Usuario"
                        value='<c:out value="${usuario.telefone }"></c:out>' required></td>
                    </tr>                    
                    
                    <tr>
                        <td><input type="text" id="usuario" name="usuario" placeholder="Nome do Usuario"
                        value='<c:out value="${usuario.usuario }"></c:out>' required></td>
                    </tr>
                    
                    <tr>
                        <td><input type="text" id="senha" name="senha" placeholder="Senha do usuario"
                        value='<c:out value="${usuario.senha }"></c:out>' required></td>
                    </tr>
 
                  <tr>
                      <td> 
                        <button type="submit" id="botao" name="botao" value ="Salvar">Salvar</button>
                        <button type="submit" id="botao" name="botao" value ="Cancelar">Cancelar</button>
                      </td>

                  </tr>
           </table>
      </div>
    
      
      <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>  
	  </div> 

      <div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
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