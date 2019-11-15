package br.edu.utfpr.dv.sireata.model;

public class Departamento {
	
	private int idDepartamento;
	private Campus campus;
	private String nome;
	private String nomeCompleto;
	private byte[] logo;
	private boolean ativo;
	private String site;
	
	public Departamento(){
		this.setIdDepartamento(0);
		this.setCampus(new Campus());
		this.setNome("");
		this.setNomeCompleto("");
		this.setLogo(null);
		this.setAtivo(true);
		this.setSite("");
	}
	
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCompleto(){
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto){
		this.nomeCompleto = nomeCompleto;
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
