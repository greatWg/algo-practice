package algo.sorting;

public class Sort {
 //input = { 9,8 ,7,6,5,4,3,2,1}
	
	/**
	 * Insertion Sort : <x----x--->x
	 * Best		: n
	 * Average	:n^2
	 * Worst	:n^2
	 */
	 public int[]  insertionSort(int[] input){
		int i , j , newValue;
		for ( i=1; i< input.length; i++){
			 newValue= input[i];
			 j=i;
			 System.out.println("newValue:"+ newValue);
			 //Move all elements j-1 in sequence if they are greater than newValue=j
			 while ( j > 0 && input[j-1] > newValue){ //9 > 8  , 8,9 > 7
				 input[j] = input[j-1]; // 1-9 , 2-9, 1-8
				 j--;
			 } 
			 input[j]=newValue; //0 =8, 0=7
		}
		return input;
	 }
	 
	 /**
	  * Selection sort - Find first minimum, store - second minimum - store
	  * Best	:n^2
	  * Average	:n^2
	  * Worst	:n^2 
	  */
	 public int[] selectionSort(int[] input){
		int i , j , minIndex, temp;
		for( i=0; i<input.length-1 ;i++){
			//Initiate minIndex
			minIndex= i;
			//Search correct minIndex
			for(j=i+1;j<input.length;j++){
				if(input[j] < input[minIndex])
					minIndex = j;
			}
			//Swap if initiated minIndex is not same as search index
			if(minIndex!=i){
				//swap
				temp=input[minIndex];
				input[minIndex]= input[i];
				input[i]=temp;
			}
		}
		return input;
	 }
	 
	 /**
	  * Bubble Sort - Compare neighbor at time up to the member reach at correct location
	  * Best	: n
	  * Average	: n^2
	  * Worst	: n^2 
	  */
	 public int[] bubbleSort(int[] input){
		boolean swapped= true;
		int i , j, temp;
		j=0;
		while (swapped){
			swapped= false;
			j++;
			for( i=0; i<input.length-j ;i++){
				if ( input[i]> input[i+1]){
					temp=input[i+1];
					input[i+1]= input[i];
					input[i]=temp;
					swapped= true;
				}
			}
		}
		return input;
	 }
	 /**
	  * Quick Sort:[Divide and conquer] Find pivot and then partition [Recursive]
	  *  Best	: nlogn
	  *  Average: Nlogn 
	  *  Worst	: n^2 (worst choice of pivot)
	  * 
	  */
	
	public int[] quickSort(int[] input, int left, int right){
		int index = partition(input, left, right);
		if(left<index-1 )
			quickSort(input, left, index-1);
		if(index< right)
			quickSort(input, index, right);
		return input;
	}
	//Partition: left<<p<<right
	private int partition(int[] input, int left, int right){
		int i=left,j=right;
		int temp;
		int pivot=input[(left+right)/2];
		while(i<=j)
		{
			while(input[i]<pivot){
				i++;
			}
			while (input[j]>pivot){
				j--;
			}
			//if(i<=j){
				//swap
				temp=input[i];
				input[i]= input[j];
				input[j]=temp;
				//While loop break by incrementing the i and j pointer
				i++;
				j--;
			//}
		}
		return i;
	}
	
	/**
	 * Merge Sort: Divide and conquer : Divide array in two parts and sort  recursively   
	 * Best		: Nlogn
	 * Average	: Nlogn
	 * Worst	: Nlogn
	 */
	 
	private int[] mergeSort ( int[] input, int low, int high){
		if(low<high){
			int middle= (low+high)/2;
			mergeSort(input, low, middle);
			mergeSort(input, middle+1, high);
			merge(input, low, middle, high);
		}
		return input;
	}
	
	private void merge(int[] input, int low, int middle, int high){
		int[] helper= new int[input.length];

		for(int i=low;i<=high;i++){
			helper[i]=input[i];
		}
		
		//Two list have i and j start pointer
		
		int i=low, 
			j=middle+1,
			k=low;
		//Copy all elements of list 1 and list 2 in sorted order. Some of the list elements may left 
		//as they greater than last element of list 2.
		while (i<=middle && j<=high){
			if (helper[i]<= helper[j]){
				input[k]=helper[i];
				i++;
			}
			else{
				input[k]=helper[j];
				j++;
			}
			k++;
		}
		
		//copy the rest of the left side of the array into target array
		while(i<=middle){
			input[k]=helper[i];
			i++;
			k++;
		}
		
	}
	
	public void printResults(int[] result, String AlgorithmName) {

		 System.out.println( " ");
		 System.out.println( "***************");
		 System.out.println( "Algorithm:  " + AlgorithmName);
		 for (int i=0; i< result.length; i++){
			 System.out.print(result[i]);
		 }
		 System.out.println( " ");		 
		 System.out.println( "***************");
	}
	 /**
	  * Main Method
	  * @param args
	  */
	public static void main (String[] args){
		 int[] input= { 9,8 ,7,6,5,4,3,2,1};
		 
		 Sort s= new Sort();
		 int[] result;
		 result= s.insertionSort(input);
		 s.printResults(result, "InsertionSort");
		
		 result= s.selectionSort(input);
	     s.printResults(result, "SelectioSort");
	 
		 result= s.bubbleSort(input);
		 s.printResults(result, "BubbleSort");
		 
		 result= s.quickSort(input, 0, input.length-1);
		 s.printResults(result, "quicksort");
		 
		 result= s.mergeSort(input, 0, input.length-1);
		 s.printResults(result, "Merge Sort");
		 
	}
}
