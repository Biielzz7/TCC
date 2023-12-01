package br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Livro;

@Repository
public class LivroDAO implements ICRUD<Livro>{
	
	@Autowired
	GenericDAO gDAO;

	@Override
	public String cadastrar(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "{CALL sp_cadastrar_livro (?,?,?,?,?,?,?)}";
		
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, l.getIsbn());
		cs.setInt(2, l.getQuantidade());
		cs.setString(3, l.getTitulo());
		cs.setString(4, l.getEditora());
		cs.setString(5, l.getNomeAutor());
		cs.setString(6, l.getTombo());
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.execute();
		
		String saida = cs.getString(7);
		
		cs.close();
		c.close();
		
		return saida;
	}

	@Override
	public String alterar(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "UPDATE Livro\r\n"
				+ "SET isbn = ?,\r\n"
				+ "    quantidade = ?,\r\n"
				+ "	titulo = ?,\r\n"
				+ "	editora = ?,\r\n"
				+ "	nomeAutor = ?,\r\n"
				+ "	tombo = ?,\r\n"
				+ "	disponibilidade = ?\r\n"
				+ "WHERE IdLivro = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, l.getIsbn());
		ps.setInt(2, l.getQuantidade());
		ps.setString(3, l.getTitulo());
		ps.setString(4, l.getEditora());
		ps.setString(5, l.getNomeAutor());
		ps.setString(6, l.getTombo());
		ps.setString(7, l.getDisponibilidade());
		ps.setInt(8, l.getIdLivro());
		
		ps.execute();
		
		ps.close();
		c.close();
		
		return "Livro Atualizado";
	}

	@Override
	public String excluir(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "{CALL sp_excluir_livro(?,?)}";
		
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
	public Livro buscar(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		Livro l = new Livro();
		
		String sql = "SELECT IdLivro, isbn, quantidade, titulo, editora, nomeAutor, tombo, disponibilidade FROM Livro WHERE IdLivro = ?\r\n"
				+ "";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {		
			
			l.setIdLivro(rs.getInt("IdLivro"));
			l.setIsbn(rs.getString("isbn"));
			l.setQuantidade(rs.getInt("quantidade"));
			l.setTitulo(rs.getString("titulo"));
			l.setEditora(rs.getString("editora"));
			l.setNomeAutor(rs.getString("nomeAutor"));
			l.setTombo(rs.getString("tombo"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			
		
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return l;
	}

	@Override
	public List<Livro> listar() throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String proc = "{CALL sp_mudar_disponibilidade}";
		CallableStatement cs = c.prepareCall(proc);
		cs.execute();
		
		List<Livro> livros = new ArrayList<>();
		
		String sql = "SELECT IdLivro, isbn, quantidade, titulo, editora, nomeAutor, tombo, disponibilidade FROM Livro ORDER BY titulo\r\n"
				+ "";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Livro l = new Livro();
			l.setIdLivro(rs.getInt("IdLivro"));
			l.setIsbn(rs.getString("isbn"));
			l.setQuantidade(rs.getInt("quantidade"));
			l.setTitulo(rs.getString("titulo"));
			l.setEditora(rs.getString("editora"));
			l.setNomeAutor(rs.getString("nomeAutor"));
			l.setTombo(rs.getString("tombo"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
		
			livros.add(l);
	
			
		}
	
		
		rs.close();
		ps.close();
		c.close();
		
		return livros;
	}


}
