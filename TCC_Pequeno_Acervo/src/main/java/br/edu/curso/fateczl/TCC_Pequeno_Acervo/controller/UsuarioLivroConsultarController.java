package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Livro;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LivroDAO;

@Controller
public class UsuarioLivroConsultarController {
	
	@Autowired
	LivroDAO lDAO;
	
	@RequestMapping(name = "usuario_livro_consultar", value = "/usuario_livro_consultar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		
		String id_user = "";
		
		if(session.getAttribute("id_user") != null) {
			id_user = session.getAttribute("id_user").toString();
		}
		
		String saida = "";
		String erro = "";
		
		List<Livro> livros = new ArrayList<>();
		ModelAndView mv = new ModelAndView("usuario_livro_consultar");
		
		try {
			
			if(session.getAttribute("id_user") == null) {
			mv.setViewName("deslogar");
			}
			
			if(id_user != null || id_user != "") {
			livros = lDAO.listar();	
			}
			

			
			
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
			model.addAttribute("livros", livros);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "usuario_livro_consultar", value = "/usuario_livro_consultar", method = RequestMethod.POST)
	public ModelAndView usuario_livro_consultar(ModelMap model) {
		return new ModelAndView("usuario_livro_consultar");
	}
}
