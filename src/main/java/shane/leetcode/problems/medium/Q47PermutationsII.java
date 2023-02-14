package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 147 ms, faster than 9.83% of Java online submissions for Permutations II.
 * Memory Usage: 57 MB, less than 6.30% of Java online submissions for Permutations II.
 */
@SuppressWarnings("ALL")
public class Q47PermutationsII {

    @Test
    public void test() {
        assertThat(permuteUnique(new int[]{2, 2, 1, 1})).containsExactlyInAnyOrderElementsOf(Ps.intList("[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]"));
        assertThat(permuteUnique(new int[]{1, 1, 2})).containsExactlyInAnyOrderElementsOf(Ps.intList("[[1, 1, 2], [2, 1, 1], [1, 2, 1]]"));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[nums.length]);
        for (int i = 0; i < nums.length; i++) {
            Queue<Integer[]> temp = new LinkedList<>();
            for (Integer[] poll : q) {
                for (int j = 0; j < nums.length; j++) {
                    if (poll[j] != null)
                        continue;
                    poll[j] = nums[i];
                    temp.add(Arrays.copyOf(poll, poll.length));
                    poll[j] = null;
                }
            }
            q = temp;
        }

        Set<List<Integer>> set = new HashSet<>();
        for (Integer[] arr : q) {
            set.add(Arrays.asList(arr));
        }

        return new ArrayList<>(set);
    }

}
