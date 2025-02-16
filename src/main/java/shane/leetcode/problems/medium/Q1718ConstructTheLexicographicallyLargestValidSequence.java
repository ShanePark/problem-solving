package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q1718ConstructTheLexicographicallyLargestValidSequence {

    @Test
    public void test() {
        assertThat(constructDistancedSequence(2)).isEqualTo(new int[]{2, 1, 2});
        assertThat(constructDistancedSequence(3)).isEqualTo(new int[]{3, 1, 2, 3, 2});
        assertThat(constructDistancedSequence(4)).isEqualTo(new int[]{4, 2, 3, 2, 4, 3, 1});
        assertThat(constructDistancedSequence(5)).isEqualTo(new int[]{5, 3, 1, 4, 3, 5, 2, 4, 2});
        assertThat(constructDistancedSequence(20)).isEqualTo(new int[]{20, 18, 19, 15, 13, 17, 10, 16, 7, 5, 3, 14, 12, 3, 5, 7, 10, 13, 15, 18, 20, 19, 17, 16, 12, 14, 11, 9, 4, 6, 8, 2, 4, 2, 1, 6, 9, 11, 8});
    }

    public int[] constructDistancedSequence(int n) {
        int[] answer = new int[n * 2 - 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = n; i > 0; i--) {
            int[] arr = tryIt(answer, visited, 0, i);
            if (arr != null)
                return arr;
        }
        return null;
    }

    private int[] tryIt(int[] answer, boolean[] visited, int index, int n) {
        if (n != 1 && (index + n >= answer.length || answer[index + n] != 0))
            return null;
        answer[index] = n;
        if (index == answer.length - 1)
            return answer;

        if (n != 1) {
            answer[index + n] = n;
        }
        visited[n] = true;

        int nextIndex = index + 1;
        while (answer[nextIndex] != 0) {
            nextIndex++;
            if (nextIndex == answer.length)
                return answer;
        }
        for (int i = visited.length - 1; i > 0; i--) {
            if (visited[i])
                continue;
            int[] arr = tryIt(answer, visited, nextIndex, i);
            if (arr != null)
                return arr;
        }
        answer[index] = 0;
        if (n != 1) {
            answer[index + n] = 0;
        }
        visited[n] = false;
        return null;
    }

}
