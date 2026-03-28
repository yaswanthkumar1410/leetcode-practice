
public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));     // 6
        System.out.println(maxProduct(new int[]{-2,0,-1}));       // 0
        System.out.println(maxProduct(new int[]{-2,3,-4}));       // 24
        System.out.println(maxProduct(new int[]{-2}));             // -2
    }

    // ============================================
    // LC 152 — Maximum Product Subarray
    // ============================================
    // Given an integer array, find a subarray that has
    // the largest product, and return that product.
    //
    // A subarray is a contiguous non-empty sequence.
    // ============================================
    static int maxProduct(int[] nums) {
        // your code here
        int result = Integer.MIN_VALUE;
        int currentMax = 1;
        int currentMin = 1;
        for(int n : nums) {
            int temp = currentMax * n;
            currentMax = Math.max(n, Math.max(temp, currentMin * n));
            currentMin = Math.min(n, Math.min(temp, currentMin * n));
            result = Math.max(currentMax, result);
        }
        return result;
    }
}
