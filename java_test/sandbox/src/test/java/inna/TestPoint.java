package inna;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoint {

  @Test
  public void testDistance() {
    Point p1 = new Point(4,5);
    Point p2 = new Point(4,5);
    Assert.assertEquals(p1.distance (p2), 0.0);
    p1 = new Point (7,-6);
    p2 = new Point (-5,0);
    Assert.assertEquals(p1.distance (p2), 13.416407864998739);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(7,-6);
    Point p2 = new Point(-5,0);
    Assert.assertTrue(p1.distance (p2) == 13.416407864998739);
  }

  @Test
  public void testCoordinatesInBrackets() {
    Point p1 = new Point(6.45, 8.99);

    Assert.assertEquals(p1.coordinatesInTheBrackets(), "(6.45,8.99)");
  }
}
