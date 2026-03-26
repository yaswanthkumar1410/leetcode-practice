
import java.util.*;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));           // 9
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));         // 6
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // 22
    }

    // ============================================
    // LC 150 — Evaluate Reverse Polish Notation
    // ============================================
    // Evaluate an arithmetic expression in Reverse
    // Polish Notation. Valid operators are +, -, *, /.
    // Division truncates toward zero.
    // ============================================
    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            switch (s) {
                case "+":
                    stack.add(stack.pop() + stack.pop());
                    break;
                case "-":
                    {
                        int second = stack.pop();
                        int first = stack.pop();
                        stack.add(first - second);
                        break;
                    }
                case "*":
                    stack.add(stack.pop() * stack.pop());
                    break;
                case "/":
                    {
                        int second = stack.pop();
                        int first = stack.pop();
                        stack.add(first / second);
                        break;
                    }
                default:
                    stack.add(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
