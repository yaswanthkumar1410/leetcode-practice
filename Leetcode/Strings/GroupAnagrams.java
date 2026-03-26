
import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        // [["bat"],["nat","tan"],["ate","eat","tea"]]

        System.out.println(groupAnagrams(new String[]{""}));
        // [[""]]

        System.out.println(groupAnagrams(new String[]{"a"}));
        // [["a"]]
    }

    // ============================================
    // LC 49 — Group Anagrams
    // ============================================
    // Given an array of strings, group the anagrams
    // together. You can return the answer in any order.
    //
    // An anagram is a word formed by rearranging the
    // letters of another word, using all original letters
    // exactly once.
    // ============================================
    static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<HashMap<Character, Integer>, List<String>> groupedMap = new HashMap<>();
        for(String s : strs) {
            HashMap<Character, Integer> frequencyCount = getFrequencyCount(s);
            List<String> listOfString = new ArrayList<>();
            if(groupedMap.containsKey(frequencyCount)) {
                listOfString = groupedMap.get(frequencyCount);
            }
            listOfString.add(s);
            groupedMap.put(frequencyCount, listOfString);
        }
        List<List<String>> result = new ArrayList<>();
        for(HashMap<Character, Integer> list: groupedMap.keySet()) {
            result.add(groupedMap.get(list));
        }
        return result;
    }

    static HashMap<Character, Integer> getFrequencyCount(String s) {
        HashMap<Character, Integer> frequencyCount = new HashMap<>();
        for(char c : s.toCharArray()) {
            frequencyCount.put(c, frequencyCount.getOrDefault(c, 0) + 1);
        }
        return frequencyCount;
    }
}
