
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));  // 4
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));  // -1
        System.out.println(search(new int[]{5}, 5));                // 0
    }

    // ============================================
    // LC 704 — Binary Search
    // ============================================
    // Given a sorted array and a target, return the
    // index of target. If not found, return -1.
    // ============================================
    static int search(int[] nums, int target) {
        // your code here
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
