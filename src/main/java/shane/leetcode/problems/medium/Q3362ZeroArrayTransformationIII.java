package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3362ZeroArrayTransformationIII {

    @Test
    public void test() {
        assertThat(maxRemoval(new int[]{2, 0, 2}, Ps.intArray("[[0,2],[0,2],[1,1]]"))).isEqualTo(1);
        assertThat(maxRemoval(new int[]{1, 1, 1, 1}, Ps.intArray("[[1,3],[0,2],[1,3],[1,2]]"))).isEqualTo(2);
        assertThat(maxRemoval(new int[]{1, 2, 3, 4}, Ps.intArray("[[0,3]]"))).isEqualTo(-1);
    }

    @Test
    public void test2() {
        assertThat(maxRemoval(new int[]{0, 0, 3}, Ps.intArray("[[0,2],[1,1],[0,0],[0,0]]"))).isEqualTo(-1);
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

        int[] prefixSum = new int[nums.length + 1];
        int cur = 0;

        int queryIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += prefixSum[i];
            while (queryIndex < queries.length && queries[queryIndex][0] <= i) {
                maxQ.offer(queries[queryIndex++][1]);
            }
            while (cur < nums[i] && !maxQ.isEmpty() && i <= maxQ.peek()) {
                cur++;
                prefixSum[maxQ.poll() + 1]--;
            }
            if (cur < nums[i])
                return -1;
        }
        return maxQ.size();
    }

}
