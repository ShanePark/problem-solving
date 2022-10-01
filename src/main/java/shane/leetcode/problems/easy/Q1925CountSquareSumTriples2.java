package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 7 ms, faster than 96.11% of Java online submissions for Count Square Sum Triples.
 * Memory Usage: 49.4 MB, less than 12.09% of Java online submissions for Count Square Sum Triples.
 */
public class Q1925CountSquareSumTriples2 {

    @Test
    public void test() {
        assertThat(countTriples(5)).isEqualTo(2);
        assertThat(countTriples(10)).isEqualTo(4);
    }

    public int countTriples(int n) {
        int[] arr = new int[n * n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i * i] = 1;
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i * i + j * j <= n * n; j++) {
                answer += arr[i * i + j * j];
            }
        }
        return answer;
    }

}
