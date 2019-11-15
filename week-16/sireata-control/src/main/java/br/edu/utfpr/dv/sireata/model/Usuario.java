package br.edu.utfpr.dv.sireata.model;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private boolean externo;
	private boolean ativo;
	private boolean administrador;

	public Usuario(){
		this.setIdUsuario(0);
		this.setNome("");
		this.setLogin("");
		this.setSenha("");
		this.setEmail("");
		this.setExterno(true);
		this.setAtivo(true);
		this.setAdministrador(false);
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setExterno(boolean externo){
		this.externo = externo;
	}
	public boolean isExterno(){
		return externo;
	}
	public void setAtivo(boolean ativo){
		this.ativo = ativo;
	}
	public boolean isAtivo(){
		return ativo;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	
	@Override
	public String toString(){
		return this.getNome();
	}
	
	@Override
    public boolean equals(final Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }else if(this.getIdUsuario() == ((Usuario)object).getIdUsuario()){
        	return true;
        }else{
        	return false;
        }
    }

}
