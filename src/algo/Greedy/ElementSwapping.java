package algo.Greedy;

public class ElementSwapping {

    int[] findMinArray(int[] arr, int k) {
        // Write your code here

            // Write your code here
            int n = arr.length;
            //int i=1;

            int i=0;
            if ( arr[i]> arr[i+1]) {
                while (i < n - 1 && arr[i] > arr[i + 1]) {
                    i++;
                }
            }else{
                while (i < n - 1 && arr[i] <arr[i + 1]) {
                    i++;
                }
                // update pointer to the first smallest element
                i++;
            }

            // perform swap
            while (k>0 && i>0){
                int temp = arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=temp;
                k--;
                i--;
            }

            return arr;

    }


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
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        check(expected_1, output_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ElementSwapping().run();
    }
}
