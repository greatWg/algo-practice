package com.Interview;


public class Problem1 {

    // array=  {  4,5, 1, 2, 3} , search  x= 2

    // search 5  x> mid x<end == false ( start, mid)
    // binary search : x> mid  --> x<end - true - search (mid, end )

    public int findInRotatedSortedArray( int [] array, int x ){
        // Skipp if check if array is empty
        // search 6
        return search(array, 0,array.length-1, x );

    }


    private int search( int[] array, int start, int end , int x){
        int value = 0;
        int mid = (start + end)/2 ; //2
        if(array[mid] == x)
            value =mid;
        else if( x== array[end]){
            return end;
        }else if( x== array[start]){
            return start;
        }
        else if(x>array[mid] && x<=array[end]){
            value =search(array, mid, end , x);
        }
        else {
            value =search (array, start, mid, x );
        }
        return value;


    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] array= { 4,5,1,2,3};

        System.out.println( problem1.findInRotatedSortedArray(array, 1));
        System.out.println( problem1.findInRotatedSortedArray(array, 2));
        System.out.println( problem1.findInRotatedSortedArray(array, 3));
        System.out.println( problem1.findInRotatedSortedArray(array, 4));
        System.out.println( problem1.findInRotatedSortedArray(array, 5));



    }
}
