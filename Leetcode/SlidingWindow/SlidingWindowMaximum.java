
import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));                   // [1]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1)));                // [1,-1]
    }

    // ============================================
    // LC 239 — Sliding Window Maximum
    // ============================================
    // Given an array and window size k, return an array
    // of the maximum value in each window position as
    // the window slides from left to right.
    // ============================================
    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] windowMax = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < k; i++) {
            if(deque.isEmpty()) {
                deque.add(i);
            } else {
                if(nums[deque.peekLast()] >= nums[i]) {
                    deque.add(i);
                } else {
                    while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                        deque.pollLast();
                    }
                    deque.add(i);
                }
            }
        }
        int windowMaxIndex = 0;
        for(int i = k; i < nums.length; i++) {
            windowMax[windowMaxIndex++] = nums[deque.peekFirst()];
            while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        windowMax[windowMaxIndex++] = nums[deque.peekFirst()];
        return windowMax;
    }
}
