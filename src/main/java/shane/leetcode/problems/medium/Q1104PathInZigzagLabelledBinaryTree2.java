package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1104PathInZigzagLabelledBinaryTree2 {

    @Test
    public void test() {
        assertThat(pathInZigZagTree(14)).containsExactly(1, 3, 4, 14);
        assertThat(pathInZigZagTree(26)).containsExactly(1, 2, 6, 10, 26);
    }

    public List<Integer> pathInZigZagTree(int label) {
        int level = Integer.toBinaryString(label).length();

        List<Integer> answer = new ArrayList<>();
        while (level > 0) {
            answer.add(0, label);
            int startLevel = (int) Math.pow(2, level - 1);
            int endLevel = (int) Math.pow(2, level) - 1;
            int reverse = endLevel - (label - startLevel);
            label = reverse / 2;
            level--;
        }

        return answer;
    }

}
