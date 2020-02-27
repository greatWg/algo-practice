package algoPS1;

import java.util.Enumeration;
import java.util.Hashtable;

public class DataStructure {

	private void hashTableExample(){
		Hashtable <Integer, String> ht =  new Hashtable<Integer, String>();
		ht.put(1, "Google"		);
		ht.put(3, "Microsoft"	);
		ht.put(2, "Facebook" 	);
		ht.put(6, "HP" 			);
		ht.put(5, "Twitter" 	);
		ht.put(4, "Expedia" 	);
		
		int size= ht.size();
		int key ;
		String value;
		
		Enumeration e= ht.keys();
		while (e.hasMoreElements()){
			key=(Integer) e.nextElement();
			value=ht.get(key);
			System.out.println(key +": "+value);
		}
	}
	public static void main (String[] args){
		
		//int[] inputBinarySearch={1,2,3,4,5,6,7,8,9};
		DataStructure ds= new  DataStructure();
		ds.hashTableExample();
	}
	
	
	
}
