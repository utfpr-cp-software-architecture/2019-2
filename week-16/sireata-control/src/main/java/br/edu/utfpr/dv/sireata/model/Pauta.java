package br.edu.utfpr.dv.sireata.model;

public class Pauta {
	
	private int idPauta;
	private Ata ata;
	private int ordem;
	private String titulo;
	private String descricao;
	
	public Pauta(){
		this.setIdPauta(0);
		this.setAta(new Ata());
		this.setOrdem(1);
		this.setTitulo("");
		this.setDescricao("");
	}
	
	public int getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(int idPauta) {
		this.idPauta = idPauta;
	}
	public Ata getAta() {
		return ata;
	}
	public void setAta(Ata ata) {
		this.ata = ata;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
