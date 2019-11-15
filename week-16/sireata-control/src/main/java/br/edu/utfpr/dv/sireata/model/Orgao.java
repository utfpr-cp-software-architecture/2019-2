package br.edu.utfpr.dv.sireata.model;

import java.util.ArrayList;
import java.util.List;

public class Orgao {
	
	private int idOrgao;
	private Departamento departamento;
	private Usuario presidente;
	private Usuario secretario;
	private String nome;
	private String nomeCompleto;
	private String designacaoPresidente;
	private boolean ativo;
	private List<OrgaoMembro> membros;

	public Orgao(){
		this.setIdOrgao(0);
		this.setDepartamento(new Departamento());
		this.setPresidente(new Usuario());
		this.setSecretario(new Usuario());
		this.setNome("");
		this.setNomeCompleto("");
		this.setDesignacaoPresidente("");
		this.setAtivo(true);
		this.setMembros(new ArrayList<OrgaoMembro>());
	}
	
	public int getIdOrgao() {
		return idOrgao;
	}
	public void setIdOrgao(int idOrgao) {
		this.idOrgao = idOrgao;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getDesignacaoPresidente() {
		return designacaoPresidente;
	}
	public void setDesignacaoPresidente(String designacaoPresidente) {
		this.designacaoPresidente = designacaoPresidente;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<OrgaoMembro> getMembros() {
		return membros;
	}
	public void setMembros(List<OrgaoMembro> membros) {
		this.membros = membros;
	}
	
	public String toString(){
		return this.getNome();
	}

}
