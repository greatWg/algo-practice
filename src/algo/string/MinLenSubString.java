package algo.string;

public class MinLenSubString {

    int minLengthSubstring(String s, String t) {
        // Write your code here\
        // Write your code here\
        int minLen= 0;
        int start =0;
        //Stack<Character> st= new Stack<>();
        int i=0;
        int n = s.length();
        boolean started=false;;

        while (i<n) {
            char c = s.charAt(i);
            if (t.indexOf(c)>0 || started== true){
                started=true;
                minLen++;
                t= t.replaceFirst(Character.toString(c),   "");
                System.out.println( " char "+ t);
            }
            if (t.equals(""))
            {
                System.out.println( " t :  "+  t + " "+ minLen );

                //startIndex = false;
                break;
            }
            i++;
        }
        System.out.println("t " + s + " t "+ t ) ;
        if(t.length()>0){
            minLen= -1;
        }
        //minLen= st.size();
        return minLen;
    }

    public static void main(String[] args) {
        MinLenSubString mls= new MinLenSubString();
        System.out.println(
        mls.minLengthSubstring("dcbefebce", "fd"));

        String s = "abcd";
        char c = s.charAt(2);
        System.out.println(s.replace(c, 'f') + " : "+ s );

        System.out.println(mls.minLengthSubstring("bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf" , "cbccfafebccdccebdd"));

    }

}
