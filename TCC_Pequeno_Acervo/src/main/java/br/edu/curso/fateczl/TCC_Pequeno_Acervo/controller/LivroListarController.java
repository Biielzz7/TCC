package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.sql.SQLException;
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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Livro;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LivroDAO;

@Controller
public class LivroListarController {
	
	@Autowired
	LivroDAO lDAO;
	
	@RequestMapping(name = "livro_listar", value = "/livro_listar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model,  @RequestParam Map<String, String> param, HttpSession session) {
		
		String id = param.get("idLivro");
		String cmd = param.get("cmd");		
		String erro = "";
		String saida = "";
		
		List<Livro> livros = new ArrayList<>();
		ModelAndView mv = new ModelAndView("livro_listar");
		
		try {
			
			if(session.getAttribute("id_func") != null) {
				
			livros = lDAO.listar();	
				
			}
			
			if(session.getAttribute("id_func") == null) {
				
			mv.setViewName("deslogar");	
				
			}					
			
			if(cmd.contains("alterar")) {
				
			session.setAttribute("id_livro", id);	
			mv.setViewName("redirect:/livro_editar");
			
			}
			
			if(cmd.contains("excluir")) {
				
			saida = lDAO.excluir(Integer.parseInt(id));
			livros = lDAO.listar();
			
			}
			
		} catch(SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
		model.addAttribute("livros", livros);
		model.addAttribute("saida", saida);
		model.addAttribute("erro", erro);
		
		}
		
		return mv;
	}
	
	@RequestMapping(name = "livro_listar", value = "/livro_listar", method = RequestMethod.POST)
	public ModelAndView livro_listar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String erro = "";
		String saida = "";
		
	
		String botao = param.get("botao");
		
		
		ModelAndView mv = new ModelAndView("livro_listar");
		
		try {
			System.out.println(botao);
			
			if(botao.equalsIgnoreCase("adicionar")) {
				
	            mv.setViewName("redirect:/livro_cadastrar");
				
				}
		
			
			
			
			
		} catch(NullPointerException e) {
			erro = e.getMessage();
		} finally {
		model.addAttribute("saida", saida);
		model.addAttribute("erro", erro);
		}
		
		return mv;
	}
}
