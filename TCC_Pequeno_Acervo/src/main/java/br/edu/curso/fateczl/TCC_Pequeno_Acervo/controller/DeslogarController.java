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
public class DeslogarController {
	
	@RequestMapping(name = "deslogar", value = "/deslogar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		return new ModelAndView("deslogar");
	}

	@RequestMapping(name = "deslogar", value = "/deslogar", method = RequestMethod.POST)
	public ModelAndView deslogar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		return new ModelAndView("deslogar");
	}
}
