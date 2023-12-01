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
<title>Cadastrar Funcionario</title>
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
			</div>
		</header>
		<main>
      	 <section class = "principal">
     <form action="funcionario_cadastrar" method="post">
     <div class ="tabela">
           <table>
           
                   <tr>
                        <td hidden="hidden" ><input type="number" id="idFuncionrio" name="idFuncionario" placeholder="ID"></td>
                   </tr>
                              
                   <tr>
                        <td><input type="text" id="nome" name="nome" placeholder="Nome"></td>
                   </tr> 
                   
                   <tr>   
                        <td><input type="text" id="cpf" name="cpf" placeholder="CPF"></td>                       
                   </tr>
                   
                   <tr>    
                        <td><input type="text" id="cep" name="cep" placeholder="CEP"></td>
                   </tr>
                   
                   <tr>     
                        <td><input type="date" id="dataNasc" name="dataNasc" placeholder="Data de Nascimento">  Data de Nascimento</td>
                    </tr>
                    
                    <tr>
                        <td><input type="text" id="logradouro" name="logradouro" placeholder="Logradouro"></td>
                    </tr>
                    
                    <tr>    
                        <td><input type="number" id="numero_endereco" name="numero_endereco" placeholder="Numero do endereço"></td>
                    </tr>
                    
                    <tr>
                        <td><input type="number" id="telefone" name="telefone" placeholder="Telefone do Funcionario"></td>
                    </tr>                    
                    
                    <tr>
                        <td><input type="text" id="usuario" name="usuario" placeholder="Usuario do Funcionario"></td>
                    </tr>
                    
                    <tr>
                        <td><input type="text" id="senha" name="senha" placeholder="Senha do Funcionario"></td>
                    </tr>

                  <tr>
                      <td> 
                        <input type="submit" id="botao" name="botao" value ="Salvar">
                        <input type="submit" id="botao" name="botao" value ="Cancelar">
                      </td>

                  </tr>
           </table>
      </div>
      
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
  
      </form>
      </section>
      </main>
       <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

		</footer>
</body>
</html>