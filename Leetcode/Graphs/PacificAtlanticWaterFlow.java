
import java.util.*;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        // Test 1:
        // Pacific touches top and left edges
        // Atlantic touches bottom and right edges
        int[][] grid1 = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        System.out.println(pacificAtlantic(grid1));
        // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        // Test 2: single cell
        System.out.println(pacificAtlantic(new int[][]{{1}}));
        // [[0,0]]

        // Test 3:
        System.out.println(pacificAtlantic(new int[][]{{1,1},{1,1}}));
        // [[0,0],[0,1],[1,0],[1,1]]
    }

    // ============================================
    // GRAPHS — PROBLEM 4: Pacific Atlantic Water Flow
    // ============================================
    // Water flows from a cell to neighbor if neighbor
    // height is LESS THAN OR EQUAL.
    //
    // Pacific ocean = top + left edges
    // Atlantic ocean = bottom + right edges
    //
    // Return all cells where water can reach BOTH oceans.
    //
    // Approach (reverse — flow uphill from oceans):
    //   1. DFS from Pacific edges → mark reachable cells
    //   2. DFS from Atlantic edges → mark reachable cells
    //   3. Cells in BOTH → answer
    //
    // The DFS goes UPHILL (neighbor >= current) because
    // we're going backwards from ocean to source.
    //
    // Rules:
    //   - O(m * n) time
    // ============================================
    static List<List<Integer>> pacificAtlantic(int[][] heights) {
        // your code here

        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> resultList = new ArrayList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int j = 0; j < cols; j++) dfs(pacific, heights, 0, j);
        for (int i = 0; i < rows; i++) dfs(pacific, heights, i, 0);
        for (int j = 0; j < cols; j++) dfs(atlantic, heights, rows-1, j);
        for (int i = 0; i < rows; i++) dfs(atlantic, heights, i, cols-1);

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j] ) {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    resultList.add(coordinates);
                }
            }
        }
        return resultList;
    }

    static void dfs(boolean[][] visited, int[][] heights, int i, int j) {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(i + 1 < heights.length && heights[i + 1][j] >= heights[i][j])
            dfs(visited, heights, i + 1, j);
        if(j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j])
            dfs(visited, heights, i, j + 1);
        if(i - 1 >=0 && heights[i - 1][j] >= heights[i][j])
            dfs(visited, heights, i - 1, j);
        if(j - 1 >=0 && heights[i][j - 1] >= heights[i][j])
            dfs(visited, heights, i, j - 1);
    }
}
