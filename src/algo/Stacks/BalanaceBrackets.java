package algo.Stacks;

import java.util.Stack;

public class BalanaceBrackets {
    char compliment (char c){
        if(c== '}'){
            return '{';
        }
        else if(c== ')'){
            return '(';
        }
        else {
            return '[';
        }
    }

    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack= new Stack<>();

        for( char c : s.toCharArray()){
            if ( c== '{' || c== '('|| c=='['){
                stack.push(c);
            }
            //char top = stack.peek();
            else if (((char) stack.peek()) == compliment(c)){
                stack.pop();
            }
            else{
                break;
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }
        //return stack.isEmpty();

    }

    public static void main(String[] args) {
        BalanaceBrackets bb = new BalanaceBrackets();
       // System.out.println( "{[(])}   expected false :"+  bb.isBalanced("{[(])}"));

        System.out.println(" {{[[(())]]}} expected true : "+ bb.isBalanced("{{[[(())]]}}"));


    }
}
