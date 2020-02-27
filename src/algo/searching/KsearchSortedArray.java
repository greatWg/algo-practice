package algo.searching;

import java.sql.Array;

public class KsearchSortedArray {
	
	
	
	public int KthElement(int[] input, int k){
		
			int middle= input.length/2;
			int start= 0;
			int end= input.length -1;
			int [] temp;
				
			if (k==input[middle]){
				//middle=middle+1;
				return middle+1;
			}
			if (middle!=end){
				
				if(k>=input[middle+1] && k<=input[end] ){
					if(k==input[middle+1]){
						return middle+2;
					}
					if(k==input[end]){
						return end+1;
					}
					temp= new int[end-middle];
					for(int j=0; j<temp.length;j++){
						temp[j]= input[middle+j+1];
					}
					middle++;
					middle+=KthElement(temp, k);
						
				}
				
				else {
					temp= new int[middle];
					for(int j=0; j<temp.length;j++){
						temp[j]= input[start+j];
					}
					middle--;
					middle=KthElement(temp, k);
				}
			}
			else {
				if(k==input[start]){
					return start+1;
				}
				else if(k==input[end]){
					return end;
				}else {
					return -1;
				}
			}
			return middle;
	}	
	 /**Write a function to find an integer (k) in a sorted array of integers. 
	  * The starting point of the sorted array is not in position 0 thought. 
	  * ItÕs somewhere in the middle of the array. Example  {17, 19, 21, 4, 8, 10, 11} 
	  * @param args
	  */
	public static void main(String args[]){
		
		 int[] input=  { 21, 23, 25,27,29,  4, 8, 10, 11, 13, 15 ,17, 19};
		 KsearchSortedArray k= new KsearchSortedArray();

		 for( int i=0;i<input.length;i++){
			 System.out.println("element at position "+input[i] + " :"+k.searchValue(input, input[i]));
		 }
		 
	}
	
	/***
	 * searchValue(input , k)
	 * @param arr={17, 19, 21, 4, 8, 10, 11} 
	 * @param k = 10
	 * @return index of value k
	 */
	//search value k in sorted array
	private int searchValue(int [] arr, int k){
		//Find correct pivot
		int pivot = findPivot(arr, 0, arr.length-1);
		if(pivot==-1){
			return search(arr, 0, arr.length-1, k);
		}
		//if pivot is search value k
		if(arr[pivot]==k){
			return pivot;
		}
		// if first half array to the pivot is less than or equal to search value 
		// then search in the first half of the array
		if(arr[pivot]<=k){
			return search(arr, 0, pivot-1, k);
		}
		// Search in the second half of the array
		else{
			return search(arr, pivot+1,arr.length-1, k );
		}
	}
	//Find pivot in the array
	private int findPivot(int [] arr, int start, int end){
		if(end<start){
			return -1;
		}	
		//find mid index of array
		int mid = (start +end)/2;
		if(mid<end && arr[mid]>arr[mid+1]){
			return mid;
		}
		//if first value is greater and equal to mid value find pivot recursively in first half of array 
		//else  search pivot recursively in second half of array
		if(arr[start]>=arr[mid]){
			return findPivot(arr, start, mid-1);
		}else{
			return findPivot(arr, mid+1, end);
		}
	}
	//Search the value in array
	private int search(int []arr, int start, int end, int k){
		if(end<start){
			return -1;
		}
		int mid = (start+end)/2;
		//if mid value is search value
		if(k==arr[mid]){
			return mid; 
		}
		//if search value is greater than mid value- then search in first half of array 
		//else search in the second half of the array
		if(k>arr[mid]){
			return search(arr, mid+1, end, k);
	
		}else{
			return search(arr, start, mid-1, k);
		}
	}
}
