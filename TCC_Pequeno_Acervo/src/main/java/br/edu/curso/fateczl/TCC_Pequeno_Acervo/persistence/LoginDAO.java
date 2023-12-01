package br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.curso.fateczl.TCC_Pequeno_Acervo.model.Login;

@Repository
public class LoginDAO {
	
	@Autowired
	GenericDAO gDAO;
	
	public Login realizarLogin(String usuario, String senha) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();	
		Login l = new Login();
		
		String sql = "SELECT id_acesso, tipo_acesso FROM dbo.fn_login_acesso(?,?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, usuario);
		ps.setString(2, senha);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
		l.setId_usuario(rs.getInt("id_acesso"));
		l.setAcesso_tipo(rs.getString("tipo_acesso"));
		
		}
		ps.close();
		rs.close();
		c.close();
		return l;
	}

}
