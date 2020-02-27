package algo.Randomized;

import java.util.Hashtable;
//In person interview at Expedia
public class Randomized {
	
	private int[] a; 
	
	
	public int[] Randomized(int n){
		int count=0;
		Hashtable<Integer ,String> ht;
		a= new int[n+1];
		ht = new Hashtable<Integer, String>();
		while (count <n){
			int x= (int) Math.round(Math.random()*100);
			 //System.out.println(x);
			if (ht.containsKey(x)== false){
				ht.put(x, "Occured");
				System.out.print("Value: "+count+ "   "+x);
				a[x]=count;
				count++;
			}
		}
		printArray(a);
		return a;
	}

	public int [] RandomNums(int n){
		a= new int[n+1];
		for (int i=0; i<n; i++){
			a[i]=i+1;
		}
		for (int i=0; i<n; i++){
			int x= (int) Math.round(Math.random()*100);
			int temp= a[i];
			a[i]= a[x];
			a[x]= temp;
		}
		printArray(a);
	   
		return a;
	   
	}

	private void printArray(int[] a2) {
		for (int i= 0; i< a2.length; i++){
			System.out.println(i+ " "+ a2[i]+ "   ");
		}
	
	
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Randomized R = new Randomized();
		R.Randomized(100);
		R.RandomNums(100);

	}

}
