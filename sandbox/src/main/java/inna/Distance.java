package inna;

public class Distance {
	public static void main (String[] args) {

		Point p1 = new Point (7, -6);
		Point p2 = new Point (-5, 0);

		System.out.println ("Расстояние между двумя точками " + p1.coordinatesInTheBrackets() + " и " + p2.coordinatesInTheBrackets()  + " = " + p1.distance(p2));
	}
}