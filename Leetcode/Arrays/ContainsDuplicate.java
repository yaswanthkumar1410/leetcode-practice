
import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));     // true
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));     // false
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
    }

    // ============================================
    // LC 217 — Contains Duplicate
    // ============================================
    // Given an integer array nums, return true if any
    // value appears at least twice, return false if
    // every element is distinct.
    //
    // Rules: O(n) time
    // ============================================
    static boolean containsDuplicate(int[] nums) {
        // your code here
        HashSet<Integer> uniqueSet = new HashSet<>();
        for(int i : nums) {
            if(uniqueSet.contains(i)) return true;
            uniqueSet.add(i);
        }
        return false;
    }
}
