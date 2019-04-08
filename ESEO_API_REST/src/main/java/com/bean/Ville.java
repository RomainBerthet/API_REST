package com.bean;

public class Ville {
	
	private String codeINSEE;
	private String nom;
	private String cp;
	private Double lati;
	private Double longi;

	public Ville(String codeINSEE, String nom, String cp, Double lati, Double longi) {
		this.codeINSEE = codeINSEE;
		this.nom = nom;
		this.cp = cp;
		this.lati = lati;
		this.longi = longi;
	}

	public String getCodeINSEE() {
		return codeINSEE;
	}

	public void setCodeINSEE(String codeINSEE) {
		this.codeINSEE = codeINSEE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Double getLati() {
		return lati;
	}

	public void setLati(Double lati) {
		this.lati = lati;
	}

	public Double getLongi() {
		return longi;
	}

	public void setLongi(Double longi) {
		this.longi = longi;
	}
}
