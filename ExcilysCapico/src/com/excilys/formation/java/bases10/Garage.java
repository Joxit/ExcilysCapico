package com.excilys.formation.java.bases10;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	private final List<Voiture> lVoitures;

	public Garage() {
		lVoitures = new ArrayList<Voiture>();
	}

	public void add(final Voiture v) {
		lVoitures.add(v);
	}

	public void remove() {
		lVoitures.remove(0);
	}

	@Override
	public String toString() {
		return "Garage [lVoitures=" + lVoitures + "]";
	}

}
