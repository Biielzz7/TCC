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
public class UsuarioCadastrarController {
	
	@Autowired
	UsuarioDAO uDAO;
	
	@RequestMapping(name = "usuario_cadastrar", value = "/usuario_cadastrar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		
		
		
		return new ModelAndView("usuario_cadastrar");
	}
	
	@RequestMapping(name = "usuario_cadastrar", value = "/usuario_cadastrar", method = RequestMethod.POST)
	public ModelAndView usuario_cadastrar(ModelMap model,  @RequestParam Map<String, String> param) {
		
		String botao = param.get("botao");
		
		String id = param.get("idUsuario");
		
		String usuario = param.get("usuario");
		String senha = param.get("senha");
		String cpf = param.get("cpf");
		String cep = param.get("cep");
		String nome = param.get("nome");
		String dataNasc = param.get("dataNasc");
		String logradouro = param.get("logradouro");
		String numero_endereco = param.get("numero_endereco");
		String telefone = param.get("telefone");
		
		
		String erro = "";
		String saida = "";
		Usuario u = new Usuario();
		
		if(id == "" || id == null) {
			id = "0";
		}
		
		if(usuario == "" || usuario == null) {
			usuario = "";
		}
		
		if(senha == "" || senha == null) {
			senha = "";
		}
		
		if(cpf == "" || cpf == null) {
			cpf = "";
		}
		
		if(cep == "" || cep == null) {
			cep = "";
		}
		
		if(dataNasc == "" || dataNasc == null) {
			dataNasc = LocalDate.now().toString();
		}
		
		if(logradouro == "" || logradouro == null) {
			logradouro = "";
		}
		
		
		if(numero_endereco == "" || numero_endereco == null) {
			numero_endereco = "0";
		}
		
		if(telefone == "" || telefone == null) {
			telefone = "0";
		} 
		
		System.out.println(id + " comeca aqui");
		System.out.println(usuario);
		System.out.println(senha);
		System.out.println(cpf);
		System.out.println(cep);
		System.out.println(nome);
		System.out.println(dataNasc);
		System.out.println(logradouro);
		System.out.println(numero_endereco);
		System.out.println(telefone);
		
		
		ModelAndView mv = new ModelAndView("usuario_cadastrar");
		
		try {
			if(botao.equalsIgnoreCase("salvar")) {
				
			    u.setIdUsuario(Integer.parseInt(id));
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
			
			System.out.println(saida);
			saida = uDAO.cadastrar(u);
			mv.setViewName("redirect:/login");
			u = null;
			
			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				
            mv.setViewName("redirect:/login");
			u = null;
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);

		}				
		
		return mv;
	}	

}
