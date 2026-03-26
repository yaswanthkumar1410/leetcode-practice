
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

        HashMap<String, List<String>> groupedMap = new HashMap<>();
        for(String s : strs) {
            List<String> listOfString = new ArrayList<>();
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedString = Arrays.toString(c);
            if(groupedMap.containsKey(sortedString)) {
                listOfString = groupedMap.get(sortedString);
            }
            listOfString.add(s);
            groupedMap.put(sortedString, listOfString);
        }
        List<List<String>> result = new ArrayList<>();
        for(String list: groupedMap.keySet()) {
            result.add(groupedMap.get(list));
        }
        return result;
    }
}
