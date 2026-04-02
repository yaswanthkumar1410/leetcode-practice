
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
        // [[1,6],[8,10],[15,18]]

        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{4,5}})));
        // [[1,5]]

        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{0,4}})));
        // [[0,4]]

        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{2,3}})));
        // [[1,4]]
    }

    // ============================================
    // LC 56 — Merge Intervals
    // ============================================
    // Given an array of intervals, merge all overlapping
    // intervals and return the non-overlapping result.
    // ============================================
    static int[][] merge(int[][] intervals) {
        // your code here
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 

        // current interval overlaps with before
        // before becomes -1, -1
        // update current with min and max of prev and curr
        int size = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                intervals[i - 1][0] = -1;
                intervals[i - 1][1] = -1;
            }
        }
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                size++;
            }
        }
        int[][] result = new int[size][2];
        int i = 0;
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                result[i++] = interval;
            }
        }
        return result;
    }
}
