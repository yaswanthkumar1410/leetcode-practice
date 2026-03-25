
import java.util.*;

public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(findAnagrams("abab", "ab"));         // [0, 1, 2]
        System.out.println(findAnagrams("aaaa", "aa"));         // [0, 1, 2]
    }

    // ============================================
    // LC 438 — Find All Anagrams in a String
    // ============================================
    // Given a string s and a string p, find all start
    // indices of p's anagrams in s.
    // ============================================
    static List<Integer> findAnagrams(String s, String p) {
        // your code here
HashMap<Character, Integer> freqCount1 = new HashMap<>();
        HashMap<Character, Integer> freqCount2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(char c : p.toCharArray()) {
            freqCount1.put(c, freqCount1.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqCount2.put(c, freqCount2.getOrDefault(c, 0) + 1);
            while(right - left + 1 > p.length()) {
                freqCount2.put(s.charAt(left), freqCount2.get(s.charAt(left)) - 1);
                if(freqCount2.get(s.charAt(left)) == 0) freqCount2.remove(s.charAt(left));
                left++;
            }
            if(freqCount1.equals(freqCount2)) list.add(left);
        }
        return list;
    }
}
