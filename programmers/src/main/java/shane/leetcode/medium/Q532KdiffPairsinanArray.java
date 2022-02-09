package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q532KdiffPairsinanArray {

    @Test
    void test() {
        Assertions.assertThat(findPairs(new int[]{3, 1, 4, 1, 5}, 2)).isEqualTo(2);
        Assertions.assertThat(findPairs(new int[]{1, 2, 3, 4, 5}, 1)).isEqualTo(4);
        Assertions.assertThat(findPairs(new int[]{1, 3, 1, 5, 4}, 0)).isEqualTo(1);
        Assertions.assertThat(findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3)).isEqualTo(2);
    }

    public int findPairs(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            q.offer(num);
        }

        Set<Pair> set = new HashSet<>();
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : q) {
                if (Math.abs(poll - i) == k) {
                    set.add(new Pair(poll, i));
                }
            }
        }

        return set.size();

    }

    private class Pair {
        int num1;
        int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            if (p.num1 == num1 && p.num2 == num2) {
                return true;
            } else if (p.num1 == num2 && p.num2 == num1) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(num1 + num2);
        }
    }
}
