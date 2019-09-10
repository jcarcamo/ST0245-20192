package edu.eafit.st0245.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {
    private static boolean isOperand(char val){
        return (val >= 'a' && val <= 'z') || (val >= 'A' && val <= 'Z');
    }

    private static int precedence(char operator){
        switch (operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 3;
        }
    }

    public static int evaluate(String postfix) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < postfix.length(); i++){
            char val = postfix.charAt(i);
            if(Character.isDigit(val)){
                stack.push(Integer.parseInt(val + ""));
            }else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (val){
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static String convert(String infix){
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < infix.length(); i++){
            char val = infix.charAt(i);
            if(InfixToPostfix.isOperand(val)){
                sb.append(infix.charAt(i));
            }
            else if(val == '('){
                stack.push(val);
            }else if(val == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() != '('){
                    return "Invalid Expression";
                }else{
                    stack.pop();
                }
            }else{
                while(!stack.isEmpty()
                        && InfixToPostfix.precedence(val) <= InfixToPostfix.precedence(stack.peek())
                        && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.push(val);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String infix = "a+b*(c%d-e)%(f+g*h)-i";
        String postfix = InfixToPostfix.convert(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
        System.out.println();
        String postfixEval = "231*+9-";
        int result = InfixToPostfix.evaluate(postfixEval);
        System.out.println(postfixEval + " = " + result);
    }
}
