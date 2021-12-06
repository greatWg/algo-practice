package algo.Arrays;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class ConsecutiveArray {

    public static void main(String[] args) {
        int [] intput= { 4 , 2,  1, 6, 5};
        ConsecutiveArray array = new ConsecutiveArray();
        System.out.println(array.getLongestConsecutive(intput));
    }

    private int getLongestConsecutive(int[] input) {

        HashSet<Integer> values= new HashSet<>();
        //Add values in set
        for (int i: input){
            values.add(i);
        }

        int maxlength=0;
        // iterate value is set
        for (int i: values){
            if (values.contains(i-1)){
                System.out.println( "vlaue "+ (i-1) +" ");
                continue;
            }
            System.out.println( "here ");
            int length =0;
            while(values.contains(i++)){
                length ++;
            }
            maxlength= Math.max(length, maxlength);
            if (values.contains(i-1)){
                System.out.println( "vlaue "+ (i-1) +" ");
                continue;
            }
        }
        return  maxlength;
    }

}
