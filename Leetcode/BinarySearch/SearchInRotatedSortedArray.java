
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(search(new int[]{1}, 0));               // -1
        System.out.println(search(new int[]{3,1}, 1));             // 1
    }

    // ============================================
    // LC 33 — Search in Rotated Sorted Array
    // ============================================
    // A sorted array was rotated at some pivot. Given
    // the array and a target, return its index or -1.
    // All values are unique. O(log n) time.
    // ============================================
    static int search(int[] nums, int target) {
        // your code here
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]) {
                if(target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
