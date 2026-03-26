import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2})); // 4
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // 9
        System.out.println(longestConsecutive(new int[]{})); // 0
        System.out.println(longestConsecutive(new int[]{1,2,0,1})); // 3
    }

    // ============================================
    // LC 128 — Longest Consecutive Sequence
    // ============================================
    // Given an unsorted array of integers, return the
    // length of the longest consecutive elements sequence.
    //
    // Must run in O(n) time. No sorting.
    //
    // Example: [100,4,200,1,3,2]
    //   Consecutive sequence: 1,2,3,4 → length 4
    // ============================================
    static int longestConsecutive(int[] nums) {
        // your code here
        if(nums.length == 0) return 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums) {
            hashSet.add(i);
        }
        int count = 0;
        int result = 0;
        for(int i : hashSet) {
            if(!hashSet.contains(i - 1)) {
               while(hashSet.contains(i)) {
                    count++;
                    i++;
                }
                result = Math.max(result, count);
            }
            count = 0;
        }
        return result;
    }
}
