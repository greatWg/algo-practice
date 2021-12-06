package algo.string;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<String>();

        for (String token : tokens){
            if (token == "+" || token == "-" || token == "*" || token == "/"){
                String operation = token;
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int value = calculateOperation(first, second , operation);
                stack.push(String.valueOf(value));
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int calculateOperation(int first, int second , String operation){
        int value =0;
        switch(operation){
            case "+":
                value = first + second;
                break;
            case "-":
                value = first - second;
                break;
            case "*":
                value = first * second;
                break;
            case "/":
                value = first / second;
                break;
            default:
                break;
        }
        return value;
    }

    public static void main (String args[]){
        ReversePolishNotation RN= new ReversePolishNotation();

        String[] input= {"2","1","+","3","*"};
        System.out.println( "Expected 9 " + RN.evalRPN(input));

        String[] input1= {"4","13","5","/", "+"};
        System.out.println("Expected 6 " + RN.evalRPN(input1));

        String[] input2= {"10","6","9","3","+","-11","*","/","*","17","+","5","+" };
        System.out.println("Expected 22 " + RN.evalRPN(input2));
    }
}
