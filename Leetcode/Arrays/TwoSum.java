
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));  // [0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));       // [1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));         // [0,1]
    }

    // ============================================
    // LC 1 — Two Sum
    // ============================================
    // Given an array of integers and a target, return
    // indices of the two numbers that add up to target.
    //
    // Each input has exactly one solution. You may not
    // use the same element twice.
    // ============================================
    static int[] twoSum(int[] nums, int target) {
        // your code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            if(hashMap.containsKey(nums[i])) return new int[] {hashMap.get(nums[i]), i};
            hashMap.put(required, i);
        }
        return new int[]{-1, -1};
    }
}
