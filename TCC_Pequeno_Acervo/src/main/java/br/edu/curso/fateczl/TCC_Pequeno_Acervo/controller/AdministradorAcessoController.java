package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministradorAcessoController {
	@RequestMapping(name = "administrador_acesso", value = "/administrador_acesso", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session, @RequestParam Map<String, String> param) {
		
		String id_adm = "";
		
		if(session.getAttribute("id_adm") != null) {
				
		id_adm = session.getAttribute("id_adm").toString();	
		System.out.println(id_adm);	
		
		}	
		
		String erro = "";

		ModelAndView mv = new ModelAndView("administrador_acesso");
		
		try {
			
			if(session.getAttribute("id_adm") == null) {
				
				mv.setViewName("deslogar");
			}
			
		} catch (Exception e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
		}

		
		return mv;
	}
	
	@RequestMapping(name = "administrador_acesso", value = "/administrador_acesso", method = RequestMethod.POST)
	public ModelAndView administrador_acesso(ModelMap model) {
		return new ModelAndView("administrador_acesso");
	}
}
