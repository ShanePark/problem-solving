package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 37 ms, faster than 5.47% of Java online submissions for Sum of Even Numbers After Queries.
 * Memory Usage: 74.3 MB, less than 22.19% of Java online submissions for Sum of Even Numbers After Queries.
 */
@SuppressWarnings("ALL")
public class Q985SumOfEvenNumbersAfterQueries2 {

    @Test
    public void test() {
        assertThat(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, Ps.intArray("[[1,0],[-3,1],[-4,0],[2,3]]"))).containsExactly(8, 6, 2, 4);
        assertThat(sumEvenAfterQueries(new int[]{1}, Ps.intArray("[[4,0]]"))).containsExactly(0);
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int evenSum = Arrays.stream(nums)
                .filter(i -> i % 2 == 0)
                .sum();

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int beforeNumber = nums[query[1]];
            int addNumber = query[0];

            boolean isBeforeNumEven = beforeNumber % 2 == 0;
            boolean isAddNumEven = addNumber % 2 == 0;

            if (isBeforeNumEven && isAddNumEven) {
                evenSum += addNumber;
            } else if (isBeforeNumEven && !isAddNumEven) {
                evenSum -= beforeNumber;
            } else if (!isBeforeNumEven && !isAddNumEven) {
                evenSum += (beforeNumber + addNumber);
            }
            nums[query[1]] += addNumber;
            answer[i] = evenSum;
        }
        return answer;
    }
}
