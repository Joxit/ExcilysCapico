package com.excilys.formation.java.bases15;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlSeeAlso({ Chien.class, Chat.class })
@XmlRootElement
public abstract class Animal {
	@XmlAttribute
	private String tag;
	@XmlElement
	private String cri;
	@XmlElement
	private String prenom;
	@XmlElement
	private Adresse adresse;

	public Animal() {

	}

	public Animal(String tag, String cri, String prenom, Adresse adresse) {
		super();
		this.tag = tag;
		this.cri = cri;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	@XmlTransient
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@XmlTransient
	public String getCri() {
		return cri;
	}

	public void setCri(String cri) {
		this.cri = cri;
	}

	@XmlTransient
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@XmlTransient
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [tag=" + tag + ", cri=" + cri
				+ ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

}
