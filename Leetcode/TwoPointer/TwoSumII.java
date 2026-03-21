
public class TwoSumII {

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));  // [1,2]
        System.out.println(java.util.Arrays.toString(twoSum(new int[]{2,3,4}, 6)));       // [1,3]
        System.out.println(java.util.Arrays.toString(twoSum(new int[]{-1,0}, -1)));       // [1,2]
    }

    // ============================================
    // LC 167 — Two Sum II (Input Array Is Sorted)
    // ============================================
    // Given a 1-indexed sorted array, find two numbers
    // that add up to target. Return their 1-indexed positions.
    //
    // Exactly one solution exists. Can't use the same element twice.
    //
    // O(n) time, O(1) space. Two pointers from ends.
    // ============================================
    static int[] twoSum(int[] numbers, int target) {
        // your code here
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[right] + numbers[left];
            if(sum == target) return new int[]{left + 1, right + 1};
            if(sum > target) 
                right--;
            else left++;
        }
        return new int[]{};
    }
}
