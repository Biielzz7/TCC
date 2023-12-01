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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Usuario;
import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.UsuarioDAO;

@Controller
public class UsuarioEditarController {
	
	@Autowired
	UsuarioDAO uDAO;
	
	@RequestMapping(name = "usuario_editar", value = "/usuario_editar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		
		String erro = "";
		String saida = "";
		
        String id_busca = "";
		
		if(session.getAttribute("id_user") != null) {
			System.out.println(session.getAttribute("id_user") + " USUARIO na edicao");
			id_busca = session.getAttribute("id_user").toString();
		}
		
		if(session.getAttribute("id_user_func") != null) {
			System.out.println(session.getAttribute("id_user_func") + " FUNCIONARIO na edicao");
			id_busca = session.getAttribute("id_user_func").toString();
		}
		
        ModelAndView mv = new ModelAndView("usuario_editar");
        Usuario u = new Usuario();
		
		try {
			
			if(session.getAttribute("id_user") == null && session.getAttribute("id_user_func") == null ) {
				
				mv.setViewName("deslogar");
				
			}
				
			if(session.getAttribute("id_user_func") != null ) {
				
				System.out.println("se veio esta certo para o FUNCIONARIO!!!!");
				u = uDAO.buscar(Integer.parseInt(id_busca));
				mv.setViewName("usuario_editar");
				
			} 
			
			if(session.getAttribute("id_user") != null ) {
				
				System.out.println("se veio esta certo para o USUARIO!!!!");
				u = uDAO.buscar(Integer.parseInt(id_busca));
				System.out.println(u);
			}
			
			
			
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("usuario", u);
		}
		
		return mv;
	}
	
	@RequestMapping(name = "usuario_editar", value = "/usuario_editar", method = RequestMethod.POST)
	public ModelAndView usuario_editar(ModelMap model, @RequestParam Map<String, String> param, HttpSession session) {
		
		
		String erro = "";
		String saida = "";
		
		String botao = param.get("botao");
		String acesso = "";
		
		if(session.getAttribute("acesso") != null) {
			acesso = session.getAttribute("acesso").toString();
		} else {
			System.out.println("area de testes");
		}

		
		
		System.out.println(acesso);
		
		String id_usuario = param.get("idUsuario");
		String usuario = param.get("usuario");
		String senha = param.get("senha");
		String cpf = param.get("cpf");
		String cep = param.get("cep");
		String nome = param.get("nome");
		String dataNasc = param.get("dataNasc");
		String logradouro = param.get("logradouro");
		String numero_endereco = param.get("numero_endereco");
		String telefone = param.get("telefone");
		
		
		System.out.println(id_usuario);
		
		System.out.println(usuario);
		System.out.println(senha);
		System.out.println(cpf);
		System.out.println(cep);
		System.out.println(nome);
		System.out.println(dataNasc);
		System.out.println(logradouro);
		System.out.println(numero_endereco);
		System.out.println(telefone);
		
		
		Usuario u = new Usuario();
		ModelAndView mv = new ModelAndView();

		
		try {
			
			
				if(botao.equalsIgnoreCase("salvar")) {
					
					u.setIdUsuario(Integer.parseInt(id_usuario));
					u.setUsuario(usuario);	
					u.setSenha(senha);
					u.setNome(nome);
					u.setDataNasc(LocalDate.parse(dataNasc));
					u.setCep(cep);
					u.setCpf(cpf);
					u.setLogradouro(logradouro);
					u.setNumero_endereco(Integer.parseInt(numero_endereco));
					u.setTelefone(telefone);
					System.out.println(u);
					saida = uDAO.alterar(u);
					
					if(acesso.equalsIgnoreCase("funcionario") || (acesso == null || acesso == "")) {
					
					mv.setViewName("redirect:/usuario_listar");	
					
					}
					
					if(acesso.equalsIgnoreCase("usuario") ) {
					
					mv.setViewName("redirect:/usuario_acesso");	
					
					}

				}
				
				if(botao.equalsIgnoreCase("cancelar")) {
					
					if(acesso.equalsIgnoreCase("funcionario") || (acesso == null || acesso == "")) {
				    
					mv.setViewName("redirect:/usuario_listar");	
					
					}
					
					if(acesso.equalsIgnoreCase("usuario")) {
					
					mv.setViewName("redirect:/usuario_acesso");	
					
					}

				} 
				

			
		} catch (SQLException | ClassNotFoundException | NullPointerException | IllegalArgumentException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("usuario", u);
		}
		
		return mv;
	}
	

}
