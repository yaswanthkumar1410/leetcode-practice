
import java.util.*;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));  // true
        System.out.println(checkInclusion("ab", "eidboaoo"));  // false
        System.out.println(checkInclusion("adc", "dccda"));     // true
    }

    // ============================================
    // LC 567 — Permutation in String
    // ============================================
    // Given two strings s1 and s2, return true if s2
    // contains a permutation of s1 (any anagram of s1
    // as a substring of s2).
    // ============================================
    static boolean checkInclusion(String s1, String s2) {
        // your code here
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        HashMap<Character, Integer> frequencyMap2 = new HashMap<>();
        for(char c : s1.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int windoSize = 0;
        for(int right = 0; right < s2.length(); right++) {
            frequencyMap2.put(s2.charAt(right), frequencyMap2.getOrDefault(s2.charAt(right), 0) + 1);
            windoSize++;
            while(windoSize > s1.length()) {
                frequencyMap2.put(s2.charAt(left), frequencyMap2.get(s2.charAt(left)) - 1);
                if(frequencyMap2.get(s2.charAt(left)) == 0) frequencyMap2.remove(s2.charAt(left));
                left++;
                windoSize--;
            }
            if(frequencyMap.equals(frequencyMap2)) return true;
        }
        return false;
    }
}
