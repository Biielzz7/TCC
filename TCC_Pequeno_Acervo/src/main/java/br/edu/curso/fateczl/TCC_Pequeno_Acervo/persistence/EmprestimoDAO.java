package br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Emprestimo;

@Repository
public class EmprestimoDAO implements ICRUD<Emprestimo>{
	
	@Autowired
	GenericDAO gDAO;

	@Override
	public String cadastrar(Emprestimo e) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "{CALL sp_cadastrar_livro_emprestimo(?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, e.getTitulo());
		cs.setString(2, e.getUsuario());
		cs.setString(3, e.getDataEmprestimo().toString());
		cs.setString(4, e.getDataDevolucao().toString());
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.execute();
		
		String saida = cs.getString(5);
		
		return saida;
	}

	@Override
	public String alterar(Emprestimo e) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "UPDATE Emprestimo"
				+ "   SET estado = ?"
				+ "   WHERE IdEmprestimo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, e.getEstado());
		ps.setInt(2, e.getIdEmprestimo());
		ps.execute();
		
		ps.close();
		c.close();
		
		return "Emprestimo modificado";
	}

	@Override
	public String excluir(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "{CALL sp_excluir_emprestimo(?,?)}";
		
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
	public Emprestimo buscar(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		Emprestimo e = new Emprestimo();
		String sql = "SELECT e.IdEmprestimo,\r\n"
				+ "       ie.IdItemEmprestimo,\r\n"
				+ "       e.dataEmprestimo,\r\n"
				+ "	   e.dataDevolucao,\r\n"
				+ "	   e.estado,\r\n"
				+ "	   l.titulo,\r\n"
				+ "	   u.nome\r\n"
				+ "FROM ItemEmprestimo ie, Emprestimo e, Livro L, Usuario u\r\n"
				+ "WHERE l.IdLivro = ie.IdLivro\r\n"
				+ "  AND ie.IdItemEmprestimo = e.IdItemEmprestimo\r\n"
				+ "  AND e.IdUsuario = u.IdUsuario"
				+ "  AND e.IdEmprestimo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			
			e.setIdEmprestimo(rs.getInt("IdEmprestimo"));
			e.setIdItemEmprestimo(rs.getInt("IdItemEmprestimo"));
			e.setDataEmprestimo(LocalDate.parse(rs.getString("dataEmprestimo")));
			e.setDataDevolucao(LocalDate.parse(rs.getString("dataDevolucao")));
			e.setEstado(rs.getString("estado"));
			e.setTitulo(rs.getString("titulo"));
			e.setUsuario(rs.getString("nome"));
		
			
		}
		
		rs.close();
		ps.close();
		c.close();
		return e;
	}

	@Override
	public List<Emprestimo> listar() throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String proc = "{CALL sp_mudar_status_emprestimo}";
		CallableStatement cs = c.prepareCall(proc);
		cs.execute();
		cs.close();
		
		//-----------
		
		List<Emprestimo> emprestimos = new ArrayList<>();
		String sql = "SELECT e.IdEmprestimo,\r\n"
				+ "       ie.IdItemEmprestimo,\r\n"
				+ "       e.dataEmprestimo,\r\n"
				+ "	   e.dataDevolucao,\r\n"
				+ "	   e.estado,\r\n"
				+ "	   l.titulo,\r\n"
				+ "	   u.nome\r\n"
				+ "FROM ItemEmprestimo ie, Emprestimo e, Livro L, Usuario u\r\n"
				+ "WHERE l.IdLivro = ie.IdLivro\r\n"
				+ "  AND ie.IdItemEmprestimo = e.IdItemEmprestimo\r\n"
				+ "  AND e.IdUsuario = u.IdUsuario";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
	
		

		while(rs.next()) {
			Emprestimo e = new Emprestimo();
			e.setIdEmprestimo(rs.getInt("IdEmprestimo"));
			e.setIdItemEmprestimo(rs.getInt("IdItemEmprestimo"));
			e.setDataEmprestimo(LocalDate.parse(rs.getString("dataEmprestimo")));
			e.setDataDevolucao(LocalDate.parse(rs.getString("dataDevolucao")));
			e.setEstado(rs.getString("estado"));
			e.setTitulo(rs.getString("titulo"));
			e.setUsuario(rs.getString("nome"));
		
			emprestimos.add(e);
		}
		
		rs.close();
		ps.close();
		c.close();
		return emprestimos;
	}

}
