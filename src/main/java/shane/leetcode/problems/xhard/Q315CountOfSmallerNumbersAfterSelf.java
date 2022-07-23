package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Must be TLE
 */
public class Q315CountOfSmallerNumbersAfterSelf {

    @Test
    public void test() {
        assertThat(countSmaller(new int[]{5, 2, 6, 1})).containsExactly(2, 1, 1, 0);
        assertThat(countSmaller(new int[]{-1})).containsExactly(0);
        assertThat(countSmaller(new int[]{-1, -1})).containsExactly(0, 0);
    }

    /**
     * 1 sec 295 ms
     */
    @Test
    public void test2() {
        int[] arr = new int[100000];
        assertThat(countSmaller(arr)).hasSize(100000);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int cnt = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < n) {
                    cnt++;
                }
            }
            answer.add(cnt);
        }
        return answer;
    }

}
