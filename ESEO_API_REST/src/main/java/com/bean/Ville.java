package com.bean;

public class Ville {
	
	private int codeINSEE;
	private String nom;
	private int cp;
	private String lati;
	private String longi;

	public Ville(int codeINSEE, String nom, int cp, String lati, String longi) {
		this.codeINSEE = codeINSEE;
		this.nom = nom;
		this.cp = cp;
		this.lati = lati;
		this.longi = longi;
	}

	public int getCodeINSEE() {
		return codeINSEE;
	}

	public void setCodeINSEE(int codeINSEE) {
		this.codeINSEE = codeINSEE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}
}
