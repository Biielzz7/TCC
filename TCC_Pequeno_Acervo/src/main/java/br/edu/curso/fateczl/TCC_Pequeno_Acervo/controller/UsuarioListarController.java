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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Usuario;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.UsuarioDAO;

@Controller
public class UsuarioListarController {
	
	@Autowired
	UsuarioDAO uDAO;
	
	@RequestMapping(name = "usuario_listar", value = "/usuario_listar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		

		List<Usuario> usuarios = new ArrayList<>();
		String erro = "";
		String saida = "";
		
		String cmd = param.get("cmd");
		String id = param.get("idUsuario");
		

		
		Usuario u = new Usuario();
		
        ModelAndView mv = new ModelAndView("usuario_listar");
        
		
		try {
			    if(session.getAttribute("id_func") != null) {
			
				usuarios = uDAO.listar();
				
			    }
			    
			    if(session.getAttribute("id_func") == null) {
					
				mv.setViewName("deslogar");
				
			    }
				
			
				if(cmd.contains("alterar")) {
				

					session.setAttribute("id_user_func", id);
					System.out.println(session.getAttribute("id_user_func") + " id do usuario na listagem");

					mv.setViewName("redirect:/usuario_editar");

					
				} 
				
				if(cmd.contains("excluir")) {
					saida = uDAO.excluir(Integer.parseInt(id));
					usuarios = uDAO.listar();
					}

			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("usuarios", usuarios);
			model.addAttribute("usuario", u);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "usuario_listar", value = "/usuario_listar", method = RequestMethod.POST)
	public ModelAndView usuario_listar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		return new ModelAndView("usuario_listar");
	}
}
