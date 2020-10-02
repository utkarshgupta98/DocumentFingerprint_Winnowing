
package in.jwinnow;

import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Test case for {@link Fingerprint}.
 * @author Utkarsh Gupta
 */
public class FingerprintCustomTest {

    private String token = null;
    private String text = null;
    private String textWithWhiteSpace = null;

    public FingerprintCustomTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        token = "A do run run run, a do run run";
        text = "This test is used for testing more than"+
                "one sentence in a given text. This helps us"+
                "to see whether this test is working or not";
        textWithWhiteSpace = "This    text\tshould \tbe\ndisp layed \t\twith \n out \n\rspaces\n\n!";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHash method, of class Fingerprint.
     */
    @Test
    public void testGetHash() {
        System.out.println("Testing getHash() ...");
        Fingerprint instance = new Fingerprint();
        int expResult = 5402;
        int result = instance.getHash(token);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of winnowUsingWords method, of class Fingerprint.
     */
    @Test
    public void testWinnowUsingWords() {
        System.out.println("Testing winnowUsingWords() ...");
        Fingerprint instance = new Fingerprint();
        String expResult = "[442, 727, 1276, 1539, 4552, 5220]";
        String result = instance.winnowUsingWords(text).toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of winnowUsingCharacters method, of class Fingerprint.
     */
    @Test
    public void testWinnowUsingCharacters() {
        System.out.println("Testing winnowUsingCharacters() ...");
        Fingerprint instance = new Fingerprint();
        String expResult = "[17, 167, 285, 305, 325," +
                           " 368, 553, 609, 683, 1095," +
                           " 1167, 1219, 1431, 1456," +
                           " 1499, 1535, 1645, 2102, 2137," +
                           " 2219, 2313, 2420, 2779, 3005, 3266, 3854]";
        String result = instance.winnowUsingCharacters(text).toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeWhiteSpaceAndMakeLowercase method, of class Fingerprint.
     */
    @Test
    public void testRemoveWhiteSpaceAndMakeLowercase() {
        System.out.println("Testing removeWhiteSpaceAndMakeLowercase() ...");
        Fingerprint instance = new Fingerprint();
        String expResult = "thistextshouldbedisplayedwithoutspaces!";
        String result = instance.removeWhiteSpaceAndMakeLowercase(textWithWhiteSpace);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getParams method, of class Fingerprint.
     */
    @Test
    public void testGetParams() {
        System.out.println("Testing getParams() ...");
        Fingerprint instance = new Fingerprint(15, 5);
        HashMap expResult = new HashMap();
        expResult.put("minDetectedLength", 15);
        expResult.put("windowSize", 15 - 5 + 1);
        HashMap result = instance.getParams();
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
