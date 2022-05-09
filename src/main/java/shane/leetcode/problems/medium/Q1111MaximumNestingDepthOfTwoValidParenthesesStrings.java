package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1111MaximumNestingDepthOfTwoValidParenthesesStrings {

    @Test
    public void test() {
        assertThat(maxDepthAfterSplit("(()())")).containsExactly(0, 1, 1, 1, 1, 0);
        assertThat(maxDepthAfterSplit("()(())()")).containsExactly(0, 0, 0, 1, 1, 0, 1, 1);
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < answer.length; i++) {
            if (seq.charAt(i) == '(') {
                answer[i] = depth % 2;
                depth++;
            } else {
                depth--;
                answer[i] = depth % 2;
            }
        }
        return answer;
    }

}
