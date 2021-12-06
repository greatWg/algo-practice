package Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class findTotalPairOfSocks {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int totalPairOfSocks= 0;
        int count=0;
        int totalCount=0;
        if (n>0){
            HashMap<Integer, Integer> kindAPairCount= new HashMap<Integer,Integer>();
            // Add first element
            //kindAPairCount.put(ar[0],count+1); totalCount++;
            for (int i=0; i<n; i++){
                // if color of pair of socks contained already then update it's count
                if (kindAPairCount.containsKey(ar[i])){
                    int tempCount;
                    tempCount= kindAPairCount.get(ar[i])+1 ;
                    kindAPairCount.put(ar[i], tempCount);
                }
                else{
                    // else add only color
                    kindAPairCount.put(ar[i], count+1);
                    totalCount++;
                }
            }
            // Get values for color of socks

            Integer[] tempArray= kindAPairCount.values().toArray(new Integer[totalCount]);
            // total count pair of socks by dividing two
            for (int i=0; i<tempArray.length; i++){
                totalPairOfSocks += tempArray[i]/2;
            }
        }
        return totalPairOfSocks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] ar = new int[n];
//
//        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arItem = Integer.parseInt(arItems[i]);
//            ar[i] = arItem;
//        }

        int n=10;
        int[] ar = new int[]{1, 1, 3 , 1, 2 , 1 , 3 , 3, 3, 3};
        int result = sockMerchant(n, ar);

        System.out.println("pair count " + result); // 4

        scanner.close();
    }
}
