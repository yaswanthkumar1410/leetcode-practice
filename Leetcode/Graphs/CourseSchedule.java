import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        // Test 1: Can take all courses
        // System.out.println(canFinish(2, new int[][]{{1,0}})); // true
        System.out.println(canFinish(5, new int[][]{{1, 4},{2, 4},{3, 1},{3,2}})); // true

        // Test 2: Cycle → impossible
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}})); // false

        // Test 3: No prerequisites
        System.out.println(canFinish(3, new int[][]{})); // true

        // Test 4: Chain: 0←1←2←3
        System.out.println(canFinish(4, new int[][]{{1,0},{2,1},{3,2}})); // true

        // Test 5: Cycle in larger graph
        System.out.println(canFinish(3, new int[][]{{1,0},{2,1},{0,2}})); // false
    }

    // ============================================
    // GRAPHS — PROBLEM 3: Course Schedule
    // ============================================
    // There are numCourses courses (0 to numCourses-1).
    // prerequisites[i] = [a, b] means you must take
    // course b before course a.
    //
    // Return true if you can finish all courses.
    // Return false if there's a cycle (deadlock).
    //
    // This is cycle detection in a DIRECTED graph.
    //
    // Approach (DFS):
    //   - Build adjacency list from prerequisites
    //   - For each node, DFS to check for cycles
    //   - Track 3 states per node:
    //     0 = unvisited
    //     1 = in current path (visiting)
    //     2 = done (fully processed)
    //   - If you hit a node with state 1 → cycle!
    //
    // Rules:
    //   - O(V + E) time
    // ============================================
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        // your code here
        HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

        for(int arr[] : prerequisites) {
            List<Integer> list = new ArrayList<>();
            if(adjList.containsKey(arr[0])) {
                list = adjList.get(arr[0]);
            }
            list.add(arr[1]);
            adjList.put(arr[0], list);
        }
        for(int i = 0; i < numCourses; i++) {
            if(adjList.containsKey(i)) {
                List<Integer> list = adjList.get(i);
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                if(!dfs(adjList, set, list)) return false;
            }
        }
        return true;
    }

    static boolean dfs(HashMap<Integer, List<Integer>> adjList, HashSet<Integer> set, List<Integer> list) {
        for(int i : list) {
            if(set.contains(i)) return false;
            set.add(i);
            if(!dfs(adjList, set, adjList.getOrDefault(i, new ArrayList<Integer>()))) return false;
            else {set.remove(i); adjList.remove(i);}
        }
        return true;
    }
}
