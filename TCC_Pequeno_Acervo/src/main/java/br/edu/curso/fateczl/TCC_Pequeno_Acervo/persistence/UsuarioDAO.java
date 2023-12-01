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

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Usuario;

@Repository
public class UsuarioDAO implements ICRUD<Usuario> {
	
	@Autowired
	GenericDAO gDAO;

	@Override
	public String cadastrar(Usuario u) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String sql = "{CALL sp_cadastrar_usuario (?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, u.getUsuario());
		cs.setString(2, u.getSenha());
		cs.setString(3, u.getCpf());
		cs.setString(4, u.getNome());
		cs.setString(5, u.getDataNasc().toString());
		cs.setString(6, u.getCep());
		cs.setString(7, u.getLogradouro());
		cs.setInt(8, u.getNumero_endereco());
		cs.setString(9, u.getTelefone());
		cs.registerOutParameter(10, Types.VARCHAR);
		cs.execute();
		
		String saida = cs.getString(10);
		
		cs.close();
		c.close();
		
		
		return saida;
	}

	@Override
	public String alterar(Usuario u) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();

		
		String sql = "UPDATE Usuario \r\n"
				+ "SET nome = ?,\r\n"
				+ "usuario = ?,\r\n"
				+ "senha = ?,\r\n"
				+ "cpf = ?,\r\n"
				+ "dataNasc = ?,\r\n"
				+ "cep = ?,\r\n"
				+ "logradouro = ?,\r\n"
				+ "numero_endereco = ?,\r\n"
				+ "telefone = ?\r\n"
				+ "WHERE IdUsuario = ?";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = u.getDataNasc().format(formatter);
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, u.getNome());
		ps.setString(2, u.getUsuario());
		ps.setString(3, u.getSenha());
		ps.setString(4, u.getCpf());
		ps.setString(5, formattedString);
		ps.setString(6, u.getCep());
		ps.setString(7, u.getLogradouro());
		ps.setInt(8, u.getNumero_endereco());
		ps.setString(9, u.getTelefone());
		ps.setInt(10, u.getIdUsuario());

		ps.execute();
		
		ps.close();
		c.close();
		
		
		
		return "Usuario Atualizado";
	}

	@Override
	public String excluir(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "{CALL sp_excluir_usuario(?,?)}";

		CallableStatement cs = c.prepareCall(sql);
		cs.setInt(1, id);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		
		String saida = cs.getString(2);
		
		cs.close();
		c.close();
		
		return saida;
	}

	@Override
	public Usuario buscar(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String sql = "SELECT IdUsuario, nome, usuario, senha, cpf, dataNasc, cep, logradouro, numero_endereco, telefone FROM Usuario WHERE IdUsuario = ?\r\n"
				+ "";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Usuario u = new Usuario();
		if(rs.next()) {
		    
		    u.setIdUsuario(rs.getInt("IdUsuario"));
		    u.setNome(rs.getString("nome"));
		    u.setUsuario(rs.getString("usuario"));
		    u.setSenha(rs.getString("senha"));
		    u.setCpf(rs.getString("cpf"));
		    u.setDataNasc(LocalDate.parse(rs.getString("dataNasc")));
		    u.setCep(rs.getString("cep"));
		    u.setLogradouro(rs.getString("logradouro"));
		    u.setNumero_endereco(rs.getInt("numero_endereco"));
		    u.setTelefone(rs.getString("telefone"));
		   
			
		}
		rs.close();
		ps.close();
		c.close();
		return u;
	}

	@Override
	public List<Usuario> listar() throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT IdUsuario, nome, usuario, senha, cpf, dataNasc, cep, logradouro, numero_endereco, telefone FROM Usuario\r\n"
				+ "";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		    Usuario u = new Usuario();
		    u.setIdUsuario(rs.getInt("IdUsuario"));
		    u.setNome(rs.getString("nome"));
		    u.setUsuario(rs.getString("usuario"));
		    u.setSenha(rs.getString("senha"));
		    u.setCpf(rs.getString("cpf"));
		    u.setDataNasc(LocalDate.parse(rs.getString("DataNasc")));
		    u.setCep(rs.getString("cep"));
		    u.setLogradouro(rs.getString("logradouro"));
		    u.setNumero_endereco(rs.getInt("numero_endereco"));
		    u.setTelefone(rs.getString("telefone"));
		    lista.add(u);
			
		}
		rs.close();
		ps.close();
		c.close();
		return lista;
	}

}
