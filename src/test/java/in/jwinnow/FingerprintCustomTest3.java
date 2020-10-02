
package in.jwinnow;

import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Test case for {@link Fingerprint}.
 * @author Utkarsh Gupta
 */
public class FingerprintCustomTest3 {

    private String token = null;
    private String text = null;
    private String textWithWhiteSpace = null;

    public FingerprintCustomTest3() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        token = "wAs It a caT tHAt i SaW";
        text = "trying with different window size this time";//this test will have different window size
        textWithWhiteSpace = "This    text\fshould \fbe\ndisp layed \f\fin \n  \n\rUppEr\n\nCase!";//lets test with upper case
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
        int expResult = 4288;
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
        String expResult = "[]";
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
        String expResult = "[45, 105, 243, 497, 917, 1344, 1521, 1668, 2034, 3949]";
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
        String expResult = "THISTEXTSHOULDBEDISPLAYEDINUPPERCASE!";
        String result = instance.removeWhiteSpaceAndMakeUppercase(textWithWhiteSpace);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getParams method, of class Fingerprint.
     */
    @Test
    public void testGetParams() {
        System.out.println("Testing getParams() ...");
        Fingerprint instance = new Fingerprint(10, 5);
        HashMap expResult = new HashMap();
        expResult.put("minDetectedLength", 10);
        expResult.put("windowSize", 10 - 5 + 1);
        HashMap result = instance.getParams();
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
