
import java.util.*;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minWindow("a", "a")); // "a"
        System.out.println(minWindow("a", "aa")); // ""
    }

    // ============================================
    // LC 76 — Minimum Window Substring
    // ============================================
    // Given two strings s and t, return the minimum
    // window substring of s that contains ALL characters
    // of t (including duplicates). If no such window
    // exists, return "".
    // ============================================
    static String minWindow(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        int lt = 0;
        int ls = 0;
        String result = "";
        for (char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            lt++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);

            if (freqMap.containsKey(c)) {
                freqMap2.put(c, freqMap2.getOrDefault(c, 0) + 1);
                if (freqMap2.get(c) <= freqMap.get(c)) {
                    ls++;
                }
            }

            while (ls == lt) {
                char lc = s.charAt(left);
                if (result.equals("")) {
                    result = s.substring(left, right + 1);
                }
                if (result.length() > s.substring(left, right + 1).length()) {
                    result = s.substring(left, right + 1);
                }
                if (freqMap2.containsKey(lc)) {
                    if (freqMap2.get(lc).equals(freqMap.get(lc))) {
                        ls--;
                    }
                    freqMap2.put(lc, freqMap2.get(lc) - 1);
                }

                left++;
            }
            right++;
        }
        return result;
    }
}
