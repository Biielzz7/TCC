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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Emprestimo;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.EmprestimoDAO;

@Controller
public class EmprestimoListarController {
	
	@Autowired
	EmprestimoDAO eDAO;
	
	@RequestMapping(name = "emprestimo_listar", value = "/emprestimo_listar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
	
		String idEmprestimo = param.get("idEmprestimo");
		
		String cmd = param.get("cmd");
		
		String erro = "";
		String saida = "";
		
		if(session.getAttribute("mensagem") != null) {
			saida = session.getAttribute("mensagem").toString();
			System.out.println(saida + " mensagem vindo da session");
		}
		
		List<Emprestimo> emprestimos = new ArrayList<>();
		
		ModelAndView mv = new ModelAndView("emprestimo_listar");
		
		try {
			
			
			if(session.getAttribute("id_func") != null) {
			
			emprestimos = eDAO.listar();	
			
			}
			
			if(session.getAttribute("mensagem") != null) {
				
		    System.out.println(saida + " veio pra ca !!!!");
		    mv = new ModelAndView("emprestimo_listar");
			emprestimos = eDAO.listar();	
			
			}
			
			if(session.getAttribute("id_func") == null) {
				mv.setViewName("deslogar");
			}
			
			
			if(cmd.contains("alterar")) {

				session.setAttribute("id_emprestimo", idEmprestimo);
				mv.setViewName("redirect:/emprestimo_editar");
				
			}
			
			if(cmd.contains("excluir")) {
	
				saida = eDAO.excluir(Integer.parseInt(idEmprestimo));
			
				emprestimos = eDAO.listar();
				
			}
			
			System.out.println(saida);
			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("emprestimos", emprestimos);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "emprestimo_listar", value = "/emprestimo_listar", method = RequestMethod.POST)
	public ModelAndView emprestimo_listar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		

		
		String botao = param.get("botao");
		
		String erro = "";
		String saida = "";
		
//		List<Emprestimo> emprestimos = new ArrayList<>();
		ModelAndView mv = new ModelAndView("emprestimo_listar");
		
		
		try {
				
				if(botao.equalsIgnoreCase("adicionar")) {
					
		            mv.setViewName("redirect:/emprestimo_cadastrar");
					
					}			

		} catch (Exception e) {
			erro = e.getMessage();
		} finally {
			
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return mv;
	}
}
