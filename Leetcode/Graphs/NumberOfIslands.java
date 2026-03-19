import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        // Test 1:
        // 1 1 0
        // 1 1 0
        // 0 0 1
        // Two islands: top-left block of 1s, bottom-right single 1
        System.out.println(numIslands(new char[][]{
            {'1','1','0'},
            {'1','1','0'},
            {'0','0','1'}
        })); // 2

        // Test 2:
        // 1 1 0 0 0
        // 1 1 0 0 0
        // 0 0 1 0 0
        // 0 0 0 1 1
        System.out.println(numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        })); // 3

        // Test 3: all water
        System.out.println(numIslands(new char[][]{
            {'0','0'},
            {'0','0'}
        })); // 0

        // Test 4: all land
        System.out.println(numIslands(new char[][]{
            {'1','1'},
            {'1','1'}
        })); // 1

        System.out.println(numIslands(new char[][] {
            {'1','1','1'}, 
            {'0','1','0'}, 
            {'1','1','1'}
        }));
    }

    // ============================================
    // GRAPHS — PROBLEM 2: Number of Islands
    // ============================================
    // Given a 2D grid of '1' (land) and '0' (water),
    // count the number of islands.
    //
    // An island is a group of '1's connected horizontally
    // or vertically (not diagonally).
    //
    // This is the same pattern as Connected Components:
    //   - Loop through every cell
    //   - If it's '1' and not visited → DFS to mark
    //     all connected land, count++
    //
    // Instead of an adjacency list, neighbors are
    // up/down/left/right in the grid.
    //
    // Rules:
    //   - O(rows * cols) time
    // ============================================
    static int numIslands(char[][] grid) {
        int numOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    goVisitTheWholeIsland(grid, visited, i, j);
                    numOfIslands += 1;
                }
            }
        }
        return numOfIslands;
    }

    static void goVisitTheWholeIsland(char[][] grid, boolean[][] visited, int i, int j) {
        // check leftIndex, rightIndex, bottomIndex, topIndex if both have 1, check diagnol
        // if they have 1 repeat the process
        Queue<Integer> toVisit = new ArrayDeque<>(); 
        if(i < grid.length && j + 1 < grid[i].length && !visited[i][j + 1] && grid[i][j+1] == '1') {
            toVisit.add(i);
            toVisit.add(j + 1);
            visited[i][j + 1] = true;
        }
        if(i + 1 < grid.length && j < grid[i].length && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            toVisit.add(i + 1);
            toVisit.add(j);
            visited[i + 1][j] = true;
        }
        if(i < grid.length && j - 1 >=0 && j - 1 < grid[i].length && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            toVisit.add(i);
            toVisit.add(j - 1);
            visited[i][j - 1] = true;
        }
        if(i - 1 >=0 && i - 1 < grid.length && j < grid[i].length && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            toVisit.add(i - 1);
            toVisit.add(j);
            visited[i - 1][j] = true;
        }

        while(!toVisit.isEmpty()) {
            goVisitTheWholeIsland(grid, visited, toVisit.poll(), toVisit.poll());
        }
    }
}
