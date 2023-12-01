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
public class FuncionarioCadastrarController {
	
	@Autowired
	FuncionarioDAO fDAO;
	
	@RequestMapping(name = "funcionario_cadastrar", value = "/funcionario_cadastrar", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		
		ModelAndView mv = new ModelAndView("funcionario_cadastrar");
		
		try {
			
			if (session.getAttribute("id_adm") == null) {
				
				mv.setViewName("deslogar");
				
			}
			
			if (session.getAttribute("id_adm") != null) {
				
				mv.setViewName("funcionario_cadastrar");
				
			}
			
		} catch(Exception e) {
			
		}
				
		return mv;
		
	}
	
	@RequestMapping(name = "funcionario_cadastrar", value = "/funcionario_cadastrar", method = RequestMethod.POST)
	public ModelAndView funcionario_cadastrar(ModelMap model,  @RequestParam Map<String, String> param) {
		
		
		
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
		
		String botao = param.get("botao");
		
		String erro = "";
		String saida = "";
		Funcionario f = new Funcionario();
		
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
		
		ModelAndView mv = new ModelAndView("funcionario_cadastrar");
		
		try {
			
			if(botao.equalsIgnoreCase("Salvar")) {
				
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
			
			    saida = fDAO.cadastrar(f);
			    mv.setViewName("redirect:/funcionario_listar");
			
			}
			
			if(botao.equalsIgnoreCase("cancelar")) {
				
            mv.setViewName("redirect:/funcionario_listar");
			
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
