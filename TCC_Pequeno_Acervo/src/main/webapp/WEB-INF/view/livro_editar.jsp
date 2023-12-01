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
<title>Area de Itens</title>
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

     <form action="livro_editar" method="post">
     
     <a>Edição de Livro</a>
     
     <div>
           <table>

                   <tr>
                        <td hidden="hidden"><input type="number" id="idLivro" name="idLivro" placeholder="ID do Livro"
                        value='<c:out value="${livro.idLivro }"></c:out>'></td>
                   </tr> 
                             
                   <tr>
                        <td><input type="text" id="titulo" name="titulo" placeholder="Titulo do Livro"
                        value='<c:out value="${livro.titulo }"></c:out>' required ></td>
                   </tr> 
                   
                   <tr>   
                        <td><input type="text" id="isbn" name="isbn" placeholder="ISBN"
                        value='<c:out value="${livro.isbn }"></c:out>' required ></td>                       
                   </tr>
                   
                   <tr>    
                        <td><input type="number" id="quantidade" name="quantidade" placeholder="Quantidade"
                        value='<c:out value="${livro.quantidade }"></c:out>' required ></td>
                   </tr>
                   
                   <tr>     
                        <td><input type="text" id="editora" name="editora" placeholder="Editora"
                        value='<c:out value="${livro.editora }"></c:out>' required ></td>
                        
                    </tr>
                    
                    <tr>
                        <td><input type="text" id="nomeAutor" name="nomeAutor" placeholder="Nome do Autor"
                        value='<c:out value="${livro.nomeAutor }"></c:out>' required ></td>
                    </tr>
                    
                    <tr>    
                        <td><input type="text" id="tombo" name="tombo" placeholder="Tombo"
                        value='<c:out value="${livro.tombo }"></c:out>' required ></td>
                    </tr>
                  

           </table>
                   <select id="disponiblidade" name="disponibilidade">
                            <option value="<c:out value="${livro.disponibilidade }"></c:out>"><c:out value="${livro.disponibilidade }"></c:out></option>
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
      </div>
      </form>   
      
        <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

		</footer>    
</body>
</html>