package algo.string;

public class IsSubSequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length()>0 && t.length()>0){
            int i= 0 , j=0;
            int counter=0;
            while(i<s.length() && j<t.length()){
                if (s.charAt(i)==t.charAt(j)){
                    i++; j++;
                    counter++;
                    System.out.println( counter +" ");
                }else {
                    i++;
                }
            }
            if (counter== t.length()){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        IsSubSequence seq= new IsSubSequence();
        System.out.println (seq.isSubsequence("ahbgc", "abc") ); //true
        System.out.println (seq.isSubsequence("ahkgc", "abc") ); //false

    }
}
