package br.edu.curso.fateczl.TCC_Pequeno_Acervo.model;

import java.time.LocalDate;

public class Emprestimo {
	
	private int idEmprestimo;
	private int  idItemEmprestimo;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private String estado;
	private String titulo;
	private String usuario;
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public int getIdItemEmprestimo() {
		return idItemEmprestimo;
	}
	public void setIdItemEmprestimo(int idItemEmprestimo) {
		this.idItemEmprestimo = idItemEmprestimo;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Emprestimo [idEmprestimo=" + idEmprestimo + ", idItemEmprestimo=" + idItemEmprestimo
				+ ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", estado=" + estado
				+ ", titulo=" + titulo + ", usuario=" + usuario + "]";
	}

	
}
