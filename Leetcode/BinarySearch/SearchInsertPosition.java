
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0)); // 0
    }

    // ============================================
    // LC 35 — Search Insert Position
    // ============================================
    // Given a sorted array and a target, return the index
    // if found. If not, return where it would be inserted.
    // ============================================
    static int searchInsert(int[] nums, int target) {
        // your code here
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] ==  target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return right + 1;
    }
}
