package com.excilys.formation.java.bases15;


public class Adresse {

	public enum type {
		AVENUE, RUE, BOULVARD
	}

	private type rue;
	private int numero;
	private String lieu;

	public Adresse() {

	}

	public Adresse(type rue, int numero, String lieu) {
		this.rue = rue;
		this.numero = numero;
		this.lieu = lieu;
	}

	public type getRue() {
		return rue;
	}

	public void setRue(type rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
