package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

/**
 * Wrong Answer
 * Details
 * Input
 * "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
 * "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
 * Output
 * "11111111111111111111111111111110"
 * Expected
 * "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
 */
public class Q67AddBinary {

    public static void main(String[] args) {
        Assertions.assertEquals("100", addBinary("11", "1"));
        Assertions.assertEquals("10101", addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(toDec(a) + toDec(b));
    }

    public static int toDec(String bin) {
        int sum = 0;
        for (int i = 0; i < bin.length(); i++) {
            sum += (bin.charAt(bin.length() - 1 - i) - 48) * Math.pow(2, i);
        }
        return sum;
    }

}
