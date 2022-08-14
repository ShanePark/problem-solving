package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct Smallest Number From DI String.
 * Memory Usage: 42.1 MB, less than 81.82% of Java online submissions for Construct Smallest Number From DI String.
 */
public class Q2375ConstructSmallestNumberFromDIString2 {

    @Test
    public void test() {
        assertThat(smallestNumber("DDID")).isEqualTo("32154");
        assertThat(smallestNumber("DDDIII")).isEqualTo("4321567");
        assertThat(smallestNumber("IIIDIDDD")).isEqualTo("123549876");
        assertThat(smallestNumber("DDD")).isEqualTo("4321");
    }

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            tmp.append((char) ('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                sb.append(tmp.reverse());
                tmp = new StringBuilder();
            }
        }
        return sb.toString();
    }
}
