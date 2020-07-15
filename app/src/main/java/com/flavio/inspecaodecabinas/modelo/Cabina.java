package com.flavio.inspecaodecabinas.modelo;

import java.util.List;

/**
 * Criado por...
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Cabina {
	private int id;
	private String np;
	private String fz;
	private Pais pais;
	private Serie serie;
	private Baumuster baumuster;
	private List<Code> codes;
	private boolean inspecionada;

	public Cabina() {
	}

	public Cabina(int id, String np, String fz, Pais pais, Serie serie, Baumuster baumuster, List<Code> codes,
				  boolean inspecionada) {
		this.id = id;
		this.np = np;
		this.fz = fz;
		this.pais = pais;
		this.serie = serie;
		this.baumuster = baumuster;
		this.codes = codes;
		this.inspecionada = inspecionada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNp() {
		return np;
	}

	public void setNp(String np) {
		this.np = np;
	}

	public String getFz() {
		return fz;
	}

	public void setFz(String fz) {
		this.fz = fz;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Baumuster getBaumuster() {
		return baumuster;
	}

	public void setBaumuster(Baumuster baumuster) {
		this.baumuster = baumuster;
	}

	public List<Code> getCodes() {
		return codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

	public boolean isInspecionada() {
		return inspecionada;
	}

	public void setInspecionada(boolean inspecionada) {
		this.inspecionada = inspecionada;
	}
}
