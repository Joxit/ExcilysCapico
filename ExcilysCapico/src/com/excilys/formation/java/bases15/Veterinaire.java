package com.excilys.formation.java.bases15;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Veterinaire {
	@XmlElementWrapper
	public Collection<Animal> lAnimaux;

	public Veterinaire() {
		lAnimaux = new ArrayList<>();
	}

	public boolean add(Animal a) {
		return lAnimaux.add(a);
	}

	public boolean remove(Animal a) {
		return lAnimaux.remove(a);
	}

	@Override
	public String toString() {
		return "Veto [lAnimaux=" + lAnimaux + "]";
	}

}
