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

<title>Bem-vindo(a)</title>

</head>
<body>
	<header>
    	<div class="container">
        	<nav class="botoes">
            	<ul>        
                	<li><a href="login">Login</a></li>
                </ul>
            </nav>
        </div> 

		<div class = "caixa">
			<h1> <img src=./resources/images/fatec-zl.png src = "fatec-zl.png" alt="Logo inicial"> </h1>
				<nav>
					<ul>
						<li><a href = "index">Home</a></li> 
						<li><a href = "livro_consultar">Livros</a></li>	
					</ul>
				</nav>
			</div>
		</header>
     
        <main>
        <section class = "principal">
        <h2 class="titulo">Biblioteca FATEC Zona Leste</h2>
        
            <div class="objetivo">
                <p>A FATEC Zona Leste � mais do que uma simples biblioteca; � um santu�rio de conhecimento no cora��o da Zona Leste. 
                   Com suas estantes repletas de livros que contam hist�rias de ci�ncia, tecnologia e inova��o, ela � o ref�gio 
                   intelectual para estudantes �vidos e pesquisadores curiosos. Nesse espa�o de aprendizado, as p�ginas ganham vida, 
                   transformando-se em portais para novos horizontes de descoberta. A FATEC ZL n�o � apenas uma biblioteca; � um 
                   elo entre mentes sedentas de saber e as vastas fronteiras do conhecimento.
                </p>
            </div>
        </section>
        
                
        <section class= "beneficios">
			<h3 class = "titulo">Beneficios da Biblioteca</h3>
			
			    <div class="item-details">

                </div>
                
                <div class="conteudo">
                
                    <div class="duvida">
                        <h1>Reservas Simples</h1>
                        <img src="./resources/images/arrow-down.svg" alt="">
                        <p class="paragrafo">A reserva simples na biblioteca da Fatec Zona Leste � uma �tima op��o para garantir o acesso aos livros 
                        				 que voc� precisa, mesmo que eles estejam emprestados no momento. Aproveite esse servi�o e desfrute 
                        				 de todo o acervo dispon�vel para enriquecer seus estudos e pesquisas. </p>
                        </div>
                        
                        <div class="duvida">		 
                        <h1>Acesso M�vel</h1>
                        <img src="./resources/images/arrow-down.svg" alt="">
                        <p class="paragrafo">O acesso m�vel na biblioteca da Fatec Zona Leste facilita a vida dos usu�rios, oferecendo praticidade 
                        				 e agilidade na utiliza��o dos servi�os e recursos dispon�veis. Aproveite essa facilidade e potencialize 
                        				 seu aprendizado e pesquisa de forma conveniente e eficiente.</p>
                        </div>	
                        
                        <div class="duvida">			 
                        <h1>Suporte Atencioso</h1>
                        <img src="./resources/images/arrow-down.svg" alt="">
                        <p class="paragrafo">A biblioteca da FATEC Zona Leste � mais do que um dep�sito de livros; � um centro de suporte acad�mico. 
                                         Com bibliotec�rios especializados, oferece orienta��o, assist�ncia na pesquisa e desenvolvimento
                                         de habilidades de aprendizado. Por meio de workshops e aux�lio personalizado, � um farol, guiando
                                         os alunos com dilig�ncia em sua jornada educacional.</p>

                    	</div>
                   
                </div>
                
             <div class="item-details">

                </div>

		</section>
      
        <section class = "mapa">
			<h3 class="titulo">Nossa Biblioteca</h3>
			<p>Nossa biblioteca est� localizada..</p>
			<div class="mapa-conteudo">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3658.3054506969233!2d-46.479110623931064!3d-23.521513860130852!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce61270808f47f%3A0xddc2deca4778eb69!2sFATEC%20Zona%20Leste!5e0!3m2!1spt-PT!2sbr!4v1692556068344!5m2!1spt-PT!2sbr" width="940" height="550" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>		
            </div>
		</section>

        </main>
        <footer>
			<img src= "./resources/images/CPS.png">
			<p class = "Copyright"> &copy; Copyright FATEC ZL - 2023 </p>

		</footer>
     <script src="./resources/script/script.js"></script>
</body>
</html>