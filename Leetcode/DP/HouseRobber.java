
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));     // 4 (rob house 1 + house 3)
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));  // 12 (rob house 1 + house 3 + house 5)
        System.out.println(rob(new int[]{2, 1, 1, 2}));     // 4 (rob house 1 + house 4)
        System.out.println(rob(new int[]{5}));               // 5
    }

    // ============================================
    // DP — PROBLEM 2: House Robber
    // ============================================
    // You're a robber. Each house has some money.
    // You CANNOT rob two adjacent houses (alarm goes off).
    // Return the maximum amount you can rob.
    //
    // Example: [2, 7, 9, 3, 1]
    //   Rob house 1 (2) + house 3 (9) + house 5 (1) = 12
    //   Rob house 2 (7) + house 4 (3) = 10
    //   Best: 12
    //
    // Think about it:
    //   At each house i, you have 2 choices:
    //     1. Rob it: take nums[i] + best from house i-2
    //     2. Skip it: take best from house i-1
    //   dp[i] = max(nums[i] + dp[i-2], dp[i-1])
    //
    //   Base cases: dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
    //
    // Rules:
    //   - O(n) time
    // ============================================
    static int rob(int[] nums) {
        // your code here
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        // nums 2 1 1 2
        // dp   2 2 3 4
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
