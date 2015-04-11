package com.excilys.formation.java.bases10;

import java.util.Comparator;

public class VoiuresComparator implements Comparator<Voiture> {

	@Override
	public int compare(final Voiture v1, final Voiture v2) {
		int cmp = Double.compare(v1.getPrix(), v2.getPrix());
		if (cmp != 0) {
			return cmp;
		}
		if (v1.getMarque() != null) {
			cmp = v1.getMarque().compareTo(v2.getMarque());
			if (cmp != 0) {
				return cmp;
			}
		} else if (v2.getMarque() != null) {
			return 1;
		}
		if (v1.getModele() != null) {
			cmp = v1.getModele().compareTo(v2.getModele());
			if (cmp != 0) {
				return cmp;
			}
		} else if (v2.getModele() != null) {
			return 1;
		}
		return 0;
	}
}
