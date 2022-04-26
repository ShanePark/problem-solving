package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

public class Q231PowerOfTwo {

    public static void main(String[] args) {
        Assertions.assertEquals(true, isPowerOfTwo(1));
        Assertions.assertEquals(false, isPowerOfTwo(-2147483648));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return Integer.bitCount(n) == 1;
    }
}
