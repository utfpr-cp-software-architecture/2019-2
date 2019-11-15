package br.edu.utfpr.dv.sireata.model;

public class OrgaoMembro {
	
	private int idMembro;
	private Usuario usuario;
	private String designacao;
	
	public OrgaoMembro(){
		this.setIdMembro(0);
		this.setUsuario(new Usuario());
		this.setDesignacao("");
	}
	
	public int getIdMembro() {
		return idMembro;
	}
	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDesignacao() {
		return designacao;
	}
	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

}
