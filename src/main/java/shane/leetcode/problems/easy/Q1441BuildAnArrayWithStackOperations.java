package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1441BuildAnArrayWithStackOperations {

    @Test
    public void test() {
        assertThat(buildArray(new int[]{1, 3}, 3)).containsExactly("Push", "Push", "Pop", "Push");
        assertThat(buildArray(new int[]{1, 2, 3}, 3)).containsExactly("Push", "Push", "Push");
        assertThat(buildArray(new int[]{1, 2}, 4)).containsExactly("Push", "Push");
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < target.length; i++) {
            answer.add("Push");
            if (target[i] != cur++) {
                answer.add("Pop");
                i--;
            }
        }
        return answer;
    }
}
