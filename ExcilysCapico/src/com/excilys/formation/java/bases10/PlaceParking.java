package com.excilys.formation.java.bases10;

public class PlaceParking implements Comparable<PlaceParking> {
	private int number;
	private char letter;

	public PlaceParking(final int n, final char c) {
		number = n;
		letter = c;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(final int number) {
		this.number = number;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(final char letter) {
		this.letter = letter;
	}

	@Override
	public int compareTo(final PlaceParking pp) {
		final int cmp = Character.compare(letter, pp.letter);
		if (cmp != 0) {
			return cmp;
		}
		return Integer.compare(pp.number, number);
	}

	@Override
	public String toString() {
		return "PlaceParking [number=" + number + ", letter=" + letter + "]";
	}

}
