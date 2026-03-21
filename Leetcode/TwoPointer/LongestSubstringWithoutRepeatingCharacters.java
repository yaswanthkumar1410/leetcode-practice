import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring(""));          // 0
    }

    // ============================================
    // LC 3 — Longest Substring Without Repeating Characters
    // ============================================
    // Given a string s, find the length of the longest
    // substring without repeating characters.
    // ============================================
    static int lengthOfLongestSubstring(String s) {
        // your code here
        if(s.length() <= 1) return s.length();
        int maxSubStringLength = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int startOfString = 0;
        for(int i = 0; i < s.length(); i++) {
            if(hashMap.containsKey(s.charAt(i))) {
                while ( startOfString < hashMap.get(s.charAt(i))) {
                    hashMap.remove(s.charAt(startOfString));
                    startOfString++;
                }
                hashMap.remove(s.charAt(startOfString));
                startOfString++;
                i--;
            } else {
                hashMap.put(s.charAt(i), i);
                maxSubStringLength = Math.max(maxSubStringLength, i - startOfString);
            }
        }
        return maxSubStringLength + 1;
    }
}
