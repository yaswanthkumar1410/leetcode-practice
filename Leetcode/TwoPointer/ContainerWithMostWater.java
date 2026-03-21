
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[]{1,1}));                 // 1
        System.out.println(maxArea(new int[]{4,3,2,1,4}));          // 16
    }

    // ============================================
    // LC 11 — Container With Most Water
    // ============================================
    // Given n lines (heights), find two lines that together
    // with the x-axis form a container that holds the most water.
    //
    // Area = min(height[left], height[right]) * (right - left)
    //
    // O(n) time. Two pointers from ends. Move the shorter one.
    // ============================================
    static int maxArea(int[] height) {
        // your code here
    }
}
