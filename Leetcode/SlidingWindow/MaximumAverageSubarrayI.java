
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)); // 12.75
        System.out.println(findMaxAverage(new int[]{5}, 1));                // 5.0
        System.out.println(findMaxAverage(new int[]{0,1,1,3,3}, 4));       // 2.0
    }

    // ============================================
    // LC 643 — Maximum Average Subarray I
    // ============================================
    // Given an integer array nums and an integer k,
    // find the contiguous subarray of length k that has
    // the maximum average value, and return that average.
    // ============================================
    static double findMaxAverage(int[] nums, int k) {
        int maxValue = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            maxValue += nums[i];
        }
        sum = maxValue;
        int left = 0;
        for(int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[left++];
            maxValue = Math.max(maxValue, sum);
        }
        return (double) maxValue / k;
    }
}

