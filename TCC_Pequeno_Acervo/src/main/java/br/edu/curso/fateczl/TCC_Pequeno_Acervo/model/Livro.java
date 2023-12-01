package br.edu.curso.fateczl.TCC_Pequeno_Acervo.model;

public class Livro {


	private int idLivro;
	private String isbn;
	private int quantidade;
	private String titulo;
	private String editora;
	private String nomeAutor;
	private String tombo;
	private String disponibilidade;
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getTombo() {
		return tombo;
	}
	public void setTombo(String tombo) {
		this.tombo = tombo;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", isbn=" + isbn + ", quantidade=" + quantidade + ", titulo=" + titulo
				+ ", editora=" + editora + ", nomeAutor=" + nomeAutor + ", tombo=" + tombo + ", disponibilidade="
				+ disponibilidade + "]";
	}
	


	

}

