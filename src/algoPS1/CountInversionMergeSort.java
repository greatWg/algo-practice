package algoPS1;

import java.io.BufferedWriter;
import java.io.Writer;

import com.util.inputFileTest;

public class CountInversionMergeSort {
	
	private static long count=0;
	private int inversion=0; 
	private int[] helper=null;
	private int[] numbers;
	private StringBuffer sb=new StringBuffer();
	private void mergeSort(int low, int high){
		//Check if low is smaller then high,  if not then the array sorted
		if (low< high){
			//Get the index of the element which is in the middle
			
			int middle=(low+high)/2;
			//if (middle==0){
					//System.out.println("middle"+middle);
			//else{	
				//sort the left side of the array
				mergeSort( low, middle);
				//Sort the right side of the array
				mergeSort( middle+1, high);
				//Combine them both
				count=merge(low, middle, high);
			//}
		}
	}
	
	
	private long merge( int low, int middle, int high) {
	
		//Copy both parts into the helper array
		for( int i=low; i<=high; i++){
				helper[i]=numbers[i];
				//System.out.println( numbers[i]);
		}
			int i=low;
			int j=middle+1;
			int k=low;
			//copy the smallest value from either left or right side back to original array
			while (i<=middle && j <=high){
				if (helper[i]<=helper[j]){
					numbers[k]=helper[i];
					i++;
				}else{
					numbers[k]=helper[j];
					j++;
					//if (i!=middle){
					 count+=(middle-i+1);
					//}
					System.out.println("count:"+count +" middle:"+ (middle-i+1));
					inversion=inversion+1;
				}
				k++;
			}
			//Copy rest of left side of the array into target array
			while(i<=middle){
				numbers[k]=helper[i];
				k++;
				i++;
			}
			return count;
	}
	
	public static void main(String args[]){
// int[] input = {1,5,2, 9,3,4, 6, 7, 8 };
		inputFileTest in= new inputFileTest();	
		int[] input;
		input =in.readFile();	
		CountInversionMergeSort c= new CountInversionMergeSort();
		c.numbers=input;
		c.helper=new int[input.length];
		
//		for(int i=0;i<c.numbers.length;i++){
//			System.out.print(c.numbers[i]+ ", ");
//		}
		c.mergeSort(0, input.length-1);
		System.out.println("Sorted numbers are:");
//		for(int i=0;i<c.numbers.length;i++){
//			System.out.print(c.numbers[i]+ ", ");
//		}
		System.out.println();
		System.out.println("Number of inversion in input are:"+c.count);
		System.out.println("Number of inversion in input are:"+c.inversion);
//		for(int i=0;i<c.sb.length();i++){
//			System.out.print(c.sb.charAt(i)+ ", ");
//		}
	}

}
