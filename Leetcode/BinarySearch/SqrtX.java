
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));   // 2
        System.out.println(mySqrt(8));   // 2
        System.out.println(mySqrt(2147395599));   // 0
        System.out.println(mySqrt(1));   // 1
    }

    // ============================================
    // LC 69 — Sqrt(x)
    // ============================================
    // Given a non-negative integer x, return the square
    // root of x rounded down. Do NOT use Math.sqrt().
    // ============================================
    static int mySqrt(int x) {
        // your code here
        long left = 0;
        long right = x;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid * mid == x) return (int) mid;
            if(mid * mid > x) right = mid - 1;
            else left = mid + 1;
        }
        return (int) right;
    }
}
