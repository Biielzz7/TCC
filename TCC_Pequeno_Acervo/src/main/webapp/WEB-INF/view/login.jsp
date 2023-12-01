<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/login.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/css.css"/>'>
<title>Login</title>
</head>
<body>

     <!--  
     <div>
          <jsp:include page="menu.jsp"/>
     </div>
     -->
    <div class="login-box">
    <h2>Login</h2>
<form action="login" method="post">
  
    <div class="user-box">
        <input type="text" id="usuario" 
        name="usuario" required=""> 
          >
        <label>Usuario</label>
        </div>
        
        <div class="user-box">
        <input type="password" id="senha"
         name="senha"  required="">
        <label>Senha</label>
    </div>
      
      <div align ="center">
     <a >
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <button type="submit" id="botao" name="botao" value="Entrar">Entrar</button>
    </a>
           </div> 
           
      <div align="center">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <a href="index">Cancelar</a>
   
      <div align="center">
          <a href="usuario_cadastrar">Não tem cadastro? Faça um agora.</a>
      </div>
           </div> 

                 
</form>
       </div>
       
      <div class="mensagem" align="center">
		<c:if test="${not empty saida }">
			<H2><c:out value="${saida }" /></H2>
		</c:if>  
	  </div> 
	  
	        <div class="mensagem" align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>  
	  </div>
	   
</body>
</html>