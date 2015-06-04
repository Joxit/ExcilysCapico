package com.excilys.formation.java.bases12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Voiture {
	private String marque;
	private String immatriculation;
	private String couleur;
	private double prix;

	public Voiture() {
		this.marque = "DeLorean";
		this.immatriculation = "DMC-12";
		this.couleur = "gris";
		this.prix = 541.054;
	}

	public Voiture(String marque, String immatriculation, String couleur,
			double prix) {
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.couleur = couleur;
		this.prix = prix;
	}

	public String getImmatriculation() {

		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("destruction : " + this);
		marque = null;
		immatriculation = null;
		couleur = null;
		prix = 0.0;
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", immatriculation="
				+ immatriculation + ", couleur=" + couleur + ", prix=" + prix
				+ "]";
	}

	public static void main(String[] args) {
		Voiture v = new Voiture();
		System.out.println("Attributs");
		for (Field f : v.getClass().getDeclaredFields()) {
			System.out.println(f);
		}
		System.out.println("Methodes");
		for (Method m : v.getClass().getMethods()) {
			System.out.println(m);
		}
		System.out.println("Constructeur");
		for (Constructor<?> c : v.getClass().getConstructors()) {
			System.out.println(c);
		}
		v = null;
		System.gc();
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {

		}
	}
}
