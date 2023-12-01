package br.edu.curso.fateczl.TCC_Pequeno_Acervo.persistence;

import java.sql.SQLException;
import java.util.List;


public interface ICRUD<T> {
	
	public String cadastrar(T t) throws SQLException, ClassNotFoundException;
	public String alterar(T t) throws SQLException, ClassNotFoundException;
	public String excluir(int id) throws SQLException, ClassNotFoundException;
	public T buscar(int id) throws SQLException, ClassNotFoundException;
	public List<T> listar() throws SQLException, ClassNotFoundException;

}
