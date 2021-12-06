package algo.Arrays;

public class maxPower {
    public int maxPower(String s) {
        int[] power = new int [26];
        int count =0;
        for(int i=0; (i+count)< s.length();){
            count=0;
            while ((i+count)<s.length() && s.charAt(i)== s.charAt(i+count) ){
                count++;
            }
            int currChar= s.charAt(i)-'a';
            if (power[currChar] < count){
                power[currChar]= count;
            }
            i=i+count;

        }
        int max=0;
        for(int i=0; i<power.length;i++){
            if (max< power[i]){
                max= power[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maxPower mp= new maxPower();
        System.out.println("expeceted : 2  actual: " + mp.maxPower("leetcode"));
        System.out.println("expeceted : 5 actual: " + mp.maxPower("abbcccddddeeeeedcba"));
        System.out.println("expeceted : 5 actual: " + mp.maxPower("triplepillooooow"));
        System.out.println("expeceted : 11 actual: " + mp.maxPower("hooraaaaaaaaaaay"));
        System.out.println("expeceted : 1 actual: " + mp.maxPower("tourist"));
    }
}
