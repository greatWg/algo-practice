package algoPS1;

import java.util.Stack;

public class splitTwoStringsToMakePalindtrom {
    public boolean checkPalindromeFormation(String a, String b) {
        if (a.length()== 1 &&  b.length()==1 ){
            return true;
        }
        else{
            String AandB =  a.concat(b);
            String BandA = b.concat(a);
            return ( containsPalindrom(AandB) || containsPalindrom(BandA));

        }

    }

    private boolean containsPalindrom(String str){
        Stack<Character> stack= new Stack<Character>();
        for (char c: str.toCharArray()){
            if (stack.isEmpty()){
                stack.push(c);
            }else{
                stack.peek();
            }
        }
        return false;

    }
}
