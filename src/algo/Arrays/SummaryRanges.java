package algo.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int count=nums[0];
        int start=nums[0];
        count++;
        List<String> range= new ArrayList<String>();
        for (int i=1; i<nums.length; i++){
            if (nums[i]!=count ){
                if ( nums[i-1]==start){
                    range.add(String.valueOf(nums[i-1]));
                }else {
                    String rangeStr = start + "->" + nums[i - 1];
                    range.add(rangeStr);
                }
                // reset the start point and counter for the range serach
                start= nums[i];
                count=nums[i];
                count++;

                if(i== nums.length-1){
                    range.add(String.valueOf(nums[i]));
                }
            }else {
                count++;
                if(i== nums.length-1 && nums[i]!= start){
                    String rangeStr = start + "->" + nums[i];
                    range.add(rangeStr);
                }
            }
        }
        return range;
    }

    public static void main(String[] args) {
        SummaryRanges sr= new SummaryRanges();
        int[] input = { 0,1,2,4,5,7};
        System.out.println (sr.summaryRanges(input));

        int[] input1 = { 0,2,3,4,6,8,9};
        System.out.println (sr.summaryRanges(input1));


    }
}
