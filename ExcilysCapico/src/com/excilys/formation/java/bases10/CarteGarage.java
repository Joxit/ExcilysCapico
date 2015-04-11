package com.excilys.formation.java.bases10;

import java.util.HashMap;
import java.util.Map;

public class CarteGarage {
	private final Map<PlaceParking, Voiture> hmVoiturePlace;

	public CarteGarage() {
		hmVoiturePlace = new HashMap<>();
	}

	public void add(final PlaceParking pp, final Voiture v) {
		hmVoiturePlace.put(pp, v);
	}

	public Voiture remove(final PlaceParking pp) {
		return hmVoiturePlace.remove(pp);
	}

	@Override
	public String toString() {
		return "CarteGarage [hmVoiturePlace=" + hmVoiturePlace + "]";
	}
}
