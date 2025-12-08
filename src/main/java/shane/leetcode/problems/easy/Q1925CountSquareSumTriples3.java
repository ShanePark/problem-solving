package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 232ms
 * Beats16.70%
 */
public class Q1925CountSquareSumTriples3 {

    @Test
    public void test() {
        assertThat(countTriples(5)).isEqualTo(2);
        assertThat(countTriples(10)).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(countTriples(20)).isEqualTo(12);
    }

    public int countTriples(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

}
