package algo.recursion;

import java.util.ArrayList;
import java.util.LinkedList;

public class KSizeSubsetNset {

// private LinkedList<Integer> prevList= new LinkedList<Integer>();
// private LinkedList<Integer> nextList= new LinkedList<Integer>(); 
// private LinkedList<LinkedList<Integer>> setList= new  LinkedList<LinkedList<Integer>>();
// 
	private String[] set;//=new String[]{"1","2","3","4","5"};
	private int k=2;
	private int n=0;
 public void Subsets( String [] set , int n ,int k){
	 
		 // overall logic  create K loops for k size of array---....light-- repetition --Recursive
	/*************** Most important to understand*******
	 //for k=1
		 if(k==1){
			 for(int i=0; i<n; i++){
				  System.out.println( set[i]);
			 } 
		 }
		 else if( k==2){
		 //for k=2 only 
			 for(int i=0; i<n; i++){
				  for(int j=i+1; j<n;j++){
					  System.out.println( set[i] +" "+set[j]);
				  }
			  }
		 }
		*******************************/
		 buildSubsets(0,0,"");
		 
	}
 
	private void buildSubsets(int i, int j ,String subset) {
		
	if(j==k){
		System.out.print(subset+ " ");
		return;
	}
	int b=i;
	for(;b<n;b++){
		System.out.println("before call: i and j="+ i + " "+j+ "  "+subset);
		
		buildSubsets(b+1, j+1,subset+set[b]);
		System.out.println(" after call i+1 and J+1: " + (b+1)+ " "+ (j+1) + "  "+subset+set[b]);
	}
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KSizeSubsetNset kSet = new KSizeSubsetNset();
		kSet.set= new String[]{"A","B","C","D","E"};
		kSet.n=kSet.set.length;
		kSet.k=3;
		kSet.Subsets( kSet.set, kSet.n,kSet.n);
		
	}

}
