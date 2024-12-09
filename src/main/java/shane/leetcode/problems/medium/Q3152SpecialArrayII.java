package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime41msBeats10.18%
 */
public class Q3152SpecialArrayII {

    @Test
    public void test() {
        assertThat(isArraySpecial(new int[]{4, 3, 1, 6}, Ps.intArray("[[0,2],[2,3]]"))).containsExactly(false, true);
        assertThat(isArraySpecial(new int[]{3, 4, 1, 2, 6}, Ps.intArray("[[0,4]]"))).containsExactly(false);
        assertThat(isArraySpecial(new int[]{1, 2, 4, 5}, Ps.intArray("[[0,1],[1,2],[2,3]]"))).containsExactly(true, false, true);
        assertThat(isArraySpecial(new int[]{2, 4, 6, 8}, Ps.intArray("[[0,1],[1,2],[2,3]]"))).containsExactly(false, false, false);
        assertThat(isArraySpecial(new int[]{1}, Ps.intArray("[[0,0]]"))).containsExactly(true);
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        TreeMap<Integer, Integer> specialMap = new TreeMap<>();
        int before = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                specialMap.put(before, i - 1);
                before = i;
            }
        }
        specialMap.put(before, nums.length - 1);

        for (int i = 0; i < answer.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            Map.Entry<Integer, Integer> floor = specialMap.floorEntry(start);
            if (end <= floor.getValue()) {
                answer[i] = true;
            }
        }
        return answer;
    }

}
