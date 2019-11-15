package br.edu.utfpr.dv.sireata.model;

public class AtaParticipante {
	
	private int idAtaParticipante;
	private Ata ata;
	private Usuario participante;
	private boolean presente;
	private String motivo;
	private String designacao;
	private boolean membro;
	
	public AtaParticipante(){
		this.setIdAtaParticipante(0);
		this.setAta(new Ata());
		this.setParticipante(new Usuario());
		this.setPresente(true);
		this.setMotivo("");
		this.setDesignacao("");
		this.setMembro(false);
	}
	
	public int getIdAtaParticipante() {
		return idAtaParticipante;
	}
	public void setIdAtaParticipante(int idAtaParticipante) {
		this.idAtaParticipante = idAtaParticipante;
	}
	public Ata getAta() {
		return ata;
	}
	public void setAta(Ata ata) {
		this.ata = ata;
	}
	public Usuario getParticipante() {
		return participante;
	}
	public void setParticipante(Usuario participante) {
		this.participante = participante;
	}
	public boolean isPresente() {
		return presente;
	}
	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDesignacao() {
		return designacao;
	}
	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	public boolean isMembro() {
		return membro;
	}
	public void setMembro(boolean membro) {
		this.membro = membro;
	}

}
