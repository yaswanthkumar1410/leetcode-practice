
import java.util.*;

public class MinStack {

    public static void main(String[] args) {
        // Min Stack: push, push, push, getMin, pop, top, getMin
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();

        // push(-2)
        stack.push(-2);
        minStack.push(-2);

        // push(0)
        stack.push(0);
        minStack.push(Math.min(0, minStack.peek()));

        // push(-3)
        stack.push(-3);
        minStack.push(Math.min(-3, minStack.peek()));

        System.out.println(minStack.peek()); // getMin → -3

        // pop
        stack.pop();
        minStack.pop();

        System.out.println(stack.peek());    // top → 0
        System.out.println(minStack.peek()); // getMin → -2
    }

    // ============================================
    // LC 155 — Min Stack
    // ============================================
    // Design a stack that supports push, pop, top, and
    // retrieving the minimum element in O(1) time.
    //
    // Use two stacks: one for values, one for tracking
    // the min at each level.
    //
    // Already implemented in main — just verify it runs.
    // ============================================
}
