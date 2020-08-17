package it.polito.tdp.lab04.model;

public class Corso {

	private String codins, nome;
	private Integer crediti, pd;
	
	
	public Corso(String codins, Integer crediti, String nome, Integer pd) {
		super();
		this.codins = codins;
		this.nome = nome;
		this.crediti = crediti;
		this.pd = pd;
	}
	
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCrediti() {
		return crediti;
	}
	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}
	public Integer getPd() {
		return pd;
	}
	public void setPd(Integer pd) {
		this.pd = pd;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	
	
}
