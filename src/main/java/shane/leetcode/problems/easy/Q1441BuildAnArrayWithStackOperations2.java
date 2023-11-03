package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 41.80MB Beats 62.80%of users with Java
 */
public class Q1441BuildAnArrayWithStackOperations2 {

    @Test
    public void test() {
        assertThat(buildArray(new int[]{1, 3}, 3)).containsExactly("Push", "Push", "Pop", "Push");
        assertThat(buildArray(new int[]{1, 2, 3}, 3)).containsExactly("Push", "Push", "Push");
        assertThat(buildArray(new int[]{1, 2}, 4)).containsExactly("Push", "Push");
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int cur = 1;
        for (int i : target) {
            while (cur < i) {
                list.add("Push");
                list.add("Pop");
                cur++;
            }
            if (cur == i) {
                list.add("Push");
            }
            cur++;
        }
        return list;
    }

}
