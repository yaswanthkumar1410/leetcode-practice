import java.util.HashMap;

public class ReplaceSubstringForBalancedString {

    public static void main(String[] args) {
        System.out.println(balancedString("QWER"));     // 0
        System.out.println(balancedString("QQWE"));     // 1
        System.out.println(balancedString("QQQW"));     // 2
        System.out.println(balancedString("QQQQ"));     // 3
        System.out.println(balancedString("WQWRQQQW")); // 3
    }

    // ============================================
    // LC 1234 — Replace the Substring for Balanced String
    // ============================================
    // A string s of length n is "balanced" if each of
    // the characters 'Q', 'W', 'E', 'R' occurs exactly
    // n/4 times.
    //
    // Given a string s, return the minimum length of the
    // substring that can be replaced to make s balanced.
    //
    // Example:
    //   "QQWE" → replace one 'Q' with 'R' → "RQWE"
    //   Minimum replacement substring length: 1
    //
    //   "QQQW" → need to replace "QQ" with "ER" → length 2
    // ============================================
    static int balancedString(String s) {
        // your code here
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : s.toCharArray()) {
            hm.put(c,hm.getOrDefault(c, 0) + 1);
        }
        int result = s.length();
        int left = 0;
        int right = 0;
        int avg = s.length() / 4;
        if (isValidWindow(hm, avg)) return 0;

        while(right < s.length()) {
            char c = s.charAt(right);
            hm.put(c,hm.get(c) - 1);
            while(isValidWindow(hm, avg) && left <= right) {
                hm.put(s.charAt(left),hm.get(s.charAt(left)) + 1);
                result = Math.min(result, right - left + 1);
                left++;
            }
            right++;
        }
        return result;
    }
    static boolean isValidWindow(HashMap<Character, Integer> hm, int avg) {
        for(char c : hm.keySet()) {
            if(hm.get(c) > avg) return false;
        }
        return true;
    }
}
