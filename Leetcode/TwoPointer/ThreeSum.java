
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{0,1,1}));            // []
        System.out.println(threeSum(new int[]{0,0,0}));            // [[0,0,0]]
    }

    // ============================================
    // LC 15 — 3Sum
    // ============================================
    // Given an integer array nums, return all triplets
    // [nums[i], nums[j], nums[k]] such that:
    //   i != j, i != k, j != k
    //   nums[i] + nums[j] + nums[k] == 0
    //
    // The solution set must not contain duplicate triplets.
    // ============================================
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                int target = -1 * (nums[i]);
                if(sum == target) {
                    hashSet.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        for(List<Integer> a : hashSet){
            result.add(a);
        }
        return result;
    }
}
