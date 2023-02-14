package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 7 ms, faster than 60.77% of Java online submissions for Sum of Even Numbers After Queries.
 * Memory Usage: 75.2 MB, less than 18.33% of Java online submissions for Sum of Even Numbers After Queries.
 */
@SuppressWarnings("ALL")
public class Q985SumOfEvenNumbersAfterQueries3 {

    @Test
    public void test() {
        assertThat(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, Ps.intArray("[[1,0],[-3,1],[-4,0],[2,3]]"))).containsExactly(8, 6, 2, 4);
        assertThat(sumEvenAfterQueries(new int[]{1}, Ps.intArray("[[4,0]]"))).containsExactly(0);
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int n : nums) {
            if (n % 2 == 0)
                evenSum += n;
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (nums[queries[i][1]] % 2 == 0) {
                evenSum -= nums[queries[i][1]];
            }
            nums[queries[i][1]] += queries[i][0];
            if (nums[queries[i][1]] % 2 == 0) {
                evenSum += nums[queries[i][1]];
            }
            answer[i] = evenSum;
        }
        return answer;
    }
}
