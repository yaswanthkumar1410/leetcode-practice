
import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("{[]}")); // true
    }

    // ============================================
    // LC 20 — Valid Parentheses
    // ============================================
    // Given a string containing just '(', ')', '{', '}',
    // '[' and ']', determine if the input string is valid.
    // ============================================
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.add(c);
            else {
                if (stack.isEmpty())
                    return false;
                char open = stack.pop();
                switch (c) {
                    case ')' -> {
                        if (open != '(')
                            return false;
                    }
                    case '}' -> {
                        if (open != '{')
                            return false;
                    }
                    case ']' -> {
                        if (open != '[')
                            return false;
                    }
                    default -> {
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
