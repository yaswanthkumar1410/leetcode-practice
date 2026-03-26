import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));    // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
        System.out.println(characterReplacement("AAAA", 0));    // 4
        System.out.println(characterReplacement("ABCDE", 1));   // 2
    }

    // ============================================
    // LC 424 — Longest Repeating Character Replacement
    // ============================================
    // Given a string s and an integer k, you can replace
    // at most k characters. Return the length of the
    // longest substring containing all the same letter
    // after at most k replacements.
    // ============================================
    static int characterReplacement(String s, int k) {
        // your code here
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxfreq = 0;
        int result = 0;
        while(right < s.length()){
            hashMap.put(s.charAt(right), hashMap.getOrDefault(s.charAt(right), 0) + 1);
            maxfreq = Math.max(maxfreq, hashMap.get(s.charAt(right)));
            while(right - left + 1 - maxfreq > k) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                maxfreq = Math.max(maxfreq, hashMap.get(s.charAt(right)));
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
