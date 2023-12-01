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
                <p>A FATEC Zona Leste é mais do que uma simples biblioteca; é um santuário de conhecimento no coração da Zona Leste. 
                   Com suas estantes repletas de livros que contam histórias de ciência, tecnologia e inovação, ela é o refúgio 
                   intelectual para estudantes ávidos e pesquisadores curiosos. Nesse espaço de aprendizado, as páginas ganham vida, 
                   transformando-se em portais para novos horizontes de descoberta. A FATEC ZL não é apenas uma biblioteca; é um 
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
                        <p class="paragrafo">A reserva simples na biblioteca da Fatec Zona Leste é uma ótima opção para garantir o acesso aos livros 
                        				 que você precisa, mesmo que eles estejam emprestados no momento. Aproveite esse serviço e desfrute 
                        				 de todo o acervo disponível para enriquecer seus estudos e pesquisas. </p>
                        </div>
                        
                        <div class="duvida">		 
                        <h1>Acesso Móvel</h1>
                        <img src="./resources/images/arrow-down.svg" alt="">
                        <p class="paragrafo">O acesso móvel na biblioteca da Fatec Zona Leste facilita a vida dos usuários, oferecendo praticidade 
                        				 e agilidade na utilização dos serviços e recursos disponíveis. Aproveite essa facilidade e potencialize 
                        				 seu aprendizado e pesquisa de forma conveniente e eficiente.</p>
                        </div>	
                        
                        <div class="duvida">			 
                        <h1>Suporte Atencioso</h1>
                        <img src="./resources/images/arrow-down.svg" alt="">
                        <p class="paragrafo">A biblioteca da FATEC Zona Leste é mais do que um depósito de livros; é um centro de suporte acadêmico. 
                                         Com bibliotecários especializados, oferece orientação, assistência na pesquisa e desenvolvimento
                                         de habilidades de aprendizado. Por meio de workshops e auxílio personalizado, é um farol, guiando
                                         os alunos com diligência em sua jornada educacional.</p>

                    	</div>
                   
                </div>
                
             <div class="item-details">

                </div>

		</section>
      
        <section class = "mapa">
			<h3 class="titulo">Nossa Biblioteca</h3>
			<p>Nossa biblioteca está localizada..</p>
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