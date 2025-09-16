package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 64 / 71 testcases passed
 */
public class Q2197ReplaceNonCoprimeNumbersInArray {

    @Test
    public void test() {
        assertThat(replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2})).isEqualTo(List.of(12, 7, 6));
        assertThat(replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3})).isEqualTo(List.of(2, 1, 1, 3));
    }

    @Test
    public void test2() {
        assertThat(replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561})).isEqualTo(List.of(31, 97561));
    }

    @Test
    public void test3() {
        assertThat(replaceNonCoprimes(new int[]{287, 41, 49, 287, 899, 23, 23, 20677, 5, 825})).isEqualTo(List.of(2009, 20677, 825));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int coPrime = findCoPrime(before, n);
            if (coPrime == 1) {
                stack.push(before);
                before = n;
                continue;
            }
            before = (int) ((long) before * n / coPrime);
            while (!stack.isEmpty() && findCoPrime(stack.peek(), before) > 1) {
                int coPrime_ = findCoPrime(stack.peek(), before);
                int pop = stack.pop();
                before = (int) ((long) pop * before / coPrime_);
            }
        }
        stack.push(before);
        return new ArrayList<>(stack);
    }

    private int findCoPrime(int before, int n) {
        int min = Math.min(before, n);
        while (1 < min) {
            if (before % min == 0 && n % min == 0)
                return min;
            min--;
        }
        return 1;
    }

}
