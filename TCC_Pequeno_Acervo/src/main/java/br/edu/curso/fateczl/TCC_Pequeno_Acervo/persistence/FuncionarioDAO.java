package br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Funcionario;

@Repository
public class FuncionarioDAO implements ICRUD<Funcionario>{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public String cadastrar(Funcionario f) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String sql = "{CALL sp_cadastrar_funcionario (?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, f.getUsuario());
		cs.setString(2, f.getSenha());
		cs.setString(3, f.getCpf());
		cs.setString(4, f.getNome());
		cs.setString(5, f.getDataNasc().toString());
		cs.setString(6, f.getCep());
		cs.setString(7, f.getLogradouro());
		cs.setInt(8, f.getNumero_endereco());
		cs.setString(9, f.getTelefone());
		cs.registerOutParameter(10, Types.VARCHAR);
		cs.execute();
		
		String saida = cs.getString(10);
		
		cs.close();
		c.close();
		
		
		return saida;
	}

	@Override
	public String alterar(Funcionario f) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();

		
		String sql = "UPDATE Funcionario \r\n"
				+ "SET nome = ?,\r\n"
				+ "usuario = ?,\r\n"
				+ "senha = ?,\r\n"
				+ "cpf = ?,\r\n"
				+ "dataNasc = ?,\r\n"
				+ "cep = ?,\r\n"
				+ "logradouro = ?,\r\n"
				+ "numero_endereco = ?,\r\n"
				+ "telefone = ?\r\n"
				+ "WHERE IdFuncionario = ?";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = f.getDataNasc().format(formatter);
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, f.getNome());
		ps.setString(2, f.getUsuario());
		ps.setString(3, f.getSenha());
		ps.setString(4, f.getCpf());
		ps.setString(5, formattedString);
		ps.setString(6, f.getCep());
		ps.setString(7, f.getLogradouro());
		ps.setInt(8, f.getNumero_endereco());
		ps.setString(9, f.getTelefone());
		ps.setInt(10, f.getIdFuncionario());
		
		ps.execute();
		
		ps.close();
		c.close();
		
		
		
		return "Funcionario Atualizado";
	}

	@Override
	public String excluir(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "DELETE Funcionario"
				+ "   WHERE idFuncionario = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		
		return "Funcionario Excluido";
	}

	@Override
	public Funcionario buscar(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String sql = "SELECT IdFuncionario, nome, usuario, senha, cpf, dataNasc, cep, logradouro, numero_endereco, telefone FROM Funcionario WHERE IdFuncionario = ?\r\n"
				+ "";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Funcionario f = new Funcionario();
		if(rs.next()) {
		    
		    f.setIdFuncionario(rs.getInt("IdFuncionario"));
		    f.setNome(rs.getString("nome"));
		    f.setUsuario(rs.getString("usuario"));
		    f.setSenha(rs.getString("senha"));
		    f.setCpf(rs.getString("cpf"));
		    f.setDataNasc(LocalDate.parse(rs.getString("dataNasc")));
		    f.setCep(rs.getString("cep"));
		    f.setLogradouro(rs.getString("logradouro"));
		    f.setNumero_endereco(rs.getInt("numero_endereco"));
		    f.setTelefone(rs.getString("telefone"));
		   
			
		}
		rs.close();
		ps.close();
		c.close();
		return f;
	}

	@Override
	public List<Funcionario> listar() throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		List<Funcionario> lista = new ArrayList<>();
		String sql = "SELECT IdFuncionario, nome, usuario, senha, cpf, dataNasc, cep, logradouro, numero_endereco, telefone FROM Funcionario\r\n"
				+ "";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		    Funcionario f = new Funcionario();
		    f.setIdFuncionario(rs.getInt("IdFuncionario"));
		    f.setNome(rs.getString("nome"));
		    f.setUsuario(rs.getString("usuario"));
		    f.setSenha(rs.getString("senha"));
		    f.setCpf(rs.getString("cpf"));
		    f.setDataNasc(LocalDate.parse(rs.getString("DataNasc")));
		    f.setCep(rs.getString("cep"));
		    f.setLogradouro(rs.getString("logradouro"));
		    f.setNumero_endereco(rs.getInt("numero_endereco"));
		    f.setTelefone(rs.getString("telefone"));
		    lista.add(f);
			
		}
		rs.close();
		ps.close();
		c.close();
		return lista;
	}

}
