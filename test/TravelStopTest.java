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
    //prefix value for testing get methods in this class
    TravelStop tsTest1 = new TravelStop(33.3, 22.2, "mystreet1", "mysuburb1");
  }
  /*
  There is no on-disk file in this project,
  so that I will use four values to simulate this situation,
  “mystreet” , “mysuburb” is in this on-disk file
  “nostreet”, “nosuburb” is not in this file.
   */

  //this test case tests the situation that if the street and suburb value not exist in the on-disk file
  @Test(expected = IllegalArgumentException)
  public void testNotExistStreet() {
    TravelStop tsTest2 = new TravelStop(44.4, 55.5, "nostreet", "mysuburb");
  }

  //this test case tests the situation that when latitude is larger than 92
  @Test(expected = IllegalArgumentException)
  public void testLatitudeOverValue() {
    TravelStop tsTest2 = new TravelStop(92, 55.5, "mystreet", "mysuburb");
  }

  //this method test if getLatitude method can get right value of latitude
  @Test
  public void testGetLatitude() {
    double result = tsTest1.getLatitude();
    double expected = 33.3;
    assertEquals(expected,result);

  }

  //this method test if getLongitude method can get right value of longtitude
  @Test
  public void testGetLongitude() {
    double result = tsTest1.getLongitude();
    double expected = 22.2;
    assertEquals(expected,result);
  }

  //this method test if getStreet method can get right value of street
  @Test
  public void testGetStreet() {
    String result = tsTest1.getStreet();
    String expected = "mystreet";
    assertEquals(expected,result);
  }

}
