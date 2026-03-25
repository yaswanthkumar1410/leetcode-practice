
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));          // 1
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));       // 1
        System.out.println(peakIndexInMountainArray(new int[]{0,10,5,2}));      // 1
        System.out.println(peakIndexInMountainArray(new int[]{0,1,2,3,2,1})); // 3
    }

    // ============================================
    // LC 852 — Peak Index in a Mountain Array
    // ============================================
    // A mountain array goes up then down. There's exactly
    // one peak. Return the index of the peak element.
    // O(log n) time.
    // ============================================
    static int peakIndexInMountainArray(int[] nums) {
        // your code here
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
