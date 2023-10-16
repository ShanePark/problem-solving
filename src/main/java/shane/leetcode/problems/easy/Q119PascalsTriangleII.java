package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 79.70%of users with Java
 * Memory Details 39.76MB Beats 93.76%of users with Java
 */
public class Q119PascalsTriangleII {

    @Test
    public void test() {
        assertThat(getRow(3)).containsExactly(1, 3, 3, 1);
        assertThat(getRow(0)).containsExactly(1);
        assertThat(getRow(1)).containsExactly(1, 1);
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> before = list.get(i - 1);
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 0; j < before.size() - 1; j++) {
                next.add(before.get(j) + before.get(j + 1));
            }
            next.add(1);
            list.add(next);
        }
        return list.get(rowIndex);
    }

}
