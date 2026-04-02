
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
                System.out.println(insert(new int[][] { { 2, 5 }, { 6, 9 } }, new int[] { 0, 1 }));

        System.out.println(insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }));
        // [[1,5],[6,9]]

        System.out.println(
                insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }));
        // [[1,2],[3,10],[12,16]]

        System.out.println(insert(new int[][] {}, new int[] { 5, 7 }));
        // [[5,7]]

        System.out.println(insert(new int[][] { { 1, 5 } }, new int[] { 2, 3 }));
        // [[1,5]]
    }

    // ============================================
    // LC 57 — Insert Interval
    // ============================================
    // Given a sorted list of non-overlapping intervals
    // and a new interval, insert the new interval and
    // merge if necessary. Return the result sorted.
    // ============================================
    static int[][] insert(int[][] intervals, int[] newInterval) {
        // your code here
        List<int[]> list = new ArrayList<>();
        boolean addnewInterval = true;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                addnewInterval = false;
                break;
            } else if (newInterval[0] > intervals[i][1]) {
                list.add(intervals[i]);
            } else {
                newInterval = new int[] { Math.min(newInterval[0], intervals[i][0]),
                        Math.max(newInterval[1], intervals[i][1]) };
            }
        }
        if(addnewInterval)
        list.add(newInterval);

        int[][] result = new int[list.size()][];
        int i = 0;
        for (int[] arr : list) {
            result[i] = new int[2];
            result[i][0] = arr[0];
            result[i][1] = arr[1];
            i++;
        }
        return result;
    }

    static String toString(int[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] a : arr)
            sb.append(Arrays.toString(a)).append(",");
        if (sb.length() > 1)
            sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
