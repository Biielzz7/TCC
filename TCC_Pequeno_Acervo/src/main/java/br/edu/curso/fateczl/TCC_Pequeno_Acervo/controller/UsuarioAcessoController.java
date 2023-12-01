package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Usuario;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.UsuarioDAO;

@Controller
public class UsuarioAcessoController {
	
	@Autowired
	UsuarioDAO uDAO;

	@RequestMapping(name = "usuario_acesso", value = "/usuario_acesso", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session, @RequestParam Map<String, String> param) {
		
		String id_user = "";
		
		if(session.getAttribute("id_user") != null) {
		
		id_user = session.getAttribute("id_user").toString();
		System.out.println(session.getAttribute("id_user"));
		
		}
		String erro = "";

		ModelAndView mv = new ModelAndView("usuario_acesso");
		Usuario u = new Usuario();
		
		try {
			
			if(session.getAttribute("id_user") == null) {
				mv.setViewName("deslogar");
			}
			
			if(session.getAttribute("id_user") != null) {
				u = uDAO.buscar(Integer.parseInt(id_user));
				session.setAttribute("usuario", u.getNome());
			}
			
		} catch (Exception e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
		}

		
		return mv;
	}
	
	@RequestMapping(name = "usuario_acesso", value = "/usuario_acesso", method = RequestMethod.POST)
	public ModelAndView usuario_acesso(ModelMap model) {
		return new ModelAndView("usuario_acesso");
	}
}
