
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));   // 3 ("ace")
        System.out.println(longestCommonSubsequence("abc", "abc"));     // 3
        System.out.println(longestCommonSubsequence("abc", "def"));     // 0
        System.out.println(longestCommonSubsequence("abcba", "abcbcba")); // 5
        System.out.println(longestCommonSubsequence("aa", "a")); // 1
    }

    // ============================================
    // DP — PROBLEM 5: Longest Common Subsequence
    // ============================================
    // Given two strings, return the length of their
    // longest common subsequence.
    //
    // A subsequence is a sequence derived by deleting
    // some characters without changing order.
    // Rules:
    //   - O(m * n) time and space
    // ============================================
    static int longestCommonSubsequence(String text1, String text2) {
        // your code here
        //   0 1 2 3
        //   a c e j
        //0 a 0 0 0 0 
        //1 b 0 0 0 0 
        //2 c 0 0 0 0
        //3 d 1 1 1 0
        //4 e 1 1 1 0
        //5 i 0 0 0 0
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = text1.length() - 1; i >= 0; i--) {
            for(int j = text2.length() - 1; j >=0; j--) {
                
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
