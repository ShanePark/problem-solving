package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats96.05%
 */
public class Q2094Finding3DigitEvenNumbers2 {

    @Test
    public void test() {
        assertThat(findEvenNumbers(new int[]{2, 1, 3, 0})).containsExactly(102, 120, 130, 132, 210, 230, 302, 310, 312, 320);
        assertThat(findEvenNumbers(new int[]{2, 2, 8, 8, 2})).containsExactly(222, 228, 282, 288, 822, 828, 882);
        assertThat(findEvenNumbers(new int[]{3, 7, 5})).isEmpty();
    }

    public int[] findEvenNumbers(int[] digits) {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();
        int[] cnt = count(digits);
        dfs(answer, cnt, 0);

        int[] arr = new int[answer.size()];

        int i = 0;
        for (Integer n : answer) {
            arr[i++] = n;
        }
        return arr;
    }

    private int[] count(int[] digits) {
        int[] cnt = new int[10];
        for (int digit : digits) {
            cnt[digit]++;
        }
        return cnt;
    }

    private void dfs(Set<Integer> answer, int[] cnt, int cur) {
        for (int i = 0; i < 10; i++) {
            if (i == 0 && cur == 0)
                continue;
            if (cnt[i] == 0)
                continue;
            if (cur >= 10) {
                if (i % 2 == 0) {
                    answer.add(cur * 10 + i);
                }
                continue;
            }
            cnt[i]--;
            dfs(answer, cnt, cur * 10 + i);
            cnt[i]++;
        }
    }

}
