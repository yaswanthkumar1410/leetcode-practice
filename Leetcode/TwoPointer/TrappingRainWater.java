
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(trap(new int[]{4,2,0,3,2,5}));              // 9
        System.out.println(trap(new int[]{1,1}));                       // 0
        System.out.println(trap(new int[]{3,0,0,2,0,4}));             // 10
    }

    // ============================================
    // LC 42 — Trapping Rain Water
    // ============================================
    // Given n non-negative integers representing an
    // elevation map where the width of each bar is 1,
    // compute how much water it can trap after raining.
    // ============================================
    static int trap(int[] height) {
        // your code here
        int lengthOfHeight = height.length;
        int[] rightMaxArray = new int[lengthOfHeight];
        int maxValue = Integer.MIN_VALUE;
        for(int i = lengthOfHeight - 1 ; i >=0 ; i--) {
            rightMaxArray[i] = Math.max(maxValue, height[i]);
            maxValue = rightMaxArray[i];
        }
        int sum = 0;
        maxValue = Integer.MIN_VALUE;
        for(int i = 0 ; i < lengthOfHeight; i++) {
            maxValue = Math.max(maxValue, height[i]);
            sum += Math.min(maxValue, rightMaxArray[i]) -  height[i];
        }
        return sum;
    }
}
