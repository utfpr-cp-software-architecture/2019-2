package br.edu.utfpr.dv.sireata.model;

public class Anexo {
	
	private int idAnexo;
	private Ata ata;
	private int ordem;
	private String descricao;
	private byte[] arquivo;
	
	public Anexo() {
		this.setIdAnexo(0);
		this.setAta(new Ata());
		this.setDescricao("");
		this.setOrdem(0);
		this.setArquivo(null);
	}
	
	public int getIdAnexo() {
		return idAnexo;
	}
	public void setIdAnexo(int idAnexo) {
		this.idAnexo = idAnexo;
	}
	public Ata getAta() {
		return ata;
	}
	public void setAta(Ata ata) {
		this.ata = ata;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

}
