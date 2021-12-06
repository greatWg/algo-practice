package algo.searching;

public class Searching {

/**
 * Linear search : Search simple like is it 5 yes then stop.
 * @param input =input array
 * @param searchValue = searching for key
 * @return key
 * 
 * Best : 1
 * Worst : n
 * Average:n/2
 * 
 */
	public int linearSearch(int[] input, int searchValue) {
		// TODO Auto-generated method stub
		
		for(int i=0; i< input.length-1; i++){
			if (input[i]==searchValue){
			 return i+1;
			}
		}
		return -1;//not found key-
	}
	
	/**
	 * Assumes as input array sorted
	 * Binary search: 
	 *
	 * Best : 1
	 * Average : logN
	 *
	 */
	
	public int binarySearch( int[] input, int searchValue ){
		int start = 0;
		int end= input.length;
		int mid= 0;
		while(start< end)
		{   
			mid =(start+end)/2;
			if(input[mid] == searchValue ){
				return mid;
			}else if(searchValue<input[mid]){
				end = mid;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}



	 /**
	  * Main Method
	  * @param args
	  */
	public static void main (String[] args){

		//int[] input= { 9,8 ,7,6,5,4,3,2,1};
		int[] inputBinarySearch={1,2,3,4,5,6,7,8,9};
		Searching s= new Searching();
		 
		// int[] result= s.insertionSort(input);
		// int[] result= s.selectionSort(input);
		//int[] result= s.bubbleSort(input); 
		//int[] result= s.quickSort(input, 0, input.length-1);
		//int[] result= s.mergeSort(input, 0, input.length-1);
		int i= s.linearSearch(inputBinarySearch, 5);
		//for (int i=0; i< result.length; i++){
			 System.out.print("Searched Value:"+ i);
		//}

		System.out.println( "Binary search for 7 :  "+ s.binarySearch(inputBinarySearch, 7));

		int[] array= {-1,0,3,5,9,12};
		System.out.println( "Binary search for 2 :  "+ s.binarySearch(array, 2));


	
	}

}
