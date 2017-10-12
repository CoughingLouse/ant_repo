package antsrl.guerra;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public void testCarro()
    {
      	CarroArmato c = new CarroArmato();
     	CarroArmato c2 = new CarroArmato();
   
     	c.muovi(2, 1);
    	assertTrue(c.x==2 && c.y==1);
   
      	assertTrue(c.raggiunge(c2));
      	assertFalse(c2.raggiunge(c));
      	
    }
    
    
}
