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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Emprestimo;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.EmprestimoDAO;

@Controller
public class EmprestimoEditarController {

	@Autowired
	EmprestimoDAO eDAO;
	
	@RequestMapping(name = "emprestimo_editar", value = "/emprestimo_editar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String id_emprestimo = "";
		
		if(session.getAttribute("id_emprestimo") != null) {
			
			id_emprestimo = session.getAttribute("id_emprestimo").toString();
			
		}
		
		
		String erro = "";
		String saida = "";
		
		Emprestimo em = new Emprestimo();
		
		ModelAndView mv = new ModelAndView("emprestimo_editar");
		
		try {
			
			if(session.getAttribute("id_func") == null) {
				
				mv.setViewName("deslogar");
				
			}
			
			if(session.getAttribute("id_func") != null) {
				
			em = eDAO.buscar(Integer.parseInt(id_emprestimo));	
				
			}
				
			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			
			model.addAttribute("emprestimo", em);
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
		}
		
		return mv;
		
	}
	
	@RequestMapping(name = "emprestimo_editar", value = "/emprestimo_editar", method = RequestMethod.POST)
	public ModelAndView emprestimo_editar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String id_emprestimo = param.get("idEmprestimo");
		String status = param.get("estado");
		
		String botao = param.get("botao");
		
		String erro = "";
		String saida = "";
		
		Emprestimo em = new Emprestimo();
		ModelAndView mv = new ModelAndView("emprestimo_editar");
		
		try {
			if(botao.equalsIgnoreCase("salvar")) {
				
				em.setIdEmprestimo(Integer.parseInt(id_emprestimo));
				em.setEstado(status);
				saida = eDAO.alterar(em);
				mv.setViewName("redirect:/emprestimo_listar");
				
			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				
				mv.setViewName("redirect:/emprestimo_listar");
				
			}
			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			
		}		
		
		return mv;
	}
}
