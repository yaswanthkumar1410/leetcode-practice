
import java.util.*;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8))); // [3, 4]
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));               // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));              // [0, 0]
    }

    // ============================================
    // LC 34 — Find First and Last Position of Element in Sorted Array
    // ============================================
    // Given a sorted array and a target, find the starting
    // and ending position of target. If not found, return [-1,-1].
    // O(log n) time.
    // ============================================
    static int[] searchRange(int[] nums, int target) {
        // your code here
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MIN_VALUE;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                rightIndex = Math.max(rightIndex, mid);
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                leftIndex = Math.min(leftIndex, mid);
                right = mid - 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{(leftIndex == Integer.MAX_VALUE) ? -1 : leftIndex, (rightIndex == Integer.MIN_VALUE) ? -1 : rightIndex};
    }
}
