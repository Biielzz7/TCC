package br.edu.curso.fateczl.TCC_Pequeno_Acervo.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence.GenericDAO;

@Controller
public class RelatorioEmprestimoController {

	@Autowired
	GenericDAO gDAO;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(name = "gerar_relatorio_emprestimo", value = "/gerar_relatorio_emprestimo", method = RequestMethod.POST)
	public ResponseEntity gerar_relatorio_emprestimo(@RequestParam Map<String, String> params, ModelMap model) {
		
		String erro = "";
		String data = params.get("data");
		String botao = params.get("botao");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", data);
		
		byte[] bytes = null;
		
		InputStreamResource resource = null;
		HttpStatus status = null;
		HttpHeaders header = new HttpHeaders();
		
		try {

			if(botao.equalsIgnoreCase("gerar")) {

			Connection c = gDAO.getConnection();
			
			File arquivo = ResourceUtils.getFile("classpath:reports/Relatorio_Acervo.jasper");
			
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(arquivo.getAbsolutePath());
			
			bytes = JasperRunManager.runReportToPdf(relatorio, param, c);
			
			}
			
		} catch (FileNotFoundException | JRException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			erro = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
			
		} finally {
			
			if (erro.equals("")) {
				
				InputStream inputStream = new ByteArrayInputStream(bytes);
				resource = new InputStreamResource(inputStream);
				header.setContentLength(bytes.length);
				header.setContentType(MediaType.APPLICATION_PDF);
				status = HttpStatus.OK;
				
			}
			
		}
		
		return new ResponseEntity(resource, header, status);
	}
}
