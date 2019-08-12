package LongestValidParentheses;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args){

        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

        System.out.println(longestValidParentheses.solution("()((()()()"));
    }

    public int solution1(String s){

        int maxans = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack();

        stack.push(-1);
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }

        return 0;
    }

    public int solution(String s){

        int len = s.length();
        Stack<Character> stack = new Stack<>();

        int count = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    count++;
                }
            }else if(s.charAt(i) == '('){
                stack.push('(');
            }
        }

        return count * 2;
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
