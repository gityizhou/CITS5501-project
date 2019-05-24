import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TravelStopTest {

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    TravelStop tsTest1 = new TravelStop(33.3, 22.2, "mystreet", "mysuburb");

  }

  @Test(expected = IllegalArgumentException)
  public void testNotExistSuburbStreet() {
    TravelStop tsTest2 = new TravelStop(33.3, 22.2, "nostreet", "nosuburb");
  }

  /**
   * Test method for {@link TravelStop#getLatitude()}.
   */
  @Test
  public void testGetLatitude() {
    double result = tsTest1.getLatitude();
    double expected = 33.3;
    assertEquals(expected,result);

  }

  /**
   * Test method for {@link TravelStop#getLongitude()}.
   */
  @Test
  public void testGetLongitude() {
    double result = tsTest1.getLongitude();
    double expected = 22.2;
    assertEquals(expected,result);
  }

  /**
   * Test method for {@link TravelStop#getStreet()}.
   */
  @Test
  public void testGetStreet() {
    String result = tsTest1.getStreet();
    String expected = "mystreet";
    assertEquals(expected,result);
  }

  /**
   * Test method for {@link TravelStop#getSuburb()}.
   */
  @Test
  public void testGetSuburb() {
    String result = tsTest1.getSuburb();
    String expected = "mysuburb";
    assertEquals(expected,result);
  }

}
