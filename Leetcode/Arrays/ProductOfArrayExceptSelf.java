
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));   // [24,12,8,6]
        System.out.println(java.util.Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3}))); // [0,0,9,0,0]
        System.out.println(java.util.Arrays.toString(productExceptSelf(new int[]{2,3})));         // [3,2]
    }

    // ============================================
    // LC 238 — Product of Array Except Self
    // ============================================
    // Given an integer array nums, return an array where
    // each element is the product of all elements EXCEPT
    // the one at that index.
    //
    // You must NOT use division.
    // O(n) time. Try O(1) extra space (output array doesn't count).
    //
    // ============================================
    static int[] productExceptSelf(int[] nums) {
        // your code here
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for(int i = nums.length - 1; i >=0; i--) {
            output[i] = rightProduct * output[i];
            rightProduct = rightProduct * nums[i];
        }
        return output;
    }
}
