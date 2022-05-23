package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 57 / 71 test cases passed.
 */
public class Q474OnesAndZeroes {

    @Test
    public void test() {
        assertThat(findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3)).isEqualTo(3);
        assertThat(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)).isEqualTo(4);
        assertThat(findMaxForm(new String[]{"10", "0", "1"}, 1, 1)).isEqualTo(2);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        Arrays.sort(strs, Comparator.comparingInt(s -> s.length()));

        int cnt = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() > m + n)
                break;

            int count0 = 0;
            int count1 = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            if (count0 <= m && count1 <= n) {
                m -= count0;
                n -= count1;
                cnt++;
            }
        }
        return cnt;
    }
}
