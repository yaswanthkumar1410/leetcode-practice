
import java.util.Arrays;


public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));            // 4
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));         // 1
        System.out.println(lengthOfLIS(new int[]{1}));                             // 1
    }

    // ============================================
    // DP — PROBLEM 4: Longest Increasing Subsequence
    // ============================================
    // Given an array of integers, return the length of
    // the longest strictly increasing subsequence.
    //
    // A subsequence is a sequence that can be derived
    // by deleting some (or no) elements WITHOUT changing
    // the order of remaining elements.
    //
    // Example: [10, 9, 2, 5, 3, 7, 101, 18]
    //   Subsequence: [2, 3, 7, 101] → length 4
    //   (not contiguous — we skipped 10, 9, 5)
    //
    // Think about it:
    //   dp[i] = length of longest increasing subsequence
    //           ending at index i
    //
    //   For each i, look at every j before it (j < i):
    //     if nums[j] < nums[i]:
    //       dp[i] = max(dp[i], dp[j] + 1)
    //
    //   Base case: dp[i] = 1 (each element alone is a
    //   subsequence of length 1)
    //
    // Rules:
    //   - O(n^2) time
    // ============================================
    static int lengthOfLIS(int[] nums) {
        // your code here
        if(nums.length <=1) return nums.length;
        int[] maxSeqAtIndex = new int[nums.length];
        maxSeqAtIndex[nums.length - 1] = 1;
        Arrays.fill(maxSeqAtIndex, 1);

        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    maxSeqAtIndex[i] = Math.max(maxSeqAtIndex[i], maxSeqAtIndex[j] + 1);
                    }
            }
        }
        Arrays.sort(maxSeqAtIndex);
        return maxSeqAtIndex[nums.length - 1];
    }
}
