package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3480MaximizeSubarraysAfterRemovingOneConflictingPair {

    @Test
    public void test() {
        assertThat(maxSubarrays(4, Ps.intArray("[[2,3],[1,4]]"))).isEqualTo(9L);
        assertThat(maxSubarrays(5, Ps.intArray("[[1,2],[2,5],[3,5]]"))).isEqualTo(12L);
    }

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }
        for (int[] pair : conflictingPairs) {
            right[Math.max(pair[0], pair[1])].add(Math.min(pair[0], pair[1]));
        }

        long answer = 0;
        long[] left = {0, 0};
        long[] bonus = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int l_val : right[r]) {
                if (l_val > left[0]) {
                    left[1] = left[0];
                    left[0] = l_val;
                    continue;
                }
                if (l_val > left[1]) {
                    left[1] = l_val;
                }
            }

            answer += r - left[0];

            if (left[0] > 0) {
                bonus[(int) left[0]] += left[0] - left[1];
            }
        }
        return answer + Arrays.stream(bonus).max().orElse(0);
    }

}
