<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
     <a>Bem-Vindo
       <c:out value="${usuario}"></c:out>
     </a>
      <form action="usuario_acesso" method="post">
      
      <nav >
           <ul>
               <li><a href="usuario_acesso">Inicio</a>
               
               <li><a href="usuario_livro_consultar">Livros</a>
               
               <li><a href="usuario_editar">Editar Informações</a>
               
               <li><a href="usuario_emprestimo">Meus Emprestimos</a>
               
               <li><a href="deslogar">Sair</a>
               
           </ul>
      </nav>
      
      </form>
</body>
</html>