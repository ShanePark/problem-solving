package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 749 ms Beats 6.11% of users with Java
 */
public class Q86KthSmallestPrimeFraction {

    @Test
    public void test() {
        assertThat(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)).isEqualTo(new int[]{2, 5});
        assertThat(kthSmallestPrimeFraction(new int[]{1, 7}, 1)).isEqualTo(new int[]{1, 7});
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Fraction> list = new ArrayList<>();
        for (int i : arr) {
            for (int j : arr) {
                if (i == j)
                    continue;
                list.add(new Fraction(i, j));
            }
        }
        Collections.sort(list);
        Fraction fraction = list.get(k - 1);
        return new int[]{fraction.numerator, fraction.deNumerator};
    }

    static class Fraction implements Comparable<Fraction> {
        double val;
        int numerator;
        int deNumerator;

        public Fraction(int numerator, int deNumerator) {
            this.numerator = numerator;
            this.deNumerator = deNumerator;
            this.val = (double) this.numerator / this.deNumerator;
        }

        @Override
        public String toString() {
            return "Fraction{" +
                    "val=" + val +
                    ", numerator=" + numerator +
                    ", deNumerator=" + deNumerator +
                    '}';
        }

        @Override
        public int compareTo(Fraction o) {
            return Double.compare(this.val, o.val);
        }
    }

}
