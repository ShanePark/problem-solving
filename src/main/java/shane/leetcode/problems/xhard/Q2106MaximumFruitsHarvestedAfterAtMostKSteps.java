package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2106MaximumFruitsHarvestedAfterAtMostKSteps {

    @Test
    public void test() {
        assertThat(maxTotalFruits(Ps.intArray("[[2,8],[6,3],[8,6]]"), 5, 4)).isEqualTo(9);
        assertThat(maxTotalFruits(Ps.intArray("[[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]"), 5, 4)).isEqualTo(14);
        assertThat(maxTotalFruits(Ps.intArray("[[0,3],[6,4],[8,5]]"), 3, 2)).isEqualTo(0);
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int sum = 0;
        int answer = 0;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while (left <= right && step(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public int step(int[][] fruits, int startPos, int left, int right) {
        return Math.min(Math.abs(startPos - fruits[right][0]), Math.abs(startPos - fruits[left][0])) + fruits[right][0] - fruits[left][0];
    }

}
