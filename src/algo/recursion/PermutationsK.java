package algo.recursion;

public class PermutationsK {

	    public static void choose(char[] a, int R) { enumerate(a, a.length, R); }

	    private static void enumerate(char[] a, int n, int r) {
	    	//System.out.println("Start");
	        if (r == 0) {
	            for (int i = n; i < a.length; i++)
	                System.out.print(a[i]);
	            System.out.println();
	            return;
	        }
	        for (int i = 0; i < n; i++) {
	        	//System.out.println("enumrate "+i +" n-1= "+(n-1)+" j-1 ="+(r-1));
	        	swap(a, i, n-1);
	            enumerate(a, n-1, r-1);
	            swap(a, i, n-1);
	         }
	    }  

	    // helper function that swaps a[i] and a[j]
	    public static void swap(char[] a, int i, int j) {
	    	//System.out.println("i= "+i+ "j= "+j);
	        char temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }

	    // sample client
	    public static void main(String[] args) {
	        int N = 5;//Integer.parseInt(args[0]);
	        int k = 3; //Integer.parseInt(args[1]);
	        //2String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String elements= "12345";

	        char[] a = new char[N];
	        for (int i = 0; i < N; i++)
	            a[i] = elements.charAt(i);
	        choose(a, k);
	    }
//
//	    41
//	    21
//	    31
//	    12
//	    42
//	    32
//	    13
//	    23
//	    43
//	    14
//	    24
//	    34
	    
//	    41
//	    21
//	    21
//	    34
//	    14
//	    14
//	    21
//	    31
//	    31
//	    41
//	    21
//	    21


}
