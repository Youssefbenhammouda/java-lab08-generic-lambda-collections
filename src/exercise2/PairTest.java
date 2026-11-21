package exercise2;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PairTest {

  /**
   * Test for creating a Pair of Integers
   */
  @Test
  public void testPairIntegerInteger() {
    Pair<Integer,Integer> pair = new Pair<>(1, 2);

    // Check the object values are 1 and 2
    assertEquals(1, pair.getFirst());
    assertEquals(2, pair.getSecond());
  }

  /**
   * Test for creating a Pair of Doubles
   */
  @Test
  public void testPairDoubleDouble() {
    Pair<Double,Double> pair = new Pair<>(1.0, 2.0);

    // Check the object values are 1 and 2
    assertEquals(1.0, pair.getFirst(),1e-9);
    assertEquals(2.0, pair.getSecond(),1e-9);
  }

  /**
   * Test for creating a Pair of String/Integer
   */
  @Test
  public void testPairStringInteger() {

  }
  
  /**
   * Test for Pair of Integer toString()
   */


  @Test
  public void testPairIntegersToString() {
    Pair<Integer, Integer> pair = new Pair<>(1, 2);

    // Do NOT change this check. Fix your Pair to match this format.
    assertEquals("<1, 2>", pair.toString());
  }


  /**
   * Test for a composite parameterized Pair
   */


  @Test
  public void testPairHelperIntegerToString() {
    // Create a Pair with a parameterized type and check toString()
    Pair<Integer, Integer> sng = new Pair<>(5, 6);
    Pair<Pair<Integer, Integer>,Integer> pair = new Pair<>(sng, 10);

    // Do NOT change this check. Fix your Pair to match this format.
    assertEquals("<<5, 6>, 10>", pair.toString());
  }


}