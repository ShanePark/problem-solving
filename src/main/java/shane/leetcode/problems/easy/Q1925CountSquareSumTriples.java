package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 62 ms, faster than 49.39% of Java online submissions for Count Square Sum Triples.
 * Memory Usage: 41.6 MB, less than 27.05% of Java online submissions for Count Square Sum Triples.
 */
public class Q1925CountSquareSumTriples {

    @Test
    public void test() {
        assertThat(countTriples(5)).isEqualTo(2);
        assertThat(countTriples(10)).isEqualTo(4);
    }

    public int countTriples(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i * i);
        }

        int cnt = 0;

        for (Integer i : set) {
            for (Integer j : set) {
                if (set.contains(i - j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
