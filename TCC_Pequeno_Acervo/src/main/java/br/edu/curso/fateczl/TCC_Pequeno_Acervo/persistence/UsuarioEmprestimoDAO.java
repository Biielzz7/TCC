package br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Emprestimo;

@Repository
public class UsuarioEmprestimoDAO {
	
	@Autowired
	GenericDAO gDAO;

	public List<Emprestimo> consultarEmprestimo(int id) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		String proc = "{CALL sp_mudar_status_emprestimo}";
		CallableStatement cs = c.prepareCall(proc);
		cs.execute();
		cs.close();
		
		//-------------------
		
		List<Emprestimo> emprestimos = new ArrayList<>();
		String sql = "SELECT u.IdUsuario,\r\n"
				+ "       e.dataEmprestimo,\r\n"
				+ "       e.dataDevolucao,\r\n"
				+ "	   l.titulo,\r\n"
				+ "	   e.estado\r\n"
				+ "FROM Emprestimo e, ItemEmprestimo ie, Livro l,Usuario u\r\n"
				+ "WHERE e.IdItemEmprestimo = ie.IdItemEmprestimo\r\n"
				+ "  AND ie.IdLivro = l.IdLivro\r\n"
				+ "  AND u.IdUsuario = e.IdUsuario\r\n"
				+ "  AND u.IdUsuario = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Emprestimo e = new Emprestimo();
            e.setIdEmprestimo(0);
            e.setIdItemEmprestimo(0);
			e.setDataEmprestimo(LocalDate.parse(rs.getString("dataEmprestimo")));
			e.setDataDevolucao(LocalDate.parse(rs.getString("dataDevolucao")));
			e.setEstado(rs.getString("estado"));
			e.setTitulo(rs.getString("titulo"));
			e.setUsuario("usuario");
			System.out.println(e);
			emprestimos.add(e);
			
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return emprestimos;
	}
}
