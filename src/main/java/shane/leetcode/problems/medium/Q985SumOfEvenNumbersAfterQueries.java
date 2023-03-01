package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q985SumOfEvenNumbersAfterQueries {

    @Test
    public void test() {
        assertThat(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, Ps.intArray("[[1,0],[-3,1],[-4,0],[2,3]]"))).containsExactly(8, 6, 2, 4);
        assertThat(sumEvenAfterQueries(new int[]{1}, Ps.intArray("[[4,0]]"))).containsExactly(0);
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            nums[query[1]] += query[0];
            for (int num : nums) {
                if (num % 2 == 0)
                    answer[i] += num;
            }
        }
        return answer;
    }
}
