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
<title>Editar de Emprestimo</title>
</head>
<body>
	<header>
		<div class = "caixa">
			<h1> <img src=./resources/images/fatec-zl.png src = "fatec-zl.png" alt="Logo inicial"> </h1>
		</div>
	</header>
	<main>
      	 <section class = "principal">
     <form action="emprestimo_editar" method="post">
     
     <p class = "tabela" align="center">Edição de Emprestimo</p>
     <div  class = "tabela">
           <table>
           
                   <tr>
                        <td hidden="hidden" ><input type="number" id="idEmprestimo" name="idEmprestimo" placeholder="ID Emprestimo"
                        value='<c:out value="${emprestimo.idEmprestimo }"></c:out>'></td>
                   </tr>

                   <tr>
                        <td hidden="hidden" ><input type="number" id="idItemEmprestimo" name="idItemEmprestimo" placeholder="ID Item Emprestimo"
                        value='<c:out value="${emprestimo.idItemEmprestimo }"></c:out>'></td>
                   </tr>
           </table>
           
                       <select id="estado" name="estado">
                            <option value="<c:out value="${emprestimo.estado }"></c:out>"><c:out value="${emprestimo.estado }"></c:out></option>
                            
                            <c:if test="${ emprestimo.estado == 'DEVOLVIDO'}">
                                 <option hidden= "hidden" value="DEVOLVIDO">DEVOLVIDO</option>    
                                 <option value="NAO DEVOLVIDO">NÃO DEVOLVIDO</option>
                                 <option value="EM ANDAMENTO">EM ANDAMENTO</option>                            
                            </c:if> 
                            
                            <c:if test="${ emprestimo.estado == 'NAO DEVOLVIDO'}">
                                 <option hidden= "hidden" value="NAO DEVOLVIDO">NÃO DEVOLVIDO</option>    
                                 <option value="EM ANDAMENTO">EM ANDAMENTO</option>
                                 <option value="DEVOLVIDO">DEVOLVIDO</option>                            
                            </c:if> 
                            
                            <c:if test="${ emprestimo.estado == 'EM ANDAMENTO'}">
                                 <option hidden= "hidden" value="EM ANDAMENTO">EM ANDAMENTO</option>   
                                 <option value="DEVOLVIDO">DEVOLVIDO</option> 
                                 <option value="NAO DEVOLVIDO">NÃO DEVOLVIDO</option>
                            </c:if>                            
                            

           
                       </select>
                         
      </div>
      
      <div>
          <table>
                 <tr>
                      <td> 
                        <input type="submit" id="botao" name="botao" value ="Salvar">
                        <input type="submit" id="botao" name="botao" value ="Cancelar">
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