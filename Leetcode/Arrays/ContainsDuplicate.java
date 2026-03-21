
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(maxSubArray(new int[]{1}));                       // 1
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));             // 23
        System.out.println(maxSubArray(new int[]{-1}));                      // -1
    }

    // ============================================
    // LC 53 — Maximum Subarray
    // ============================================
    // Given an integer array nums, find the subarray
    // with the largest sum, and return its sum.
    //
    // A subarray is a contiguous non-empty sequence
    // of elements within an array.
    //
    // Example:
    //   Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //   Output: 6
    //   Explanation: [4,-1,2,1] has the largest sum 6.
    //
    // Constraints:
    //   - 1 <= nums.length <= 10^5
    //   - -10^4 <= nums[i] <= 10^4
    //
    // Rules: O(n) time
    // ============================================
    static int maxSubArray(int[] nums) {
        // your code here
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    } 
}
