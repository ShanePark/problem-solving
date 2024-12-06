package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 47ms Beats59.78% 
 */
public class Q2554MaximumNumberofIntegerstoChooseFromaRangeI {

    @Test
    public void test() {
        assertThat(maxCount(new int[]{1, 6, 5}, 5, 6)).isEqualTo(2);
        assertThat(maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1)).isEqualTo(0);
        assertThat(maxCount(new int[]{11}, 7, 50)).isEqualTo(7);
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int i : banned) {
            bannedSet.add(i);
        }
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i))
                continue;
            sum += i;
            if (maxSum < sum)
                return cnt;
            cnt++;
        }
        return cnt;
    }

}
