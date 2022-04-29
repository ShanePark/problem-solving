package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1299ReplaceElementsWithGreatestElementOnRightSide2 {

    @Test
    public void test() {
        assertThat(replaceElements(new int[]{17, 18, 5, 4, 6, 1})).containsExactly(18, 6, 6, 6, 1, -1);
        assertThat(replaceElements(new int[]{400})).containsExactly(-1);
    }

    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            answer[i] = max;
            max = Math.max(max, arr[i]);
        }
        return answer;
    }

}
