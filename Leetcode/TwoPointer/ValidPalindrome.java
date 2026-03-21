
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                      // false
        System.out.println(isPalindrome(" "));                               // true
    }

    // ============================================
    // LC 125 — Valid Palindrome
    // ============================================
    // Given a string s, return true if it is a palindrome.
    // Consider only alphanumeric characters and ignore cases.
    //
    // O(n) time, O(1) space.
    // ============================================
    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if(!Character.isLetterOrDigit(rightChar)){
                right--;
            } else {
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
