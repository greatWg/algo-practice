package algo.string;

import java.util.HashMap;

public class RemoveDuplicateLetters {

   public String removeDuplicateLettersMethodC(String s) {
            int [] dict = new int[26];
            boolean [] visited = new boolean[26];

            for(char i: s.toCharArray()) {
                dict[i - 'a']++;
            }

            StringBuilder sb= new StringBuilder();

            for(char c : s.toCharArray()) {
                dict[c - 'a']--;

                if(visited[c-'a']) {
                    continue;
                }
                // if you found the lex order low of current character remove previous character list
                while (sb.length()>0 && c < sb.charAt(sb.length()-1) && dict[(sb.charAt(sb.length()-1) - 'a')] > 0) {
                    visited[Math.abs(sb.charAt(sb.length()-1) - 'a')] = false;
                    sb.deleteCharAt(sb.length()-1);
                }

                sb.append(c);
                visited[c-'a'] = true;
            }
            return sb.toString();
    }

    public static void main (String[] args){
        RemoveDuplicateLetters LexOrder= new RemoveDuplicateLetters();

        String s0= "bcabc"; // -2-3 0 12 //abc

        String s1 = "cbacdcbc";//  acdb

        String s2 = "qrpqr"; // pqr

        String s3 =  "cdadabcc"; // adbc

        String s4 = "ecbacba"; //e-2-1021 //eacb

        String s5 ="cdadabcc"; // b //-2-303b2 // adbc

        String s6= "leetcode"; // ltcod // letcod letcod

        System.out.println( " *******Method c++ ***** ");

        System.out.println(LexOrder.removeDuplicateLettersMethodC(s0));
        System.out.println(LexOrder.removeDuplicateLettersMethodC(s1));
        System.out.println(LexOrder.removeDuplicateLettersMethodC(s2));
        System.out.println(LexOrder.removeDuplicateLettersMethodC(s3));
        System.out.println(LexOrder.removeDuplicateLettersMethodC(s4));
        System.out.println(LexOrder.removeDuplicateLettersMethodC(s5));
        System.out.println(LexOrder.removeDuplicateLettersMethodC(s6));

    }

}
