package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime7msBeats87.57%
 */
public class Q2285MaximumTotalImportanceOfRoads2 {

    @Test
    public void test() {
        assertThat(maximumImportance(5, Ps.intArray("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]"))).isEqualTo(43);
        assertThat(maximumImportance(5, Ps.intArray("[[0,3],[2,4],[1,3]]"))).isEqualTo(20);
    }


    public long maximumImportance(int n, int[][] roads) {
        int[] cnt = new int[n];
        for (int[] road : roads) {
            cnt[road[0]]++;
            cnt[road[1]]++;
        }
        Arrays.sort(cnt);
        long answer = 0;
        int j = 1;
        for (int i : cnt) {
            answer += (long) i * j++;
        }
        return answer;
    }

}
