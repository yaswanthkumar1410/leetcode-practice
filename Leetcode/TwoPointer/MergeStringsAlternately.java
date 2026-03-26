
// LC 1768 — Merge Strings Alternately
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder resultString = new StringBuilder();
        for(int i = 0; i < word1.length() || i < word2.length(); i++) {
            if(i < word1.length()) {
                resultString.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                resultString.append(word2.charAt(i));
            }
        }
        return resultString.toString();
    }
}
