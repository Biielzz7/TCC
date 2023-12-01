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

<title>Registro de Emprestimo</title>
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
     <form action="emprestimo_cadastrar" method="post">
     <div class = "tabela">
                    
                       <select id="titulo" name="titulo">
                            <option value="">Selecione um Titulo</option>
                            <c:if test="${not empty livros }">
                                <c:forEach items="${livros }" var="l">
                                          <option><c:out value="${l.titulo }"></c:out></option>
                                </c:forEach>
                            </c:if>           
                       </select>
                    
                           
                    
                       <select id="usuario" name="usuario">
                            <option value="">Selecione o Usuario</option>
                            <c:if test="${not empty usuarios }">
                                <c:forEach items="${usuarios }" var="u">
                                          <option><c:out value="${u.nome }"></c:out></option>
                                </c:forEach>
                            </c:if>           
                           </select>
                    
           <table>
                        
                    <tr>     
                        <td><input type="date" id="dataEmprestimo" name="dataEmprestimo" placeholder="Data de Emprestimo"
                        value='<c:out value="${usuario.dataEmprestimo }"></c:out>'>  Data de Emprestimo</td>
                        
                    </tr>
                   
                   <tr>     
                        <td><input type="date" id="dataDevolucao" name="dataDevolucao" placeholder="Data de Devoluçao"
                        value='<c:out value="${usuario.dataDevolucao }"></c:out>'>  Data de Devolução</td>
                        
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
      </form> 
      </section>
      </main>
       <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

		</footer>
</body>
</html>