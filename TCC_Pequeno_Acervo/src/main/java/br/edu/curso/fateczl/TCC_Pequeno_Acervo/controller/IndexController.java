package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LivroDAO;

@Controller
public class IndexController {
	
	@Autowired
	LivroDAO lDAO;

	@RequestMapping(name = "index", value = "/index", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model,@RequestParam Map<String, String> param) {

		return new ModelAndView("index");
		
	}
	
	@RequestMapping(name = "index", value = "/index", method = RequestMethod.POST)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView("index");
	}
	
}
