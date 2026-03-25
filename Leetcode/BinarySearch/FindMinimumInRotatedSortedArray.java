
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));       // 1
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2})); // 0
        System.out.println(findMin(new int[]{11,13,15,17}));     // 11
        System.out.println(findMin(new int[]{2,1}));              // 1
    }

    // ============================================
    // LC 153 — Find Minimum in Rotated Sorted Array
    // ============================================
    // A sorted array was rotated at some pivot. Find
    // the minimum element. All elements are unique.
    // O(log n) time.
    // ============================================
    static int findMin(int[] nums) {
        // your code here
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
