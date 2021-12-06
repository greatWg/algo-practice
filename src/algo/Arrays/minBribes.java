package algo.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class minBribes {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int i = q.length;
        int bribesCount=0;

        for( i = q.length-1; i>=0; i-- ){
            if (q[i] != i+1 ) {
                if ((i-1)>=0 && q[i - 1] == (i + 1)) {
                    bribesCount++;
                    int temp = q[i];
                    q[i] = q[i - 1];
                    q[i - 1] = temp;
                }
                else if((i-2)>=0 && q[i - 2] == ( i + 1)) {
                    bribesCount = bribesCount + 2;
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                }else {
                    System.out.println("Too Chaotic");
                    return;
                }
            }
        }
        System.out.println(bribesCount);
        return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            int [] q = {2 , 1, 5, 3, 4};
            minimumBribes(q); // 3

            int [] p = {2 , 5, 1, 3, 4};
            minimumBribes(p); //Too Chaotic

            int [] r = {1, 2 , 5, 3, 4, 7, 8, 6};
            minimumBribes(r); // 4

            int[] s = {5, 1, 2, 3, 7, 8, 6, 4};
            minimumBribes(s); // Too Chaotic

            int[] u = {1, 2, 5, 3, 7, 8, 6, 4};
            minimumBribes(u); // 7
        }

}
