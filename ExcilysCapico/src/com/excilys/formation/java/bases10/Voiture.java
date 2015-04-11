package com.excilys.formation.java.bases10;

public class Voiture {
	private String marque;
	private String modele;
	private double prix;

	public Voiture(final String marque, final String modele, final double prix) {
		this.marque = marque;
		this.modele = modele;
		this.prix = prix;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(final String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(final String modele) {
		this.modele = modele;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(final double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", modele=" + modele + ", prix=" + prix + "]";
	}

}
