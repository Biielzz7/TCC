<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/reset.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/style.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/css.css"/>'>
<title>Area do Administrador</title>
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
				<nav>
					<ul>
			   			<li><a href="administrador_acesso">Inicio</a>
               
              			 <li><a href="funcionario_listar">Bibliotecarios</a>
               
					</ul>
				</nav>
			</div>
     </header>


   <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>
	</footer> 
</body>
</html>