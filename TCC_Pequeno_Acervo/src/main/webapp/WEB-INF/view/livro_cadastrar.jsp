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
<title>Cadastro de Livro</title>
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
	
     <form action="livro_cadastrar" method="post">
     <div class ="tabela">
           <table>

                   <tr>
                        <td hidden="hidden"><input type="number" id="idLivro" name="idLivro" placeholder="ID do Livro"></td>
                   </tr> 
                             
                   <tr>
                        <td><input type="text" id="titulo" name="titulo" placeholder="Titulo do Livro"></td>
                   </tr> 
                   
                   <tr>   
                        <td><input type="text" id="isbn" name="isbn" placeholder="ISBN"></td>                       
                   </tr>
                   
                   <tr>    
                        <td><input type="number" id="quantidade" name="quantidade" placeholder="Quantidade"></td>
                   </tr>
                   
                   <tr>     
                        <td><input type="text" id="editora" name="editora" placeholder="Editora"></td>
                        
                    </tr>
                    
                    <tr>
                        <td><input type="text" id="nomeAutor" name="nomeAutor" placeholder="Nome do Autor"></td>
                    </tr>
                    
                    <tr>    
                        <td><input type="text" id="tombo" name="tombo" placeholder="Tombo"></td>
                    </tr>
                    
                   

                  
           </table>
      </div>
      
                    <select id="disponiblidade" name="disponibilidade">
                            <option value="">Selecione a Situação</option>
                            <option value="DISPONIVEL">DISPONIVEL</option>
                            <option value="INDISPONIVEL">INDISPONIVEL</option>
          
                   </select>
      
           <table>
                  <tr>
                      <td> 
                        <button type="submit" id="botao" name="botao" value ="Salvar">Salvar</button>
                        <button type="submit" id="botao" name="botao" value ="Cancelar">Cancelar</button>
    
                      </td>
                  </tr>   
          </table>   
              
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
      
      	<footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

		</footer>
</body>
</html>