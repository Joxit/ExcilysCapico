package com.excilys.formation.java.bases10;

import java.util.Set;
import java.util.TreeSet;

public class GarageTri {
	private final Set<Voiture> voitureSorted;

	public GarageTri() {
		voitureSorted = new TreeSet<>(new VoiuresComparator());
	}

	public void add(final Voiture v) {
		voitureSorted.add(v);
	}

	public void remove(final Voiture v) {
		voitureSorted.remove(v);
	}

	@Override
	public String toString() {
		return "GarageTri [voitureSorted=" + voitureSorted + "]";
	}
}
