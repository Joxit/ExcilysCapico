package com.excilys.formation.java.bases10;

public class Base10Test {
	public static void main(final String[] args) {
		final Garage g = new Garage();
		final CarteGarage cg = new CarteGarage();
		final GarageTri gt = new GarageTri();
		final PlaceGarageTri pgt = new PlaceGarageTri();
		final Voiture v1 = new Voiture("BMW", "Z3", 50000.0);
		final Voiture v2 = new Voiture("BMW", "Z4", 50000.0);
		final Voiture v3 = new Voiture("Audi", "TT", 50000.0);
		final PlaceParking pp1 = new PlaceParking(10, 'A');
		final PlaceParking pp2 = new PlaceParking(10, 'B');
		final PlaceParking pp3 = new PlaceParking(20, 'B');

		System.out.println("Exercice 25");
		g.add(v1);
		g.add(v3);
		g.add(v2);
		System.out.println(g);
		g.remove();
		System.out.println(g);

		System.out.println("Exercice 26");
		cg.add(pp1, v1);
		cg.add(pp2, v2);
		cg.add(pp3, v3);
		System.out.println(cg);
		System.out.println("suppression de " + pp2 + " Voiture : " + cg.remove(pp2) + " " + cg);

		System.out.println("Exercice 27");
		gt.add(v1);
		System.out.println(gt);
		gt.add(v2);
		System.out.println(gt);
		gt.add(v3);
		System.out.println(gt);

		System.out.println("Exercice 28");
		pgt.add(pp1, v1);
		System.out.println(pgt);
		pgt.add(pp2, v2);
		System.out.println(pgt);
		pgt.add(pp3, v3);
		System.out.println(pgt);

	}

}
