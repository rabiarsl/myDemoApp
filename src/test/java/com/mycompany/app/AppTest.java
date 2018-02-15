package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;


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
    public void isFirstArrayNull() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        assertFalse(new App().arrayOperation(null,'+',array1,array2);
    }
    public void isSecondArrayNull() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        assertFalse(new App().arrayOperation(array1,'+',null,array2);
    }
    public void isSecondArrayNull() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        assertFalse(new App().arrayOperation(array2,'+',array1,null);
    }

}
