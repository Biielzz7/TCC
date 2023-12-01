package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Livro;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LivroDAO;

@Controller
public class LivroCadastrarController {
	
	@Autowired
	LivroDAO lDAO;
	
	@RequestMapping(name = "livro_cadastrar", value = "/livro_cadastrar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		
		ModelAndView mv = new ModelAndView("livro_cadastrar");
		
		try {
			
			if(session.getAttribute("id_func") == null) {
				
				mv.setViewName("deslogar");
				
			}
			
		} catch(Exception e) {
			
		}
		
		return mv;
	}
	
	@RequestMapping(name = "livro_cadastrar", value = "/livro_cadastrar", method = RequestMethod.POST)
	public ModelAndView livro_cadastrar(ModelMap model,  @RequestParam Map<String, String> param) {
		
		String id = param.get("idLivro");
		String titulo = param.get("titulo");
		String isbn = param.get("isbn");
		String quantidade = param.get("quantidade");
		String editora = param.get("editora");
		String nomeAutor = param.get("nomeAutor");
		String tombo = param.get("tombo");
		String disponibilidade = param.get("disponibilidade");
		
		String botao = param.get("botao");
		
		String saida = "";
		String erro = "";
		
		
		Livro l = new Livro();
		ModelAndView mv = new ModelAndView("livro_cadastrar");
		
		if(id == "" | id == null) {
			id = "0";
		}
		
		if(titulo == "" | titulo == null) {
			titulo = "";
		}
		
		if(isbn == "" | isbn == null) {
			isbn = "";
		}
		
		if(quantidade == "" | quantidade == null) {
			quantidade = "0";
		}
		
		if(editora == "" | editora == null) {
			editora = "";
		}
		
		if(nomeAutor == "" | nomeAutor == null) {
			nomeAutor = "";
		}
		
		if(tombo == "" | tombo == null) {
			tombo = "";
		}
		
		if(disponibilidade == "" | disponibilidade == null) {
			disponibilidade = "";
		}
		
		try {
			
			
			if(botao.equalsIgnoreCase("salvar")) {
				System.out.println(id);
				System.out.println(editora);
				System.out.println(titulo);
				System.out.println(disponibilidade);
				System.out.println(nomeAutor);
				System.out.println(isbn);
				System.out.println(tombo);
				
				
			l.setIdLivro(Integer.parseInt(id));
			l.setTitulo(titulo);
			l.setIsbn(isbn);
			l.setQuantidade(Integer.parseInt(quantidade));
			l.setEditora(editora);
			l.setNomeAutor(nomeAutor);
			l.setTombo(tombo);
			l.setDisponibilidade(disponibilidade);
				
			saida = lDAO.cadastrar(l);
			System.out.println(l);
			mv.setViewName("redirect:/livro_listar");
			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				l = null;
				mv.setViewName("redirect:/livro_listar");
				
			}
			
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("livro", l);
		}		
		
		return mv;
	}
}
