import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SelectorTest {

   @Before
   public void setUp() {
   }

   @Test
   public void kthMaxTest2() {
      int[] a = {3, 7, 3, 3, 1, 9, 1, 1, 1, 5};
      int k = 5;
      int expected = 1;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }
}