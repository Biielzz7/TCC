package br.edu.curso.fateczl.TCC_Pequeno_Acervo.model;

import java.time.LocalDate;

abstract class Pessoa {

	private String usuario;
	private String senha;
	private String cpf;
	private String nome;
	private LocalDate dataNasc;
	private String cep;
	private String logradouro;
	private int numero_endereco;
	private String telefone;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero_endereco() {
		return numero_endereco;
	}
	public void setNumero_endereco(int numero_endereco) {
		this.numero_endereco = numero_endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Pessoa [usuario=" + usuario + ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + ", dataNasc="
				+ dataNasc + ", cep=" + cep + ", logradouro=" + logradouro + ", numero_endereco=" + numero_endereco
				+ ", telefone=" + telefone + "]";
	}
	
	
	
	
}
