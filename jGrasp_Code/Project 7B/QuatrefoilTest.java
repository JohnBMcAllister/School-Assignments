import org.junit.Assert;;
import org.junit.Before;
import org.junit.Test;

/** 
 * An Quatrefoil class tha contains a set of test methods to test
 * each of the methods in Quatrefoil.
 *
 * @author JB McAllister, COMP 1210-001
 * @version 03/17/2023
 */
public class QuatrefoilTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** tests the perimeter(). */
   @Test public void perimeterTest() {
      Quatrefoil s6 = new Quatrefoil("Small Example", 3.5);
      double answer = Math.PI * 3.5;
      Assert.assertEquals(answer, s6.perimeter(), .0001);
   }
   
   /** tests the perimeterInFt(). */
   @Test public void perimeterInFtTest() {
      Quatrefoil s7 = new Quatrefoil("Small Example", 3.5);
      double answer = (Math.PI * 3.5) / 12;
      Assert.assertEquals(answer, s7.perimeterInFt(), .0001);
   }
   
   /** test the area(). */
   @Test public void areaTest() {
      Quatrefoil s8 = new Quatrefoil("Small Example", 3.5);
      double answer = Math.pow(3.5 / 2, 2) + 2 
         * (Math.PI * Math.pow(3.5 / 2, 2) / 4);
      Assert.assertEquals(answer, s8.area(), .0001);
   }
   
   /** test the areaInSqFt(). */
   @Test public void areaInSqFtTest() {
      Quatrefoil s9 = new Quatrefoil("Small Example", 3.5);
      double answer = (Math.pow(3.5 / 2, 2) + 2 
         * (Math.PI * Math.pow(3.5 / 2, 2) / 4)) / 144;
      Assert.assertEquals(answer, s9.areaInSqFt(), .0001);
   }
   
   /** test the toString(). */
   @Test public void toStringTest() {
      Quatrefoil s10 = new Quatrefoil("Small Example", 3.5);
      String b = "Quatrefoil \"Small Example\" with diameter 3.5 inches has:\n"
             + "\tperimeter = 10.996 inches (or 0.916 feet)\n"
             + "\tarea = 7.873 square inches (or 0.055 square feet)\n";
      Assert.assertEquals("Not true", b, s10.toString());
   }
   
   /** test the resertCount(). */
   @Test public void resetCountTest() {
      Quatrefoil s12 = new Quatrefoil("Small Example", 3.5);
      s12.resetCount();
      Assert.assertEquals("Incorrect value", 0, s12.getCount());
   }
   
   /** test the equals(). */
   @Test public void equalsTest() {
      Quatrefoil s13 = new Quatrefoil("Small Example", 3.5);
      Quatrefoil s14 = new Quatrefoil("Small Example", 3.5);
      Assert.assertEquals("Error", true, s13.equals(s14));
      s14 = new Quatrefoil("Medium Example", 3.5);
      Assert.assertEquals("Error", false, s13.equals(s14));
      s14 = new Quatrefoil("Small Example", 38.44);
      Assert.assertEquals("Error", false, s13.equals(s14));
      Assert.assertEquals("Error", false, s13.equals("obj"));
   }
   
   /** test the hashCode(). */
   @Test public void hashCodeTest() {
      Quatrefoil s15 = new Quatrefoil("Small Example", 3.5);
      Assert.assertEquals("Diameter doesn't match", 0, s15.hashCode());
   }
   
   /** first test of compareTo(). */
   @Test public void compareToTest1() {
      Quatrefoil q1 = new Quatrefoil("Small Example", 3.5);
      Quatrefoil q2 = new Quatrefoil("Small Example", 3.5);
     
      Assert.assertTrue(q1.compareTo(q2) == 0);
   }
   
     /** second test of compareTo(). */
   @Test public void compareToTest2() {
      Quatrefoil q1 = new Quatrefoil("Small Example", 3.5);
      Quatrefoil q2 = new Quatrefoil("Medium Example", 38.44);
     
      Assert.assertTrue(q1.compareTo(q2) < 0);
   }
     /** third test of compareTo(). */
   @Test public void compareToTest3() {
      Quatrefoil q1 = new Quatrefoil("Medium Example", 38.44);
      Quatrefoil q2 = new Quatrefoil("Small Example", 3.5);
     
      Assert.assertTrue(q1.compareTo(q2) > 0);
   }
}
