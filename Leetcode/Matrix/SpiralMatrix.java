
import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        // [1,2,3,6,9,8,7,4,5]

        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        // [1,2,3,4,8,12,11,10,9,5,6,7]

        System.out.println(spiralOrder(new int[][]{{1}}));
        // [1]
    }

    // ============================================
    // LC 54 — Spiral Matrix
    // ============================================
    // Given an m x n matrix, return all elements in
    // spiral order (clockwise from outside in).
    // ============================================
    static java.util.List<Integer> spiralOrder(int[][] matrix) {
        // your code here
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        while(left < right && top < bottom) {
            // go right
            for(int i = left; i < right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            // go bottom
            for(int i = top; i < bottom; i++) {
                list.add(matrix[i][right - 1]);
            }
            right--;

            if(!(left < right && top < bottom)) break;
            // go left
            for(int i = right - 1; i > left - 1; i--) {
                list.add(matrix[bottom - 1][i]);
            }
            bottom--;
            // go top
            for(int i = bottom - 1; i > top - 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
