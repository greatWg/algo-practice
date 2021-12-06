package algo.interviews;

import java.util.HashMap;

public class AzIsArrayHasCompliments {
	
	
//	function foo(items) {
//		  var i;
//		  for (i = 0; i < items.length; i++) {
//		    alert("Welcome To HireOn " + items[i]);
//		  }
//		}
//
//		 input : collection of number
//		 
//		 Return : true if any two numbers addition = 0   E.g. 1 -1
		 
		   // if in Array there is compliment of number then return true
		   // input : {0, 1}
		   //
		   
		   
		  boolean FindAdditionZero( int[] input){
		        int current;
		        HashMap<Integer, Integer> lookup= new HashMap<Integer, Integer>();
		       if (input != null) // base case 
		       {
		           return false;
		       }
		       // input size =1
		       if (input.length==1){
		           return false;
		       }
		       //input 
		        for (int i=0; i< input.length; i++){
		               current = input[i]; 
//		                if (lookup.contains(getCompliment(current)){
//		                    return true;
//		                }
//		                lookup.add ( current,0);
//		                // for (int j= i+1; j<input.length;j++){
		                //      if ( input[i]+input[j]==0)
		                //      {
		                //          return true;
		                //      }
		                // }
		        }
		    
		        return false;
		  }
		  
		 //
		 public int GetComliment(int number){
		     return (0-number); 
		     
		 }
		 
}
