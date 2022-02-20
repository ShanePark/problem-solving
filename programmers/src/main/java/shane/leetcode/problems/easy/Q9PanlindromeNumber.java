package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

public class Q9PanlindromeNumber {
    public static void main(String[] args) {
        Assertions.assertEquals(true, isPalindrome(121));
        Assertions.assertEquals(false, isPalindrome(-121));
        Assertions.assertEquals(false, isPalindrome(10));
        Assertions.assertEquals(true, isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 -i))
                return false;
        }
        return true;
    }
}
