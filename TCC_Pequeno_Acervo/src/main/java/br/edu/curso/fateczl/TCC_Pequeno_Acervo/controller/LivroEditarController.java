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
public class LivroEditarController {
	
	@Autowired
	LivroDAO lDAO;
	
	@RequestMapping(name = "livro_editar", value = "/livro_editar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model,  @RequestParam Map<String, String> param, HttpSession session) {
		
		String id_livro = "";
		
		if(session.getAttribute("id_livro") != null) {
			
	    id_livro = session.getAttribute("id_livro").toString();
			
		}

		String saida = "";
		String erro = "";
		
		System.out.println(id_livro + " id do livro para edicao");
		
		Livro l = new Livro();
		ModelAndView mv = new ModelAndView("livro_editar");
		
		try {
			
			if(session.getAttribute("id_func") != null) {
			
			l = lDAO.buscar(Integer.parseInt(id_livro));
			System.out.println(l);
			
			}
			
			if(session.getAttribute("id_func") == null) {
				
			mv.setViewName("deslogar");
			
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
	
	@RequestMapping(name = "livro_editar", value = "/livro_editar", method = RequestMethod.POST)
	public ModelAndView livro_editar(ModelMap model,  @RequestParam Map<String, String> param, HttpSession session) {
		
		String id_livro = session.getAttribute("id_livro").toString();
		
		
		
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
		System.out.println(id_livro + " id do livro para edicao");
		
		Livro l = new Livro();
		ModelAndView mv = new ModelAndView("livro_editar");
		
		try {
			
			l = lDAO.buscar(Integer.parseInt(id_livro));
			
			if(botao.equalsIgnoreCase("salvar")) {
				
			l.setIdLivro(Integer.parseInt(id_livro));
			l.setTitulo(titulo);
			l.setIsbn(isbn);
			l.setQuantidade(Integer.parseInt(quantidade));
			l.setEditora(editora);
			l.setNomeAutor(nomeAutor);
			l.setTombo(tombo);
			l.setDisponibilidade(disponibilidade);
				
			saida = lDAO.alterar(l);
			System.out.println(l);
			mv.setViewName("redirect:/livro_listar");
			
			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				
				mv.setViewName("redirect:/livro_listar");
			
			}
			
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			
		}		
		
		return mv;
	}

}
