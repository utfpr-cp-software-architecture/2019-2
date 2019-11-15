package br.edu.utfpr.dv.sireata.model;

public class Campus {
	
	private int idCampus;
	private String nome;
	private String endereco;
	private byte[] logo;
	private boolean ativo;
	private String site;
	
	public Campus(){
		this.setIdCampus(0);
		this.setNome("");
		this.setEndereco("");
		this.setLogo(null);
		this.setAtivo(true);
		this.setSite("");
	}
	
	public int getIdCampus() {
		return idCampus;
	}
	public void setIdCampus(int idCampus) {
		this.idCampus = idCampus;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getSite(){
		return site;
	}
	public void setSite(String site){
		this.site = site;
	}
	
	public String toString(){
		return this.getNome();
	}

}
