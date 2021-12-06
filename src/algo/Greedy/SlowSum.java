package algo.Greedy;

import java.util.Arrays;

public class SlowSum {

    int getTotalTime(int[] arr) {
        // Write your code here
        // 2 3 9 8 4 ==> 2 3 17 4 ==>  2 3 21 ==> 2 24=> 26 [ 17 + 21 + 24 + 26 ]= 88
        Arrays.sort(arr);
        int n= arr.length;
        //int [] temp = int[n];
        int sum = arr[n-1];
        int temp =0;
        for(int i=n-2; i>=0; i--){
            sum = sum + arr[i];
            temp += sum;
        }
        return temp;
    }

    public static void main(String[] args) {
        new SlowSum().run();
    }

    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

}
