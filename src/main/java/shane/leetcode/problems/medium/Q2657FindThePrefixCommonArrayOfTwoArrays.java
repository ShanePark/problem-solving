package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 40ms
 * Beats5.21%
 */
public class Q2657FindThePrefixCommonArrayOfTwoArrays {

    @Test
    public void test() {
        assertThat(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})).containsExactly(0, 2, 3, 4);
        assertThat(findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})).containsExactly(0, 1, 3);
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] answer = new int[A.length];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            Set<Integer> tmp = new HashSet<>(setA);
            tmp.removeAll(setB);
            answer[i] = i + 1 - tmp.size();
        }
        return answer;
    }

}
