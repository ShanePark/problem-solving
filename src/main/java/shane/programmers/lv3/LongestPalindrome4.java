package shane.programmers.lv3;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindrome4 {

    public static void main(String[] args) {
        assertEquals(7, solution("abcdcba"));
        assertEquals(3, solution("abacde"));
        assertEquals(1, solution("abcde"));
    }

    public static int solution(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int j = 0; j + len <= s.length(); j++) {
                if (isPalindrome(s, j, j + len)) {
                    return len;
                }
            }
        }
        return 1;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        int length = end - start;
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i + start) != str.charAt(end - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
