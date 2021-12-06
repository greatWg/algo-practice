package algo.Arrays;

class Solution {

    public void sortArray(int[] nums) {
        this.printArray(nums);
        this.mergeSort (nums, 0, nums.length);
        this.printArray(nums);

    }

    public void mergeSort(int[] nums, int low, int high){

        if (low<high) {
            int mid= (low+high)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public void  merge(int[] nums, int low, int mid, int high){
        int[] helper = new int[high];

        for (int p=0; p<high; p++){
            helper[p]= nums[p];
        }
        int i=low , j= mid, k=0;

        while (i <mid && j <high ){
            if (helper[i]< helper[j]){
                nums[k]= helper[i];
                i++;
            }
            else{
                nums[k]= helper[j];
                j++;
            }
            k++;
        }
        while( i<mid){
            nums[k]= helper[i];
            i++;
            k++;
        }

    }
    public void printArray(int[] array){
        for (int i=0; i< array.length; i++){
            System.out.print( array[i]+ " ");
        }
    }
}