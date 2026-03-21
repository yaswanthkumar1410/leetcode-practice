
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));             // 3
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));     // 2
        System.out.println(majorityElement(new int[]{1}));                   // 1
    }

    // ============================================
    // LC 169 — Majority Element
    // ============================================
    // Given an array nums, return the element that appears
    // more than n/2 times. Guaranteed to exist.
    //
    // O(n) time, O(1) space.
    // Think: Boyer-Moore Voting Algorithm.
    // ============================================
    static int majorityElement(int[] nums) {
        // your code here
        int majorityElement = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != majorityElement && count > 0) {
                count--;
            } else if(nums[i] != majorityElement && count == 0) {
                majorityElement = nums[i];
                count++;
            } else {
                count++;
            }
        }
        return majorityElement;
    }
}
