
public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));       // "blue is sky the"
        System.out.println(reverseWords("  hello world  "));       // "world hello"
        System.out.println(reverseWords("a good   example"));      // "example good a"
    }

    // ============================================
    // LC 151 — Reverse Words in a String
    // ============================================
    // Given a string s, reverse the order of the words.
    // A word is a sequence of non-space characters.
    // Remove leading/trailing spaces and reduce multiple
    // spaces between words to a single space.
    //
    // O(n) time.
    // ============================================
    static String reverseWords(String s) {
        // your code here
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = words.length - 1; i >=0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }
}
