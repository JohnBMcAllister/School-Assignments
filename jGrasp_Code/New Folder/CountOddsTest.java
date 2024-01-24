import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CountOddsTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      int[] values = {1,2,3,4,5};
      int expected = 3;
      int actual = CountOdds.countOdds(values);
      Assert.assertEquals(expected, actual);
   }
}
