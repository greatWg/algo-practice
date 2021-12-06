package algo.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FindPositions {
    int[] findPositions(int[] arr, int x) {
        // Write your code here
        // x  (1, 316)
        //  n  (x , x*x)
        int n = arr.length;
        Queue<Integer> que= new LinkedList<>();
        Queue<Integer> index= new LinkedList<>();
        int[]  output= new int[x];
        // pop x element
        for( int i=0;i<n ; i++){
            que.add(arr[i]);
            index.add(i+1);
        }
        int maxValue= 0;
        int maxIndex= 0;
        int counter=1;

        for(int iteration=0; iteration<x; iteration++){

            maxIndex=0;
            maxValue=0;
            while (counter <= x){
                int val = que.remove();
                int ind= index.remove();
                if(val > maxValue){
                    maxValue= val;
                    maxIndex= ind;
                }
                if (val>0){
                    que.add(val-1);
                    index.add(ind);
                }else{
                    que.add(val);
                    index.add(ind);
                }
                counter ++;
            }
            if (counter==x){
                int val = que.remove();
                int ind= index.remove();
                counter=0;
            }
            output[iteration]=maxIndex;
        }

        // popped - find largest value (take ealiest popped)

        // if positive > 0 decrement val by 1
        return output;

    }

    public static void main(String[] args) {
        new FindPositions().run();
    }
    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
}
