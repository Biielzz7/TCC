package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.sql.SQLException;
import java.time.LocalDate;
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
public class FuncionarioEditarController {
	
	@Autowired
	FuncionarioDAO fDAO;

	@RequestMapping(name = "funcionario_editar", value = "/funcionario_editar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		String erro = "";
		String saida = "";
		String id_adm_func = "";
		
		if(session.getAttribute("id_adm_func") != null) {
		
	    id_adm_func = session.getAttribute("id_adm_func").toString();		
		
		}	
		
		Funcionario f = new Funcionario();
		ModelAndView mv = new ModelAndView("funcionario_editar");
		
		try {
	
			if(session.getAttribute("id_adm") == null) {
				
				mv.setViewName("deslogar");	
				
			}
			
			if(session.getAttribute("id_adm") != null) {
			
		        f = fDAO.buscar(Integer.parseInt(id_adm_func));
		        
			}
						
			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("funcionario", f);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "funcionario_editar", value = "/funcionario_editar", method = RequestMethod.POST)
	public ModelAndView funcionario_editar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
			
		String erro = "";
		String saida = "";
		
		String botao = param.get("botao");
		
//		String id = param.get("id");
		
		String id = param.get("idFuncionario");		
		String usuario = param.get("usuario");
		String senha = param.get("senha");
		String cpf = param.get("cpf");
		String cep = param.get("cep");
		String nome = param.get("nome");
		String dataNasc = param.get("dataNasc");
		String logradouro = param.get("logradouro");
		String numero_endereco = param.get("numero_endereco");
		String telefone = param.get("telefone");	
				
		Funcionario f = new Funcionario();
		ModelAndView mv = new ModelAndView();
		
		try {
				
				if(botao.equalsIgnoreCase("salvar")) {
					
					f.setIdFuncionario(Integer.parseInt(id));
					f.setUsuario(usuario);	
					f.setSenha(senha);
					f.setNome(nome);
					f.setDataNasc(LocalDate.parse(dataNasc));
					f.setCep(cep);
					f.setCpf(cpf);
					f.setLogradouro(logradouro);
					f.setNumero_endereco(Integer.parseInt(numero_endereco));
					f.setTelefone(telefone);
					System.out.println(f);
					saida = fDAO.alterar(f);
					mv.setViewName("redirect:/funcionario_listar");
				
					} 
				
				if(botao.equalsIgnoreCase("cancelar")) {
					
					mv.setViewName("redirect:/funcionario_listar");
				
					} 

			
		} catch (SQLException | ClassNotFoundException | NullPointerException | IllegalArgumentException e) {
			erro = e.getMessage();
		} finally {
			
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("funcionario", f);
			
		}
		
		return mv;
	}
}
