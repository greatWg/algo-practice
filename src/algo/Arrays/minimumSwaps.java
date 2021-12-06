package algo.Arrays;

import java.io.IOException;
import java.util.Scanner;

public class minimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwapsInArray(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int swapIndex = searchValue(arr, i + 1);
                // swap
                int temp = arr[swapIndex];
                arr[swapIndex] = arr[i];
                arr[i] = temp;
                count++;
            }

        }
        return count;
    }

    private static int searchValue(int[] arr, int p) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == p) {
                return i;
            }
        }
        return -1;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] arr = new int[]{2, 3, 4, 1, 5};
        int res = minimumSwapsInArray(arr);
        System.out.println("result " + res);

        int[] arr1 = new int[]{1, 3, 5, 2, 4, 6, 7};
        int res2 = minimumSwapsInArray(arr1);
        System.out.println("result " + res2);


    }
}
