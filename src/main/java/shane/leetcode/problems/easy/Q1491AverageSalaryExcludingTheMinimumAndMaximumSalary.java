package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.1 MB Beats 83.61%
 */
public class Q1491AverageSalaryExcludingTheMinimumAndMaximumSalary {

    @Test
    void test() {
        assertThat(average(new int[]{4000, 3000, 1000, 2000})).isEqualTo(2500.00000);
        assertThat(average(new int[]{1000, 2000, 3000})).isEqualTo(2000.00000);
    }

    public double average(int[] salary) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : salary) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        sum = sum - max - min;
        return (double) sum / (salary.length - 2);
    }

}
