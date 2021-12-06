package algo.intution;

import java.util.HashMap;
import java.util.Map;

public class numPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int pairCount=0;
        int min = 60;

        for(int i=0; i< time.length;i++){
            int sec= time[i];
            sec = sec  % min;
            if (sec >0){
                if (map.containsKey(60-sec)) {
                    pairCount++;
                    System.out.println(" time i : "+ time[i]);

                    map.put(60 - sec, map.get(60 - sec) + 1);
                }
                else{
                    map.put(60-sec, 1);
                }
            }else if (sec==0){
                pairCount++;
            }
        }
        return pairCount++;
    }

    public int solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            n = n % 60;
            if (map.containsKey(60 - n == 60 ? 0 : 60 - n))
                res += map.get(60 - n == 60 ? 0 : 60 - n);
                System.out.println( " map value: " + (60 - n) );
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        numPairsDivisibleBy60 pair= new numPairsDivisibleBy60();

//        int[] input = new int [] {30,20,150,100,40};
//         System.out.println(pair.numPairsDivisibleBy60(input));
//
//        int[] input1 = new int [] {60,60, 60};
//        System.out.println(pair.numPairsDivisibleBy60(input1));


        int[] input2 = new int [] {418,204,77,278,239,457,284,263,372,279,476,416,360,18};
        System.out.println(pair.numPairsDivisibleBy60(input2));

        System.out.println(pair.solve(input2));

    }

}
