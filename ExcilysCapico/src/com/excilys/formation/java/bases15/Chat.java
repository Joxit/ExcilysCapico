package com.excilys.formation.java.bases15;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Chat extends Animal {
	public Chat() {

	}

	public Chat(String tag, String prenom, Adresse adresse) {
		super(tag, "miaule", prenom, adresse);
	}

}
