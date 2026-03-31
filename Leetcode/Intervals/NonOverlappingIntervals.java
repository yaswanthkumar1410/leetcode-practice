
import java.util.Arrays;



public class NonOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}})); // 1
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));       // 2
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));             // 0
        System.out.println(eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}})); // 2
    }

    // ============================================
    // LC 435 — Non-overlapping Intervals
    // ============================================
    // Given an array of intervals where intervals[i] = [start, end],
    // return the minimum number of intervals you need to remove
    // to make the rest non-overlapping.
    //
    // Example: [[1,2],[2,3],[3,4],[1,3]]
    //   Remove [1,3] → remaining [[1,2],[2,3],[3,4]] don't overlap
    //   Answer: 1
    // ============================================
    static int eraseOverlapIntervals(int[][] intervals) {
        int remove = 0;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {  
            if(intervals[i][0] < prev) {
                remove++;
                prev = Math.min(prev, intervals[i][1]);
            } else {
                prev = intervals[i][1];
            }
        }
        return remove;
    }
}
