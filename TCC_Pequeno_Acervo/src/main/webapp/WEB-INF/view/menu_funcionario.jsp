<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area do Bibliotecarios</title>
</head>
<body>
     <a>Bem-Vindo
       <c:out value="${funcionario}"></c:out>
     </a>
      <form action="funcionario_acesso" method="post">
      <nav >
           <ul>
               <li><a href="funcionario_acesso">Inicio</a>
           
               <li><a href="livro_listar">Livros</a>
               
               <li><a href="usuario_listar">Usuarios</a>
              
               <li><a href="emprestimo_listar">Emprestimos</a>
               
               <li><a href="deslogar">Sair</a>
               
           </ul>
      </nav>
      </form>
</body>
</html>