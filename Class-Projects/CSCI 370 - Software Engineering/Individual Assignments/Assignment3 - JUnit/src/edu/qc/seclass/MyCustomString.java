package edu.qc.seclass;

import java.util.HashMap;

public class MyCustomString  implements MyCustomStringInterface {
      private String str;
	
	@Override
	   /**
     * Returns the current string. If the string is null, it should return null.
     *
     * @return Current string
     */
    public String getString(){ 
        
        if(this.str.isEmpty() || this.str ==null){
            return null;
        }

        else{
            return this.str ;
        }
	}
    

	@Override
	/**
     * Sets the value of the current string.
     *
     * @param string The value to be set
     */

	   public void setString(String String){
		
           this.str = String;
    }


	@Override
	  /**
     * Returns the number of numbers in the current string, where a number is defined as a
     * contiguous sequence of digits.
     *
     * If the current string is empty, the method should return 0.
     *
     * Examples:
     * - countNumbers would return 2 for string "My numbers are 11 and 96".
     *
     * @return Number of numbers in the current string
     * @throws NullPointerException If the current string is null
     */
	public int countNumbers() throws NullPointerException {
		// TODO Auto-generated method stub
		
		
		if (this.str==null) {
			throw new NullPointerException("String is null");
		}
		int numberCount =0;
		char c;
		boolean prev = false;
		
		int i = 0;
		while(i<str.length()) {		
			c=str.charAt(i);
			 if(Character.isDigit(c)) {
				 if(prev==false) {
					numberCount++;
					prev = true;
				 }
			 }
			 else {
				if (prev==true) { 
				 prev=false;
				}
			 }
			 i++;
		}
		 return numberCount;

		}

	@Override
	 
	/**
     * Returns a string that consists of all and only the characters in positions n, 2n, 3n, and
     * so on in the current string, starting either from the beginning or from the end of the
     * string. The characters in the resulting string should be in the same order and with the
     * same case as in the current string.
     *
     * If the current string is empty or has less than n characters, the method should return an
     * empty string.
     *
     * Examples:
     * - For n=2 and a string of one character, the method would return an empty string.
     * - For n=2 and startFromEnd=false, the method would return the 2nd, 4th, 6th, and so on
     *   characters in the string.
     * - For n=3 and startFromEnd=true, the method would return the 3rd from the last character
     *   in the string, 6th from the last character in the string, and so on (in the order in
     *   which they appear in the string).
     *
     * Values n and startFromEnd are passed as parameters. The starting character, whether it is
     * the first one or the last one in the string, is considered to be in Position 1.
     *
     * @param n Determines the positions of the characters to be returned
     * @param startFromEnd Determines whether to start counting from the end or from the
     *                     beginning when identifying the characters in position n, 2n, 3n, and so
     *                     on. Please note that the characters are always returned in the order in
     *                     which they appear in the string.
     * @return String made of characters at positions n, 2n, and so on in the current string
     * @throws IllegalArgumentException If "n" less than or equal to zero
     * @throws NullPointerException If the current string is null and "n" is greater than zero
     *
     */
	
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) throws NullPointerException, IllegalArgumentException {

        
		StringBuilder sb = new StringBuilder();
        int stringLength = this.str.length() - n;
        int len = this.str.length();

        if(n <= 0){
            throw new IllegalArgumentException("Bad argument for n");
        }

         if(this.str == null && n > 0){
            throw new NullPointerException("String is null");
        }

         else {
            if (n > len ) {
                return "";
            } else {
                if (startFromEnd == true) {
                	int i = stringLength; 
                    while (i >= 0) {
                    	char c = str.charAt(i);
                        sb.insert(0,c);
                        i -= n;
                    }
                    return sb.toString();
                } else {
                	int i = n - 1; 
                    while (i < stringLength + n) {
                    	char c = str.charAt(i);
                        sb.append(c);
                        i = i+ n;
                    }
                    return sb.toString();
                }
            }
        }
    }
	
	
	 
	@Override
	/**
     * Replace the individual digits in the current string, between startPosition and endPosition
     * (included), with the corresponding English names of those digits, with the first letter
     * capitalized. The first character in the string is considered to be in Position 1.
     * Unlike for the previous method, digits are converted individually, even if contiguous.
     *
     * Examples:
     * - String 460 would be converted to FourSixZero
     * - String 416 would be converted to FourOneSix
     *
     * @param startPosition Position of the first character to consider
     * @param endPosition   Position of the last character to consider
     * @throws IllegalArgumentException    If "startPosition" > "endPosition"
     * @throws MyIndexOutOfBoundsException If "startPosition" <= "endPosition", but either
     *                                     "startPosition" or "endPosition" are out of
     *                                     bounds (i.e., either less than 1 or greater than the
     *                                     length of the string)
     * @throws NullPointerException        If "startPosition" <= "endPosition", "startPosition" and
     *                                     "endPosition" are greater than 0, and the current
     *                                     string is null
     */
	
		
	 public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws IllegalArgumentException, NullPointerException, MyIndexOutOfBoundsException{
		
		
		
		HashMap<Character, String>	numToString = new HashMap<Character, String>();
		
		numToString.put('0', "Zero");
        numToString.put('1', "One");
        numToString.put('2', "Two");
        numToString.put('3', "Three");
        numToString.put('4', "Four");
        numToString.put('5', "Five");
        numToString.put('6', "Six");
        numToString.put('7', "Seven");
        numToString.put('8', "Eight");
        numToString.put('9', "Nine");
		
		
        if(startPosition > endPosition){
            throw new IllegalArgumentException("Bad argument");
        }

        else if((startPosition <= endPosition) && ((startPosition < 1 || endPosition > this.str.length()))){
            throw new MyIndexOutOfBoundsException();

        }
        
        else if((startPosition <= endPosition) && ((startPosition > 0 && endPosition > 0 && this.str == null))){
            throw new NullPointerException();
        }

        else{

        StringBuffer sb = new StringBuffer();
        sb.append(this.str.substring(0,startPosition-1));
        int i = startPosition-1;
        while( i < endPosition ){
            char x = this.str.charAt(i);
            if(Character.isDigit(x))
                sb.append(numToString.get(x));
            else {
                sb.append(x);
            }
         i++;
        }

        sb.append(this.str.substring(endPosition, this.str.length()));

        this.str =  sb.toString();
    }
  }
}


