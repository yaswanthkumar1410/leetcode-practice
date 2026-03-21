
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc"));     // true
    }

    // ============================================
    // LC 392 — Is Subsequence
    // ============================================
    // Given two strings s and t, return true if s is a
    // subsequence of t.
    //
    // A subsequence is formed by deleting some (or no)
    // characters from t without changing the order.
    //
    // O(n) time.
    // ============================================
    static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int left = 0;
        int right = 0;
        while(right < t.length() && left < s.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
        }

        return (left >= s.length());
    }
}
