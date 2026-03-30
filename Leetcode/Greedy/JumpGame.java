
public class JumpGame {

    public static void main(String[] args) {
                                         //  0,1,2,3,4 
        System.out.println(canJump(new int[]{2,3,1,1,4}));   // true
        System.out.println(canJump(new int[]{3,2,1,0,4}));   // false
        System.out.println(canJump(new int[]{0}));             // true
        System.out.println(canJump(new int[]{2,0,0}));         // true
    }

    // ============================================
    // LC 55 — Jump Game
    // ============================================
    // Given an array where each element is the max jump
    // length from that position, determine if you can
    // reach the last index starting from index 0.
    // ============================================
    static boolean canJump(int[] nums) {
        // your code here
        int farthest = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

 }
