package algoPS1;

import com.util.inputFileTest;

/**
 * 
 * @author Amita
 *
 */
/**
 * Goal:
 */

public class QuickSort {
	
	private int[] numbers;
	private int number;
	private int count=0;
	private long extCount=0;
	
	public void sort(int[] values){
		if (values.length==0|| values==null){
			return;
		}
		this.numbers=values;
		number =values.length;
		quickSort(0, number-1);
	}
	public void quickSort(int low , int high){
		int i=low, j=high;
		int pivot= numbers[high];
		int temp;
		extCount+=(low+high)-1;
		while(i<=j){
			while (numbers[i]<pivot){
				i++;
				count++;
			}
			while (numbers[j]>pivot){
				j--;
				count++;
			}
			if(i<=j){
				temp= numbers[i];
				numbers[i]= numbers[j];
				numbers[j]=temp;
				i++;
				j--;
			}
			count--;
		}
		//recursion
		if(low< j)
			quickSort(low, j);
		if (i< high)
			quickSort(i, high);
	}

	public static void main(String args[]){
		//int[] input = {5,3,2,1 };
		inputFileTest in= new inputFileTest();	
		int[] input;
		input =in.readFile();	
		QuickSort q= new QuickSort();
		q.sort(input);
		
		
		System.out.println("Sorted numbers are:");
		for(int i=0 ; i<input.length;i++){
			System.out.println(q.numbers[i]);
		}
		System.out.println();
		System.out.println("Number of inversion in input are:"+q.count);
		System.out.println("Number of inversion in input are:"+q.extCount);
	}

}
