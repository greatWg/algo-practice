package algo.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinDeletion {

    public int minDeletions(String s) {
        //Start: 9:19

        //brute force approach
        // cal fre in map
        // delete par by calling out duplicate values
        // a->2 b->1 c->1  store in array
        // then store the freq as key and if found again then consider to reduce.
        int[] array= new int[26];
        for (char c : s.toCharArray()){
            array[c-'a'] += 1;
        }

        List<Integer> freq = new ArrayList<>();
        for(int count: array){
            if (count!=0){
                freq.add(count);
            }
        }
        // sort freq list asc
        Collections.sort(freq);


        int ans = 0;
        int expectedFreq = Integer.MAX_VALUE;

        // max occur in list
        for (int i = freq.size()-1; i >= 0; i--) {
            expectedFreq = Math.min(expectedFreq, freq.get(i));
            ans += Math.max(0, freq.get(i)- expectedFreq);  // 3-3 if expected freq count in decreasing order
            expectedFreq = Math.max(0, --expectedFreq); // expected freq set 2
        }


        return ans;

    }

    public static void main(String[] args) {
        MinDeletion md= new MinDeletion();
        System.out.println("expectes: 0 actual : "+ md.minDeletions("aab"));
        System.out.println("expectes: 2 actual : "+ md.minDeletions("aaabbbcc"));
        System.out.println("expectes: 2 actual : "+ md.minDeletions("ceabaacb"));
    }
}
