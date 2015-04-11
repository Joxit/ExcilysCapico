package com.excilys.formation.java.bases10;

import java.util.Map;
import java.util.TreeMap;

public class PlaceGarageTri {
	private final Map<PlaceParking, Voiture> tmPlaceVoiture;

	public PlaceGarageTri() {
		tmPlaceVoiture = new TreeMap<>();
	}

	public void add(final PlaceParking pp, final Voiture v) {
		tmPlaceVoiture.put(pp, v);
	}

	public Voiture remove(final PlaceParking pp) {
		return tmPlaceVoiture.remove(pp);
	}

	@Override
	public String toString() {
		return "PlaceGarageTri [tmPlaceVoiture=" + tmPlaceVoiture + "]";
	}
}
