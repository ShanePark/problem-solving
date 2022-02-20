package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

public class Q1009ComplementOfBase10Integer {

    public static void main(String[] args) {
        Assertions.assertEquals(2, bitwiseComplement(5));
        Assertions.assertEquals(0, bitwiseComplement(7));
        Assertions.assertEquals(5, bitwiseComplement(10));
    }

    public static int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        int length = str.length();
        int sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum += Math.pow(2, length - 1 - i) * (49 - str.charAt(i));
        }
        return sum;
    }
}
