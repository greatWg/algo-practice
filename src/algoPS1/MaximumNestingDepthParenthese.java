package algoPS1;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumNestingDepthParenthese {

    public int maxDepth(String s) {
        int maxDepth=0;
        int parenCount=0;
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()){
            if (c == '('){
                parenCount++;
            }
            stack.push(c);
            if ( maxDepth<parenCount){
               maxDepth=parenCount;
            }
            if (c == ')'){
                parenCount --;
            }
        }
        return maxDepth;


    }



    private void countMaxDigitParenthesis(String s) {

    }

    public static void main(String[] args) {
        MaximumNestingDepthParenthese maxParen= new MaximumNestingDepthParenthese();
        System.out.println( maxParen.maxDepth("(1+(2*3)+((8)/4))+1")); //3


        System.out.println( maxParen.maxDepth("(1)+((2))+(((3)))")); // 3

        System.out.println( maxParen.maxDepth("1+(2*3)/(2-1)")); // 1
        System.out.println( maxParen.maxDepth("1")); // 0
    }


}
