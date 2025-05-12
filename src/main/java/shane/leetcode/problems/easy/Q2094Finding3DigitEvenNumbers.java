package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 688ms
 * Beats5.11%
 */
public class Q2094Finding3DigitEvenNumbers {

    @Test
    public void test() {
        assertThat(findEvenNumbers(new int[]{2, 1, 3, 0})).containsExactly(102, 120, 130, 132, 210, 230, 302, 310, 312, 320);
        assertThat(findEvenNumbers(new int[]{2, 2, 8, 8, 2})).containsExactly(222, 228, 282, 288, 822, 828, 882);
        assertThat(findEvenNumbers(new int[]{3, 7, 5})).isEmpty();
    }

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        dfs(digits, answer, visited, new int[3]);
        int[] arr = new int[answer.size()];

        int i = 0;
        for (Integer n : answer) {
            arr[i++] = n;
        }
        Arrays.sort(arr);
        return arr;
    }

    private void dfs(int[] digits, Set<Integer> answer, Set<Integer> visited, int[] ints) {
        for (int i = 0; i < digits.length; i++) {
            int n = digits[i];
            if (visited.contains(i))
                continue;
            if (n == 0 && visited.isEmpty()) {
                continue;
            }
            ints[visited.size()] = n;
            if (visited.size() == 2) {
                if (n % 2 == 1)
                    continue;
                answer.add(ints[0] * 100 + ints[1] * 10 + n);
                continue;
            }
            visited.add(i);
            dfs(digits, answer, visited, ints);
            visited.remove(i);
        }
    }

}
