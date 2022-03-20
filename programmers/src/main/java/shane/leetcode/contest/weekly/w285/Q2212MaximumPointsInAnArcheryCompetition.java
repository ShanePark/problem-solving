package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * Programmers 양궁 문제 시도하다가 실패했던 방법
 */
public class Q2212MaximumPointsInAnArcheryCompetition {

    @Test
    void test() {
        Assertions.assertThat(maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0})).containsExactly(0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1);
        Assertions.assertThat(maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2})).containsExactly(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0);
    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] answer = new int[12];
        PriorityQueue<Arrow> pq = new PriorityQueue<>();
        for (int i = 0; i < aliceArrows.length; i++) {
            pq.offer(new Arrow(i, aliceArrows[i] == 0 ? 1 : aliceArrows[i] + 1));
        }

        System.out.println("pq.poll() = " + pq.poll());
        System.out.println("pq.poll() = " + pq.poll());
        System.out.println("pq.poll() = " + pq.poll());
        System.out.println("pq.poll() = " + pq.poll());
        System.out.println("pq.poll() = " + pq.poll());
        System.out.println("pq.poll() = " + pq.poll());
        while (numArrows > 0) {
            Arrow poll = pq.poll();
            if (poll.necessary <= numArrows) {
                numArrows -= poll.necessary;
                answer[poll.score] = poll.necessary;
            }
        }

        return answer;

    }

    class Arrow implements Comparable {
        int score;
        int necessary;
        double scorePerArrow;

        public Arrow(int score, int necessary) {
            this.score = score;
            this.necessary = necessary;
            this.scorePerArrow = (double) score / necessary;
        }

        @Override
        public int compareTo(Object o) {
            return Double.compare(((Arrow) o).scorePerArrow, this.scorePerArrow);
        }

        @Override
        public String toString() {
            return "Arrow{" +
                    "score=" + score +
                    ", necessary=" + necessary +
                    ", scorePerArrow=" + scorePerArrow +
                    '}';
        }
    }

}
