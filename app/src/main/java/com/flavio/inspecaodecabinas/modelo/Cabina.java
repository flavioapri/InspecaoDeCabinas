package com.flavio.inspecaodecabinas.modelo;

import java.util.List;

/**
 * Representa uma cabina.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Cabina {
	private int id;
	private String sequencia;
	private String np;
	private String fz;
	private Pais pais;
	private Serie serie;
	private Baumuster baumuster;
	private List<Code> codes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
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
}
