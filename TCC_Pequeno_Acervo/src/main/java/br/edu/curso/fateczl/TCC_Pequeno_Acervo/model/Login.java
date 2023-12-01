package br.edu.curso.fateczl.TCC_Pequeno_Acervo.model;

public class Login {
	
    private int id_usuario;
	private String acesso_tipo;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getAcesso_tipo() {
		return acesso_tipo;
	}
	public void setAcesso_tipo(String acesso_tipo) {
		this.acesso_tipo = acesso_tipo;
	}
	@Override
	public String toString() {
		return "Login [id_usuario=" + id_usuario + ", acesso_tipo=" + acesso_tipo + "]";
	}
	
	

}
