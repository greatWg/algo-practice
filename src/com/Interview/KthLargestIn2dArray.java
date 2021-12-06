package com.Interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestIn2dArray {

	
////	 2 dim array - sorted  row and column
//	 K , Kth largest number

//	 
//	 1 (0,0)    5(0,1)		7 (0, 2) 
//	 2 (1,0)   	6(1, 1)    13 (1, 2)
//	 4 (2,0)   10(2,1)     21 (2, 2)

//	 2nd largest 13
//	 4th largest 7
//	 1st largest 21
//	 
//	 int GetLargestNumber(int[][] a , int k, int numRow, int numCol ){
//	   int count=0;
//	   
//	   RowMax = a[i].length; 
//	   COlumnMax=  a][j].length
//	    for (int i=numRow; i>0 ;  ){ 
//	    
//	     for (int j=numCol; j>0 ;  ){
//	        
//	       if (k=1)
//	        retunrn  a[i][j];
//	        
//	       if (
//	       if (count ==K)
//	       {
//	        return a[i][j];//21//13
//	       }
//	       j--; i--;
//	        
//	        GetLargest( a[i-1][j], a[i][j], a[i][j-1])
//	      }
//	     }
//	 }
	 
	int KthLrgestin2DimentionalArray ( int[][] array, int k){
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(array.length,new Comparator<Integer>(){
			  public int compare(Integer w1, Integer w2) {                           
                  return w2.compareTo(w1);    
              }        
          }); 

		int count;
		//The array is sorted in rows and columns
		int rowMax = array.length;
		int columnMax= array.length;
		int i=rowMax-1, j=columnMax-1;
	
		
		int[] largest = new int[rowMax * columnMax];
		if (k == 1){
			largest[k]=array[rowMax-1][columnMax-1];
			return array[rowMax-1][columnMax-1];
		}
		if (k == (rowMax * columnMax)){
			largest[(rowMax * columnMax)-1]=array[0][0];
			return array[0][0];
		}
		else
		{ 
			if (i>=0 && i<rowMax ||j>=0 && j<columnMax){
				pq.add(array[i-1][j]); 
				pq.add(array[i][j-1]);
				i=i-1;
				j=j-1;
			}
			if (k==2 ){
			  return pq.poll();
			}
			if (k==3)
			{
				pq.poll();
				return pq.poll();
			}
			while(!pq.isEmpty()){
				pq.remove();
			}
			boolean flag=true;
			// Max diagonal elements in array
			i=rowMax-1; j=columnMax-1;
			count=0;
			while (flag==true){
				
				while (i<rowMax && j>=0){
					pq.add(array[i][j]);
					i++;
					j--;
					count++;
				}
				pq.add(array[i][j]);
				count++;
				while (i>=0 && j<columnMax ){
					pq.add(array[i][j]);
					i--;
					j++;
					count++;
				}
				if (k== count){
					return pq.poll();
				}else
				{
					
				}
				if(i>0 && j>0){
					i--;j--;
				}else 
				{
					flag = false;
				}
			}
			
//			if (i>=0 && i<rowMax ||j>=0 && j<columnMax){
//				pq.add(array[i-1][j+1]);  
//				pq.add(array[i][j]);
//				pq.add(array[i+1][j-1]);
//				i=i-1;
//				j=j-1;
//			}
			if (k==4){
				  return pq.poll();
			}
			if (k==5)
			{
				pq.poll();
				return pq.poll();
			}
			if (k==6)
			{
				pq.poll();
				pq.poll();
				return pq.poll();
			}
			
			
			int  x = GetMaxList(i,j,array,pq);
//	pq.poll();
			
//			
//			 
//			 pq.add();//k==2 or k==3
//			compare( array[rowMax-1][j], array[i][columnMax-1]);
//			//k==4,5,6
//			compare( array[rowMax-1][j],array[rowMax-1][columnMax-1], array[i][columnMax-1]);
//			//k=7,8
//			
//			
//			if (array[i-1][j] < array[i][j-1]){
//				 largest[k+1] = array[i][j-1];
//				 return(array[i][j-1]);
//			 }else{
//				 largest[k+1+1] = array[i-1][j];
//				 return (array[i-1][j]);
//			 }
		}
		 return 0;
	}
	private int GetMaxList(int i, int j, int[][] array, PriorityQueue<Integer> pq) {
		pq.add(array[i][j]);
		while(i<3){
			
		}
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestIn2dArray x= new KthLargestIn2dArray();
		int[] [] array2 = {{1,2}, {3,4}};
		int[] [] array3 = {{1, 5,  7}, 
						   {2, 6,  13}, 
						   {4, 10, 21}};
		int k = 3;
		int result= x.KthLrgestin2DimentionalArray(array2, k);
		System.out.println("Result Array2 for "+k +" largest "+result );
		k=6;
		result= x.KthLrgestin2DimentionalArray(array3, k);
		System.out.println("Result Array3 for "+k +" largest "+result );
		
		
	}

}
