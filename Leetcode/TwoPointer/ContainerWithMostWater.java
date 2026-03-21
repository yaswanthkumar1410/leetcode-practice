
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[]{1,1}));                 // 1
        System.out.println(maxArea(new int[]{4,3,2,1,4}));          // 16
    }

    // ============================================
    // LC 11 — Container With Most Water
    // ============================================
    // Given n vertical lines at positions 0..n-1 with
    // heights height[i], find two lines that together
    // with the x-axis form a container holding the most water.
    //
    // Return the maximum amount of water the container can store.
    // ============================================
    static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]) left++;
            else right--; 
        }
        return maxWater;
    }
}
