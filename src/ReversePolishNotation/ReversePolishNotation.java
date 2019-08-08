package ReversePolishNotation;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args){
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens){

        Stack<Integer> valueStack = new Stack<>();

        int num1, num2;
        for(String token : tokens){

            if(token.equals("+")){
                num1 = valueStack.pop();
                num2 = valueStack.pop();
                valueStack.push(num2 + num1);
            }else if(token.equals("-")){
                num1 = valueStack.pop();
                num2 = valueStack.pop();
                valueStack.push(num2 - num1);
            }else if(token.equals("*")){
                num1 = valueStack.pop();
                num2 = valueStack.pop();
                valueStack.push(num2 * num1);
            }else if(token.equals("/")){
                num1 = valueStack.pop();
                num2 = valueStack.pop();
                valueStack.push(num2 / num1);
            }else {
                valueStack.push(Integer.parseInt(token));
            }
        }

        return valueStack.peek();
    }
}
