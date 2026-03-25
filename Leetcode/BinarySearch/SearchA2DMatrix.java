
public class SearchA2DMatrix {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));  // true
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13)); // false
        System.out.println(searchMatrix(new int[][]{{1}}, 1));                                     // true
    }

    // ============================================
    // LC 74 — Search a 2D Matrix
    // ============================================
    // Each row is sorted. First element of each row is
    // greater than last element of previous row.
    // Given a target, return true if it exists.
    // O(log(m*n)) time.
    // ============================================
    static boolean searchMatrix(int[][] matrix, int target) {
        // your code here
        int leftArray = 0;
        int rightArray = matrix.length - 1;

        while(leftArray <= rightArray) {
            int midArrayIndex = leftArray + (rightArray - leftArray) / 2;
            int[] midArray = matrix[midArrayIndex];
            if(midArray[0] <= target && midArray[midArray.length - 1] >= target) {
                int left = 0;
                int right = midArray.length - 1;
                while(left <= right) {
                    int midIndex = left + (right - left) / 2;
                    if(target == midArray[midIndex]) return true;
                    if(target < midArray[midIndex]) right = midIndex - 1;
                    else left = midIndex + 1;
                }
            }
            if(midArray[0] > target) {
                rightArray = midArrayIndex - 1;
            } else {
                leftArray = midArrayIndex + 1;
            }
            
        }
        return false;
    }
}
