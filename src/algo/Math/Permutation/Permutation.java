package algo.Math.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res); // start with 0
        return res;
    }

    public void permute(int[] nums, int i, List<List<Integer>> out) {
        if(i >= nums.length-1) { // if that is last one
            List<Integer> res = new ArrayList<>();
            for(int k=0; k< nums.length; k++) {
                res.add(nums[k]);
            }
            out.add(res);
            return;
        }

        for(int k=i; k < nums.length; k++) {
            swap(nums, i, k);
            permute(nums, i+1, out);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

    }
        public static void main(String[] args) {
        Permutation pm = new Permutation();

        System.out.println(pm.permuteUnique(new int []{ 1,2,3}));
    }
}
