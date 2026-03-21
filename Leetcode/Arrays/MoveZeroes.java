
public class MoveZeroes {

    public static void main(String[] args) {
        int[] a1 = {0,1,0,3,12};
        moveZeroes(a1);
        System.out.println(java.util.Arrays.toString(a1)); // [1,3,12,0,0]

        int[] a2 = {0};
        moveZeroes(a2);
        System.out.println(java.util.Arrays.toString(a2)); // [0]

        int[] a3 = {1,0,0,0,5};
        moveZeroes(a3);
        System.out.println(java.util.Arrays.toString(a3)); // [1,5,0,0,0]
    }

    // ============================================
    // LC 283 — Move Zeroes
    // ============================================
    // Move all 0's to end, keep relative order of
    // non-zero elements. In-place, no copy.
    //
    // Rules: O(n) time
    // ============================================
    static void moveZeroes(int[] nums) {
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        for(int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
