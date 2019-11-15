package br.edu.utfpr.dv.sireata.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.utfpr.dv.sireata.util.DateUtils;

public class Ata {
	
	public enum TipoAta{
		ORDINARIA(0), EXTRAORDINARIA(1);
		
		private final int value; 
		TipoAta(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static TipoAta valueOf(int value){
			for(TipoAta u : TipoAta.values()){
				if(u.getValue() == value){
					return u;
				}
			}
			
			return null;
		}
		
		public String toString(){
			switch(this){
				case ORDINARIA:
					return "Ordinária";
				case EXTRAORDINARIA:
					return "Extraordinária";
				default:
					return "";
			}
		}
	}
	
	private int idAta;
	private Orgao orgao;
	private Usuario presidente;
	private Usuario secretario;
	private TipoAta tipo;
	private int numero;
	private Date data;
	private String local;
	private String localCompleto;
	private Date dataLimiteComentarios;
	private String consideracoesIniciais;
	private boolean aceitarComentarios;
	private byte[] audio;
	private boolean publicada;
	private Date dataPublicacao;
	private byte[] documento;
	private List<Pauta> pauta;
	private List<AtaParticipante> participantes;
	private List<Anexo> anexos;
	
	public Ata(){
		this.setIdAta(0);
		this.setOrgao(new Orgao());
		this.setPresidente(new Usuario());
		this.setSecretario(new Usuario());
		this.setTipo(TipoAta.ORDINARIA);
		this.setNumero(0);
		this.setData(DateUtils.getNow().getTime());
		this.setLocal("");
		this.setLocalCompleto("");
		this.setDataLimiteComentarios(DateUtils.getToday().getTime());
		this.setConsideracoesIniciais("");
		this.setAudio(null);
		this.setPublicada(false);
		this.setDataPublicacao(new Date());
		this.setPauta(null);
		this.setParticipantes(null);
		this.setAnexos(null);
	}
	
	public int getIdAta() {
		return idAta;
	}
	public void setIdAta(int idAta) {
		this.idAta = idAta;
	}
	public Orgao getOrgao() {
		return orgao;
	}
	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}
	public Usuario getPresidente() {
		return presidente;
	}
	public void setPresidente(Usuario presidente) {
		this.presidente = presidente;
	}
	public Usuario getSecretario() {
		return secretario;
	}
	public void setSecretario(Usuario secretario) {
		this.secretario = secretario;
	}
	public TipoAta getTipo() {
		return tipo;
	}
	public void setTipo(TipoAta tipo) {
		this.tipo = tipo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLocalCompleto() {
		return localCompleto;
	}
	public void setLocalCompleto(String localCompleto) {
		this.localCompleto = localCompleto;
	}
	public Date getDataLimiteComentarios() {
		return dataLimiteComentarios;
	}
	public void setDataLimiteComentarios(Date dataLimiteComentarios) {
		this.dataLimiteComentarios = dataLimiteComentarios;
	}
	public String getConsideracoesIniciais() {
		return consideracoesIniciais;
	}
	public void setConsideracoesIniciais(String consideracoesIniciais) {
		this.consideracoesIniciais = consideracoesIniciais;
	}
	public byte[] getAudio() {
		return audio;
	}
	public void setAudio(byte[] audio) {
		this.audio = audio;
	}
	public boolean isPublicada() {
		return publicada;
	}
	public void setPublicada(boolean publicada) {
		this.publicada = publicada;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public byte[] getDocumento(){
		return this.documento;
	}
	public void setDocumento(byte[] documento){
		this.documento = documento;
	}
	public List<Pauta> getPauta() {
		return pauta;
	}
	public void setPauta(List<Pauta> pauta) {
		this.pauta = pauta;
	}
	public List<AtaParticipante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<AtaParticipante> participantes) {
		this.participantes = participantes;
	}
	public boolean isAceitarComentarios() {
		return aceitarComentarios;
	}
	public void setAceitarComentarios(boolean aceitarComentarios) {
		this.aceitarComentarios = aceitarComentarios;
	}
	public List<Anexo> getAnexos() {
		return anexos;
	}
	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}
	public String getNome(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.format(this.getData());
	}

}
