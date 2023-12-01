package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.sql.SQLException;
//import java.time.LocalDate;
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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Funcionario;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.FuncionarioDAO;

@Controller
public class FuncionarioListarController {

	@Autowired
	FuncionarioDAO fDAO;
	
	@RequestMapping(name = "funcionario_listar", value = "/funcionario_listar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String id_adm = "";
		
		if(session.getAttribute("id_adm") != null) {
		
		id_adm = session.getAttribute("id_adm").toString();	
		System.out.println(id_adm + " id do administrador");	
			
		}
		
		
		List<Funcionario> funcionarios = new ArrayList<>();
		String erro = "";
		String saida = "";
		
		String cmd = param.get("cmd");
		String id_adm_func = param.get("idFuncionario");
		
		Funcionario f = new Funcionario();
		
        ModelAndView mv = new ModelAndView("funcionario_listar");
        
		
		try {
			
			    if(session.getAttribute("id_adm") == null) {
				
				   mv.setViewName("deslogar");
				
			    }
			    
			    if(session.getAttribute("id_adm") != null) {
					
				  funcionarios = fDAO.listar(); 
				
			    }			
				
			
				if(cmd.contains("alterar")) {

					session.setAttribute("id_adm_func", id_adm_func);

					mv.setViewName("redirect:/funcionario_editar");
					
					} 
				
				if(cmd.contains("excluir")) {
					
					saida = fDAO.excluir(Integer.parseInt(id_adm_func));
					funcionarios = fDAO.listar();
					
					}

			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("funcionarios", funcionarios);
			model.addAttribute("funcionario", f);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "funcionario_listar", value = "/funcionario_listar", method = RequestMethod.POST)
	public ModelAndView funcionario_listar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		

		
		String botao = param.get("botao");
		
		
		
		String erro = "";
		String saida = "";
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		ModelAndView mv = new ModelAndView("funcionario_listar");
		
		try {
			
			System.out.println(botao);

			funcionarios = fDAO.listar();
		
			
			if(botao.equalsIgnoreCase("adicionar")) {
				
                mv.setViewName("redirect:/funcionario_cadastrar");
                System.out.println(mv);
			
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
			model.addAttribute("funcionarios", funcionarios);
		}		
		
		return mv;
	}
	
	

}
