package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 18.50%
 * Memory 42.5 MB Beats 49.21%
 */
public class Q1071GreatestCommonDivisorOfStrings {

    @Test
    public void test() {
        assertThat(gcdOfStrings("ABCDEF", "ABC")).isEqualTo("");
        assertThat(gcdOfStrings("ABCABC", "ABC")).isEqualTo("ABC");
        assertThat(gcdOfStrings("ABABAB", "ABAB")).isEqualTo("AB");
        assertThat(gcdOfStrings("LEET", "CODE")).isEqualTo("");
    }

    @Test
    public void testIsDivisible() {
        assertThat(isDivisible("ABCDEF", 3)).isFalse();
        assertThat(isDivisible("ABCABC", 3)).isTrue();
    }

    public String gcdOfStrings(String str1, String str2) {
        int maxLength = Integer.min(str1.length(), str2.length());
        Set<String> divisors1 = findDivisors(str1, maxLength);
        Set<String> divisors2 = findDivisors(str2, maxLength);
        divisors1.retainAll(divisors2);
        return divisors1.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .findFirst().orElse("");
    }

    private Set<String> findDivisors(String str, int maxLength) {
        Set<String> divisors = new HashSet<>();
        for (int i = 1; i <= maxLength; i++) {
            if (isDivisible(str, i)) {
                divisors.add(str.substring(0, i));
            }
        }
        return divisors;
    }

    private boolean isDivisible(String str, int divLength) {
        int length = str.length();
        if (length % divLength != 0)
            return false;
        int div = length / divLength;
        for (int i = 0; i < divLength; i++) {
            char c = str.charAt(i);
            for (int j = 1; j < div; j++) {
                char c2 = str.charAt(divLength * j + i);
                if (c != c2)
                    return false;
            }
        }
        return true;
    }

}
