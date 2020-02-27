package algoPS1;

public class testDelete {

	private int[] numbers;
	private int [] helper;
	int count=0;
	private void mergeSort(int low, int high){
		if (low<high){
		 int middle=(low+high)/2;
		 	mergeSort(low, middle);
		 	mergeSort(middle+1, high);
		 	count=merge(low, middle, high);
		 	
		}
		
	}

	private int merge(int low, int middle, int high) {
		
		 for (int i=low;i<=high;i++){
			 helper[i]= numbers[i];
			 
		 }
		 int i=low;
		 int j=middle+1;
		 int k=low;
		 
		while ( i<=middle && j<=high){
			 if(helper[i]<helper[j]){
				  numbers[k]=helper[i];
				  i++;
			  }else{
				  numbers[k]=helper[j];
				  j++;
				  count++;
			  }
			 k++;		  
		 }
		while ( i<=middle){
		  numbers[k]=helper[i];
		  i++;
		  k++;
		}
		
		
		return count;
	}
	
	public static void main(String args[]){
//		 int[] input= {1, 3, 5, 2, 4 , 6};
//		 testDelete t= new testDelete();
//		 t.numbers=input;
//		 t.helper= new int [t.numbers.length];
//		 t.mergeSort(0,t.numbers.length-1);
//		 for(int i=0; i<t.numbers.length;i++){
//			 System.out.print(t.numbers[i]+",");
//		 }
		int i=3;
		int j=i-8;
		System.out.println("i="+i +" j="+j);
	 }
		 
	}

	


