<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/login.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/css.css"/>'>
<title>Gerenciamento de Usuarios</title>
</head>
<body>
     <!--  
     <div>
          <jsp:include page="menu.jsp"/>
     </div>
     --> 

<div class="login-box">
    <h2>Cadastrar</h2>
<form action="usuario_cadastrar" method="post">
    <div class="user-box">
        <input type="text" name="nome" id="nome" required="required">
        <label>Nome</label>
    </div>
    <div class="user-box">
        <input type="number" name="cpf" id="cpf" required="required">
        <label>CPF</label>
    </div>

    <div class="user-box">
        <input type="number" name="cep" id="cep" required="required">
        <label>CEP</label>
    </div>

    <div class="user-box">
        <input type="date" name="dataNasc" id="dataNasc" required="required">
        <label>Data de Nascimento</label>
    </div>

    <div class="user-box">
        <input type="text" name="logradouro" id="logradouro" required="required">
        <label>Logradouro</label>
    </div>

    <div class="user-box">
        <input type="number" name="numero_endereco" id="numero_endereco" required="required">
        <label>Numero Endereço</label>
    </div>

    <div class="user-box">
        <input type="number" name="telefone" id="telefone" required="required">
        <label>Telefone</label>
    </div>

    <div class="user-box">
        <input type="text" name="usuario" id="usuario" required="required">
        <label>Usuario</label>
    </div>

    <div class="user-box">
        <input type="password" name="senha" id="senha" required="required">
        <label>Senha</label>
    </div>
	<div align ="center">
    <a>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <button type="submit" id="botao" name="botao" value="salvar">CADASTRAR</button>
    </a>
    </div>
    
     <div align="center">
  
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <a href="index">CANCELAR</a>

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
</form> 
</div>
    
</body>
</html>