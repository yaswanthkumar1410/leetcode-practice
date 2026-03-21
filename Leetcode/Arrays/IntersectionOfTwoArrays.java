
import java.util.HashSet;


public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));     // [2]
        System.out.println(java.util.Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4}))); // [4,9] or [9,4]
        System.out.println(java.util.Arrays.toString(intersect(new int[]{1,2}, new int[]{3,4})));          // []
    }

    // ============================================
    // LC 349 — Intersection of Two Arrays
    // ============================================
    // Given two integer arrays, return an array of their
    // intersection. Each element in the result must be
    // unique. Order doesn't matter.
    //
    // O(n + m) time.
    // ============================================
    static int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> uniqeSet1 = new HashSet<>();
        HashSet<Integer> uniqeSet2 = new HashSet<>();
        for(int i : nums1) {
            uniqeSet1.add(i);
        }
        for(int i : nums2) {
            if(uniqeSet1.contains(i)){
                uniqeSet2.add(i);
            }
        }
        int[] result = new int[uniqeSet2.size()];
        int k = 0;
        for(int i : uniqeSet2) {
            result[k++] = i;
        }
        return result;
        // your code here
    }
}
