package algo.interviews;

//Input:
//output:

public class GInterview {
		 public static void main(String[] args) {
				
		 int a=27;
		 int b=10;
		  System.out.println( "Remainder: " + a % b );
		  System.out.println( "carryOver: "+ ((int)(a/b)));
	 }
}

//	Input: [1,2,3] [4,5] 
//			Output: [1,6,8]
//
//			 int[]  getSum(input1, input2 )
//			{
//			 int[] result;
//				 //base case
//				 if( input1.length ==0 )
//				result= input2;
//				if (input2. length ==0
//				result= input1
//			 // valid case
//
//			if (input1.length>0 && input2.length>0)
//			{
//				// get maximum length of array
//				int  maxlength = maxLengthArray(input1, input2)
//				result = int[maxlength];
//			 	int k = maxlength
//			int i=input1.length-1, 
//			int j=input2.length=1;
//			int carryOver=0;
//				int sum= 0;
//			While( i>=0 || j>=0)
//			{
//			sum= input1[i]+input2[j] + carryOver;
//			result[k]= sum % 10; 
//			carryOver = int(sum/10);
//
//			      i--;
//				j--;
//				k--;
//				}
//				
//			 while(i>=0 && j<0){
//				 
//				sum= carryOver+ 0+input1[i];
//				result[k] = sum%10;
//				i--;
//				k--;
//				
//			}
//			while(j>=0  && i<0){
//
//				result[k]= carryOver+0+input[j];}
//				j--;
//				k--;
//				carryOver=0;
//			}
//			If (carryOver> 0)
//			{
//				
//			}
		//	 return result;
			//}



