
public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));     // 2
        System.out.println(missingNumber(new int[]{0,1}));        // 2
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8
        System.out.println(missingNumber(new int[]{0}));          // 1
    }

    // ============================================
    // LC 268 — Missing Number
    // ============================================
    // Given an array containing n distinct numbers in
    // the range [0, n], return the one number that is
    // missing from the array.
    //
    // O(n) time, O(1) space.
    // ============================================
    static int missingNumber(int[] nums) {
        // your code here
        int length = nums.length;
        int sum = (length * (length + 1) ) / 2;
        for(int i : nums) {
            sum -= i;
        }
        return sum;
    }
}
