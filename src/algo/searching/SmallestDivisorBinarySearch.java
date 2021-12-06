package algo.searching;

public class SmallestDivisorBinarySearch {


    public long computeSum(int[] nums, int x) {
        long s = 0;
        for (int n : nums) {
            s += n / x + (n % x == 0 ? 0 : 1);
        }
        return s;
    }

    public int smallestDivisorBinarySearch(int[] nums, int threshold) {
        // search boundaries for the divisor
        int left = 1, right = 2;
        while (computeSum(nums, right) > threshold) {
            left = right;
            right <<= 1;// right*2
        }

        // binary search
        while (left <= right) {
            //System.out.println((right - left) /2 );
            int pivot = left + ((right - left) >> 1);
            long num = computeSum(nums, pivot);

            if (num > threshold) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        // at the end of loop, left > right,
        // computeSum(right) > threshold
        // computeSum(left) <= threshold
        // --> return left
        return left;
    }
    public static void main(String[] args) {
        SmallestDivisorBinarySearch sdBS= new SmallestDivisorBinarySearch();

        System.out.println(5==sdBS.smallestDivisorBinarySearch(new int [] {1,2,5,9}, 6)? "passed":"failed");
        System.out.println(3==sdBS.smallestDivisorBinarySearch(new int []{2,3,5,7,11}, 11)? "passed": "failed");
        System.out.println(sdBS.smallestDivisorBinarySearch(new int[] {962551,933661,905225,923035,990560}, 10));
        System.out.println(sdBS.smallestDivisorBinarySearch(new int[] {91,41,78,86,8}, 114));

    }
}
