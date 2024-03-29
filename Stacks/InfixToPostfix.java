package edu.eafit.st0245.stacks;

public class InfixToPostfix {

    private static int precedence(char operator){
        switch(operator){
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

    public static int evaluate(String postfix){
        ArrayStack<Integer> stack = new ArrayStack<>(postfix.length());
        for(int i = 0; i < postfix.length(); i++){
            char val = postfix.charAt(i);
            if(Character.isDigit(val)){
                stack.push(Integer.parseInt(val+""));
            }else{
                int val1 = Integer.parseInt(stack.pop() + "");
                int val2 = Integer.parseInt(stack.pop() + "");
                switch(val){
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
        ArrayStack<Character> stack = new ArrayStack<>(infix.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < infix.length(); i++){
            char val = infix.charAt(i);
            if(Character.isAlphabetic(val)){
                sb.append(val);
            }else{
                if(!stack.isEmpty()
                        && InfixToPostfix.precedence(val) <= InfixToPostfix.precedence(stack.peek())){
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
        String infix = "a*b+c";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + InfixToPostfix.convert(infix)); //ab+
        int infixVal = 2 * 3 + 5;
        String postfix = "23*5+";

        System.out.println();
        System.out.println("Infix: " + infixVal );
        System.out.println("Postfix: " + InfixToPostfix.evaluate(postfix));

    }
}
