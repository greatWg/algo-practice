package algo.string;


public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {

        int mismatchcount=0;

        if (A.isEmpty() || B.isEmpty()) {
            return false;
        }

        int[] aChars= new int[26];
        for (char c : A.toCharArray()){
            aChars[c-'a']++;
        }

        int[] bChars= new int[26];
        for (char c : B.toCharArray()){
            bChars[c-'a']++;
        }


        // find only mismatch counts
        for(int i=0; i< A.length(); i++){
            if (A.charAt(i)!=B.charAt(i)) {
                mismatchcount++;
            }
        }

        // Count of each character did not match  - "abcaa", "abcbb"
        for (int i=0; i<aChars.length; i++){
            if (aChars[i]!= bChars[i])
                return false;
        }

        // only one swap means two character are in different position
        if(mismatchcount==2 ) {
            return true;
        }

        // if string has duplicate like 'aa'
        boolean contains_duplicate= false;
        for (int count : aChars){
            if (count>=2 ){
                contains_duplicate=true;
            }
        }

        // no mismatch but have duplicates count  aaab aaab - mean one swap is there
        // can not be distinguished due to duplicate>=2
        if (mismatchcount==0 && contains_duplicate){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BuddyStrings bs= new BuddyStrings();
        System.out.println("expected True  but  actual is : "+ bs.buddyStrings("ab", "ba"));
        System.out.println("expected false  but  actual is : "+ bs.buddyStrings("ab", "ab"));
        System.out.println("expected true  but  actual is : "+ bs.buddyStrings("aa", "aa"));
        System.out.println("expected true  but  actual is : "+ bs.buddyStrings("aaaaaaabc", "aaaaaaacb"));

        System.out.println("expected false  but  actual is : "+ bs.buddyStrings("", "aa")); //

        System.out.println("expected false  but  actual is : "+ bs.buddyStrings("abcaa", "abcbb"));


    }
}
