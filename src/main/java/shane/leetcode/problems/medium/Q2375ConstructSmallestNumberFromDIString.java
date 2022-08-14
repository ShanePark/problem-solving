package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct Smallest Number From DI String.
 * Memory Usage: 42.2 MB, less than 27.27% of Java online submissions for Construct Smallest Number From DI String.
 */
public class Q2375ConstructSmallestNumberFromDIString {

    @Test
    public void test() {
        assertThat(smallestNumber("DDID")).isEqualTo("32154");
        assertThat(smallestNumber("DDDIII")).isEqualTo("4321567");
        assertThat(smallestNumber("IIIDIDDD")).isEqualTo("123549876");
        assertThat(smallestNumber("DDD")).isEqualTo("4321");
    }

    public String smallestNumber(String pattern) {
        int min = 1;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            int dCount = 0;
            int j = i;
            while (j < pattern.length() && pattern.charAt(j) == 'D') {
                dCount++;
                j++;
            }
            int num;
            if (dCount > 0) {
                num = min + dCount;
                for (int k = 0; k < dCount; k++) {
                    while (set.contains(num)) {
                        num++;
                    }
                }
                set.add(num);
                sb.append(num);
                if (min == num) {
                    min++;
                }
            } else {
                num = min;
                while (!set.add(num)) {
                }
                sb.append(num);
                while (set.contains(num)) {
                    min = ++num;
                }
            }
        }
        while (!set.add(min)) {
            min++;
        }
        sb.append(min);
        return sb.toString();
    }
}
