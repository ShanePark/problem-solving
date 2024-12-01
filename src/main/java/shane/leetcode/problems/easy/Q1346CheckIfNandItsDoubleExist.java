package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats98.04%
 */
public class Q1346CheckIfNandItsDoubleExist {

    @Test
    public void test() {
        assertThat(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8})).isFalse();
        assertThat(checkIfExist(new int[]{10, 2, 5, 3})).isTrue();
        assertThat(checkIfExist(new int[]{7, 1, 14, 11})).isTrue();
        assertThat(checkIfExist(new int[]{0, 0})).isTrue();
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (i == 0) {
                if (set.contains(0))
                    return true;
                set.add(i);
                continue;
            }
            set.add(i);
            if (set.contains(i * 2))
                return true;
            if (i % 2 == 1)
                continue;
            if (set.contains(i / 2))
                return true;
        }
        return false;
    }

}
