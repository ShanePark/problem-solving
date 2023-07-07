package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 36 ms Beats 14.38%
 * Memory 50.9 MB Beats 5%
 */
public class Q2024MaximizeTheConfusionOfAnExam {

    @Test
    void test() {
        assertThat(maxConsecutiveAnswers("TTFF", 2)).isEqualTo(4);
        assertThat(maxConsecutiveAnswers("TFFT", 1)).isEqualTo(3);
        assertThat(maxConsecutiveAnswers("TTFTTFTT", 1)).isEqualTo(5);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        Queue<Boolean> trueQueue = new LinkedList<>();
        Queue<Boolean> falseQueue = new LinkedList<>();
        int trueCnt = 0;
        int falseCnt = 0;
        int max = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            boolean cur = answerKey.charAt(i) == 'T';
            trueQueue.offer(cur);
            falseQueue.offer(cur);
            if (cur) {
                trueCnt++;
            } else {
                falseCnt++;
            }
            while (trueCnt > k) {
                boolean poll = falseQueue.poll();
                if (poll) {
                    trueCnt--;
                }
            }
            while (falseCnt > k) {
                boolean poll = trueQueue.poll();
                if (!poll) {
                    falseCnt--;
                }
            }
            max = Math.max(max, trueQueue.size());
            max = Math.max(max, falseQueue.size());
        }

        return max;
    }

}
