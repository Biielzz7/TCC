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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Funcionario;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.FuncionarioDAO;

@Controller
public class FuncionarioAcessoController {
	
	@Autowired
	FuncionarioDAO fDAO;

	@RequestMapping(name = "funcionario_acesso", value = "/funcionario_acesso", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session, @RequestParam Map<String, String> param) {
				
		String id_func = "";
		
		if(session.getAttribute("id_func") != null) {
			
		id_func = session.getAttribute("id_func").toString();	
		
		System.out.println(id_func + " id do funcionario no acesso");
		
		}
		
		
		Funcionario f = new Funcionario();
		
		ModelAndView mv = new ModelAndView("funcionario_acesso");
		
		try {
			
			if(session.getAttribute("id_func") == null) {
				
				mv.setViewName("deslogar");
				
			} 
			
			if(session.getAttribute("id_func") != null) {
			
			f = fDAO.buscar(Integer.parseInt(id_func));
		    session.setAttribute("funcionario", f.getNome());
		    
			}
		   	
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			
		} finally {
			
		}
		
		return mv;
	}
	
	@RequestMapping(name = "funcionario_acesso", value = "/funcionario_acesso", method = RequestMethod.POST)
	public ModelAndView funcionario_acesso(ModelMap model) {
		return new ModelAndView("funcionario_acesso");
	}
}
