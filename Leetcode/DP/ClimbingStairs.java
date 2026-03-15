
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));  // 2
        System.out.println(climbStairs(3));  // 3
        System.out.println(climbStairs(4));  // 5
        System.out.println(climbStairs(5));  // 8
    }

    // ============================================
    // DP — PROBLEM 1: Climbing Stairs
    // ============================================
    // You're climbing a staircase with n steps.
    // Each time you can climb 1 or 2 steps.
    // How many DISTINCT ways can you reach the top?
    //
    // Example: n=3
    //   1+1+1
    //   1+2
    //   2+1
    //   → 3 ways
    //
    // Think about it:
    //   To reach step n, you came from step n-1 (took 1 step)
    //   OR from step n-2 (took 2 steps).
    //   So: ways(n) = ways(n-1) + ways(n-2)
    //
    //   Base cases: ways(1) = 1, ways(2) = 2
    //
    // Rules:
    //   - O(n) time
    // ============================================
    static int climbStairs(int n) {
        // your code here
        if(n <= 2) return n;
        int temp1 = 1; // 2 // 3
        int temp2 = 2; //3  // 5
        int temp3 = temp1 + temp2; // 5 // 8

        for(int i = 4; i <= n; i++) {
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp1 + temp2;
        }
        return temp3;
    }
}
