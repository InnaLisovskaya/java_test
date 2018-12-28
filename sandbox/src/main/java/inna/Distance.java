package inna;

public class Distance {
	public static void main (String[] args) {

		Point p1 = new Point ();
		Point p2 = new Point ();

		p1.x = 3;
		p1.y = 5;

		p2.x = 2;
		p2.y = 9;

		System.out.println (message (p1.x, p2.x, p1.y, p2.y) + distance(p1, p2));
	}

	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
	}

	public static String message (double x1, double y1, double x2, double y2) {
		return "Расстояние между двумя точками (" + x1 + "," + y1 + ") и (" + x2 + "," + y2 + ") = ";
	}
}