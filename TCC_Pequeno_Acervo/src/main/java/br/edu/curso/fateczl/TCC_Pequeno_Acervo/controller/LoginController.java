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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Login;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.LoginDAO;

@Controller
public class LoginController {
	
	@Autowired
	LoginDAO logar;
	
	@RequestMapping(name = "login", value = "/login", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		return new ModelAndView("login");
	}
	
	@RequestMapping(name = "login", value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String usuario = param.get("usuario");
		String senha = param.get("senha");
		
		String botao = param.get("botao");
		
		String erro = "";
		String saida = "";
		
		Login l = new Login();
		
		ModelAndView mv = new ModelAndView("login");
		
		if(usuario == "" || usuario == null) {
			usuario = "";
		}
		
		if(senha == "" || senha == null) {
			usuario = "";
		}
		
		try {
			
			if(botao.equalsIgnoreCase("entrar")) {
				l = logar.realizarLogin(usuario, senha);
				
				System.out.println(l);
				
				if(l.getAcesso_tipo().contains("USUARIO")) {
					
					session.setAttribute("id_user", l.getId_usuario());
					session.setAttribute("acesso", l.getAcesso_tipo());
					mv.setViewName("redirect:/usuario_acesso");
					
					
					
				}
				
				if(l.getAcesso_tipo().contains("FUNCIONARIO")) {
					session.setAttribute("id_func", l.getId_usuario());
					session.setAttribute("acesso", l.getAcesso_tipo());
					mv.setViewName("redirect:/funcionario_acesso");
					
				}
				
				if(l.getAcesso_tipo().contains("ADMINISTRADOR")) {
					session.setAttribute("id_adm", l.getId_usuario());
					session.setAttribute("acesso", l.getAcesso_tipo());
					mv.setViewName("redirect:/administrador_acesso");
					
				}
				

				
				if(l.getAcesso_tipo().contains("Acesso Invalido")) {
                    saida = l.getAcesso_tipo();
                    System.out.println(saida);
					
				}
			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				mv.setViewName("redirect:/index");
			}
			
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
			
		}
		return mv;
	}
}
