package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Emprestimo;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Livro;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Usuario;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.EmprestimoDAO;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LivroDAO;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.UsuarioDAO;

@Controller
public class EmprestimoCadastrarController {

	@Autowired
	EmprestimoDAO eDAO;
	
	@Autowired
	UsuarioDAO uDAO;
	
	@Autowired
	LivroDAO lDAO;
	
	
	@RequestMapping(name = "emprestimo_cadastrar", value = "/emprestimo_cadastrar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		
		
		List<Livro> livros = new ArrayList<>();
		List<Usuario> usuarios = new ArrayList<>();
		
		
		String erro = "";
		String saida = "";
		
		ModelAndView mv = new ModelAndView("emprestimo_cadastrar"); 

		try {
			
			if(session.getAttribute("id_func") != null) {
			
			livros = lDAO.listar();
			usuarios = uDAO.listar();
			
			}
			
			if(session.getAttribute("id_func") == null) {
				System.out.println("saindo por id func null");
				mv.setViewName("deslogar");
			}

			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("usuarios", usuarios);
			model.addAttribute("livros", livros);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "emprestimo_cadastrar", value = "/emprestimo_cadastrar", method = RequestMethod.POST)
	public ModelAndView emprestimo_cadastrar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		init(model, param, session);
		
		String usuario = param.get("usuario");
		String livro =  param.get("titulo");
		String dataDevolucao = param.get("dataDevolucao");
		String dataEmprestimo = param.get("dataEmprestimo");
		
		String botao = param.get("botao");
		
		
		String erro = "";
		String saida = "";
		
		Emprestimo e = new Emprestimo();
		ModelAndView mv = new ModelAndView("emprestimo_cadastrar");
		
		if(usuario == null || usuario == "") {
			usuario = "";
		}
		
		if(livro == null || livro == "") {
			livro = "";
		}
		
		if(dataEmprestimo == null || dataEmprestimo == "") {
			dataEmprestimo = LocalDate.now().toString();
		}
		
		if(dataDevolucao == null || dataDevolucao == "") {
			dataDevolucao = LocalDate.now().toString();
		}
		
		System.out.println(usuario);
		System.out.println(livro);
		System.out.println(dataEmprestimo);
		System.out.println(dataDevolucao);
		
		try {
			
			if(botao.equalsIgnoreCase("salvar")) {
			
			e.setTitulo(livro);
			e.setUsuario(usuario);
			e.setDataEmprestimo(LocalDate.parse(dataEmprestimo));
			e.setDataDevolucao(LocalDate.parse(dataDevolucao));
			
			saida = eDAO.cadastrar(e);
			System.out.println(saida);
			mv.setViewName("redirect:/emprestimo_listar");

			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				
		    
			mv.setViewName("redirect:/emprestimo_listar");
			}
			

		} catch (SQLException | ClassNotFoundException | NullPointerException er) {
			erro = er.getMessage();
		} finally {
			
			if(erro.contains("Emprestimos Bloqueados")) {
			System.out.println(erro + " mensagem no cadastro");	
			session.setAttribute("mensagem", erro);	
			mv.setViewName("emprestimo_cadastrar");	
			
			} else {
				
			session.removeAttribute("mensagem");
			
			
			}
			
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);

		}		
		return mv;
	}
}
