package edu.qc.seclass;

import org.junit.*;


import static org.junit.Assert.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    //testing the testcount method
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }
    //tests to check whether the method throws NullPointerException
    @Test (expected = NullPointerException.class )
    public void testCountNumbers2() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }
    // Should return 0 for empty string
    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //checks if a number with a space is treated as one number or two numbers, should be two numbers
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("The numbers 1 2 are not same");
        assertEquals(2, mycustomstring.countNumbers());
    }

    //tests to see if 645 is a separate number from 456 and 32 and 1
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("check if 645 456 32 1");
        assertEquals(4, mycustomstring.countNumbers());
    }
     
    //When there's no number in the string.
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("hello there are no numbers !");
        assertEquals(0, mycustomstring.countNumbers());
    }
     
	// this test shows that the method does not over count
    @Test
    public void testCountNumbers7() {
    
    	mycustomstring.setString("80");
        assertEquals(1, mycustomstring.countNumbers());
    }
    
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    //tests the illegalargumentexception
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("Let's test this exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }
    //tests the NullPointerexception
    @Test (expected = NullPointerException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    //simple test to compare the results of this test to the next one
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }
    //simple test that starting from end usually nets the same result as starting from beginning but isn't always true
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }
    //test that proves starting from end and beginning of the string can net two different outcomes
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("random l3t3rz  ar3 not tooo hard too wri!te");
        assertEquals("nm3r 3otoa ort", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("random l3t3rz  ar3 not tooo hard too wri!te");
        assertEquals("aol3 rn ohdow!", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    //test to print out the entire string by iteration
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("Print me out completley");
        assertEquals("Print me out completley", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    //test to print out the iteration by starting from the end and reordering
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("Print out this statement");
        assertEquals("Print out this statement", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    //tests the exception once more where n = -1
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("Let's test this exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);
    }

    //to make sure that the outcome is empty if n is bigger than the string length
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("helloRandom");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(12, true));
    }

    //prints out only spaces
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("         ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	//Test case to see what the output of the method would be with n=1 if we are starting from the end
    	mycustomstring.setString("ONE OF MY BEST TEST CASE!");
        assertEquals("ONE OF MY BEST TEST CASE!",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1,true));
    }

    //test case for converting digits to string
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    //tests the illegalArgumentException by making startingpoint > endingpoint
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("Another random test ");
        mycustomstring.convertDigitsToNamesInSubstring(12,9);
    }
    //tests if index out of bounds exception for starting point
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("random test again! ");
        mycustomstring.convertDigitsToNamesInSubstring(0,90);
    }

    //tests if index out of bounds exception for Ending point
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("fourth test is random ");
        mycustomstring.convertDigitsToNamesInSubstring(1,mycustomstring.getString().length() + 1);
    }

    //tests Nullpointer exception by making both starting and endpoints 0
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }
    //Tests to make sure a space would work
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1,1);
    }
    @Test
    public void testConvertDigitsToNamesInSubstring7() { 
    	mycustomstring.setString("00101100");
    	mycustomstring.convertDigitsToNamesInSubstring(1, 8);
    	assertEquals("ZeroZeroOneZeroOneOneZeroZero", mycustomstring.getString()); }


    //tests the method with special keys
    @Test
    
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("J@v@ 1 0");
        mycustomstring.convertDigitsToNamesInSubstring(1, 8);
        assertEquals("J@v@ One Zero", mycustomstring.getString());
    }

    
    @Test
    public void testConvertDigitsToNamesInSubstring9() {
    	//Test to see if it converts the numbers in the string from position 2 to position 11
    	mycustomstring.setString("H3ll0 W0r1d"); 
        mycustomstring.convertDigitsToNamesInSubstring(2, 11);
        assertEquals("HThreellZero WZerorOned", mycustomstring.getString());
    }
}