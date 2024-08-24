package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q564FindTheClosestPalindrome2 {

    @Test
    public void test() {
        assertThat(nearestPalindromic("12321")).isEqualTo("12221");
        assertThat(nearestPalindromic("1221")).isEqualTo("1111");
        assertThat(nearestPalindromic("12345")).isEqualTo("12321");
        assertThat(nearestPalindromic("123")).isEqualTo("121");
        assertThat(nearestPalindromic("1")).isEqualTo("0");
        assertThat(nearestPalindromic("100")).isEqualTo("99");
        assertThat(nearestPalindromic("11")).isEqualTo("9");
        assertThat(nearestPalindromic("12")).isEqualTo("11");
        assertThat(nearestPalindromic("99")).isEqualTo("101");
        assertThat(nearestPalindromic("999")).isEqualTo("1001");
        assertThat(nearestPalindromic("1111")).isEqualTo("1001");
        assertThat(nearestPalindromic("10001")).isEqualTo("9999");
        assertThat(nearestPalindromic("11011")).isEqualTo("11111");
    }

    @Test
    public void wrong() {
        assertThat(nearestPalindromic("1283")).isEqualTo("1331");
    }

    public String nearestPalindromic(String n) {
        long answer = 0;
        long original = Long.parseLong(n);
        for (long num : findPossibilities(n)) {
            if (num == original)
                continue;
            if (Math.abs(num - original) < Math.abs(answer - original)) {
                answer = num;
            } else if (Math.abs(num - original) == Math.abs(answer - original)) {
                answer = Math.min(answer, num);
            }
        }

        return String.valueOf(answer);
    }

    private List<Long> findPossibilities(String n) {
        int midIndex = n.length() % 2 == 0 ? n.length() / 2 - 1 : n.length() / 2;
        long firstHalf = Long.parseLong(n.substring(0, midIndex + 1));

        List<Long> possibilities = new ArrayList<>();

        possibilities.add(halfToFullPalindrome(firstHalf, n.length() % 2 == 1));
        possibilities.add(halfToFullPalindrome(firstHalf + 1, n.length() % 2 == 1));
        possibilities.add(halfToFullPalindrome(firstHalf - 1, n.length() % 2 == 1));
        possibilities.add((long) Math.pow(10, n.length() - 1) - 1);
        possibilities.add((long) Math.pow(10, n.length()) + 1);
        return possibilities;
    }

    private long halfToFullPalindrome(long left, boolean IsOdd) {
        long res = left;
        if (IsOdd) {
            left = left / 10;
        }
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }

}
