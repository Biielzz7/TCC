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
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.UsuarioEmprestimoDAO;

@Controller
public class UsuarioEmprestimoController {
	
	@Autowired
	UsuarioEmprestimoDAO ueDAO;

	@RequestMapping(name = "usuario_emprestimo", value = "/usuario_emprestimo", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String id_user = "";
		
		if(session.getAttribute("id_user") != null ) {
			id_user = session.getAttribute("id_user").toString();
		}
		 
		 
		
		System.out.println(session.getAttribute("id_user") + " id do usuario na no controller usuario emprestimo");
		
		String erro = "";
		String saida = "";
		
		List<Emprestimo> emprestimos_usuario = new ArrayList<>();
		

		ModelAndView mv = new ModelAndView("usuario_emprestimo");
		
		try {
			
			if(id_user == null || id_user == "") {
				System.out.println("caiu no começo!!!!");
				mv.setViewName("login");
				
			} else {
				System.out.println("veio pra ca por algum um motivo!!!!");
				emprestimos_usuario = ueDAO.consultarEmprestimo(Integer.parseInt(id_user));
			}
			
			if(emprestimos_usuario == null || emprestimos_usuario.isEmpty()) {
				saida = "Você não possui emprestimos";
			}
			

		
			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("emprestimos", emprestimos_usuario);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return mv;
	}

	@RequestMapping(name = "usuario_emprestimo", value = "/usuario_emprestimo", method = RequestMethod.POST)
	public ModelAndView usuario_emprestimo(ModelMap model) {
		return new ModelAndView("usuario_emprestimo");
	}
}
