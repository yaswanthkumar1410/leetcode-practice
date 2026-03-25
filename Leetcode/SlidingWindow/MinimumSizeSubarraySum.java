
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));            // 2
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));                   // 1
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));       // 0
    }

    // ============================================
    // LC 209 — Minimum Size Subarray Sum
    // ============================================
    // Given an array of positive integers and a target,
    // return the minimal length of a subarray whose
    // sum >= target. If no such subarray, return 0.
    // ============================================
    static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for(int right  = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
