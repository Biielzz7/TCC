package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Livro;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LivroDAO;

@Controller
public class LivroConsultarController {
	
	@Autowired
	LivroDAO lDAO;
	
	@RequestMapping(name = "livro_consultar", value = "/livro_consultar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		
		String saida = "";
		String erro = "";
		
		List<Livro> livros = new ArrayList<>();
		
		try {
			
			livros = lDAO.listar();
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
			model.addAttribute("livros", livros);
		}
		
		return new ModelAndView("livro_consultar");
	}
	
	@RequestMapping(name = "livro_consultar", value = "/livro_consultar", method = RequestMethod.POST)
	public ModelAndView livro_consultar(ModelMap model) {
		return new ModelAndView("livro_consultar");
	}
}
