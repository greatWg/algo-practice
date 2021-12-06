package com.Interview;

public class ManipulateString {
	//Amazon shared screen interview SDET position in Digital and Mobile Products team  at Boston, MA
	// aaaBBccccddddd-> 3a2B4c5d
	//  Distributed divide and conquer 0-7 7-13 --merge (3a 2b 2c  , 2c  5d) = 3a 2b 4c 5d
	// null
	// ab
	//aaaBBcc
	//aaaaaaaaaabbbbbbbbb

	public String specificString(String input){
	  char Previous;
	  int count=0;
	  StringBuilder sb= new StringBuilder();
	   if( input!= null)
	   {
	       int i=0;
	       Previous = input.charAt(i); //a/
	       count=0; //1
	       while ( i<input.length() )
	       {
    		  while (input.charAt(i) == Previous)// b==a
 	          { 
 	             count++;
 	             i++;
 	             if (i==input.length()) break;
 	          }
 	          sb.append( count); 
 	          sb.append(input.charAt(i-1)); 
 	          
 	          // Reset previous and count
 	          if (i<input.length())
 	          {
 	        	  Previous = input.charAt(i); 
 	        	  count=0;
	 	      }
	       }
	   }
	   return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManipulateString ms= new ManipulateString();
		String s0= "a";
		String s1= "ab";
		String s2= "aaaBBcc";
		String s3 = "aaaBBccccddddd";
		
		System.out.println(s0+ " manipulated to " +ms.specificString(s0));	
		System.out.println(s1+ " manipulated to " +ms.specificString(s1));
		System.out.println(s2+ " manipulated to " +ms.specificString(s2));
		System.out.println(s3+ " manipulated to " +ms.specificString(s3));
	}
}
