package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q330PatchingArray {

    @Test
    public void test() {
        assertThat(minPatches(new int[]{1, 5, 10}, 20)).isEqualTo(2);
        assertThat(minPatches(new int[]{1, 3}, 6)).isEqualTo(1);
        assertThat(minPatches(new int[]{1, 2, 2}, 5)).isEqualTo(0);
    }

    @Test
    public void memory_limit_exceeded() {
        assertThat(minPatches(new int[]{1, 2, 31, 33}, 2147483647)).isEqualTo(29);
    }

    public int minPatches(int[] nums, int n) {
        Set<Integer> set = new HashSet<>();
        addNums(nums, set, 0, 0);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            answer++;
            Set<Integer> next = new HashSet<>();
            set.add(i);
            for (Integer j : set) {
                next.add(i + j);
            }
            set.addAll(next);
        }
        return answer;
    }

    private void addNums(int[] nums, Set<Integer> set, int i, int cur) {
        if (i == nums.length)
            return;
        addNums(nums, set, i + 1, cur);

        set.add(cur + nums[i]);
        addNums(nums, set, i + 1, cur + nums[i]);
    }

}
