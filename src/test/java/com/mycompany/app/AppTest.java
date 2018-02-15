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
    public void testIsFirstArrayNull() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        assertFalse(new App().arrayOperation(null,'+',array1,array2));
    }
    public void testIsSecondArrayNull() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        assertFalse(new App().arrayOperation(array1,'+',null,array2));
    }
    public void testIsResultArrayNull() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        assertFalse(new App().arrayOperation(array2,'+',array1,null));
    }
    public void testIsFirstArrayEmpty(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        assertFalse(new App().arrayOperation(array2,'+',array1,array1));
    }
    public void testIsSecondArrayEmpty(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        assertFalse(new App().arrayOperation(array1,'+',array2,array1));
    }
    public void testIsResultArrayEmpty(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        assertFalse(new App().arrayOperation(array1,'+',array1,array2));
    }
    public void testAreFirstandSecondEqualinLenght(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(3,4,5));
        assertFalse(new App().arrayOperation(array1,'+',array2,array3));
    }
    public void testAreFirstandResultEqualinLenght(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,3,5));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(3,4,5));
        assertFalse(new App().arrayOperation(array1,'+',array2,array3));
    }
    public void testIsCharOperator(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().arrayOperation(array1,',',array1,array1));
    }
    public void testCannotDivideByZero(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,2,5,1));
        assertFalse(new App().arrayOperation(array1,'/',array2,array3));
    }
    public void testIncorrectAdditionResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(2,1,5,1));
        assertFalse(new App().arrayOperation(array1,'+',array2,array3));
    }
    public void testIncorrectSubtractionResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(0,0,2,1));
        assertFalse(new App().arrayOperation(array1,'-',array2,array3));
    }
    public void testIncorrectMultiplicationResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,4,0,2));
        assertFalse(new App().arrayOperation(array1,'*',array2,array3));
    }
    public void testIncorrectDivisionResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,1,8,1));
        assertFalse(new App().arrayOperation(array1,'/',array2,array3));
    }
    public void testCorrectAdditionResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(2,4,3,8));
        assertTrue(new App().arrayOperation(array1,'+',array2,array3));
    }
    public void testCorrectSubtractionResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(3, 5, 7, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(2,3,7,0));
        assertTrue(new App().arrayOperation(array1,'-',array2,array3));
    }
    public void testCorrectMultiplicationResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,0,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,4,0,16));
        assertTrue(new App().arrayOperation(array1,'*',array2,array3));
    }
    public void testCorrectDivisionResult(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(2,2,2,2));
        assertTrue(new App().arrayOperation(array1,'/',array2,array3));
    }


}
