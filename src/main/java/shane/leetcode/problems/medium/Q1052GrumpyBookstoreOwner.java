package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime7msBeats14.93%
 */
public class Q1052GrumpyBookstoreOwner {

    @Test
    public void test() {
        assertThat(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3)).isEqualTo(16);
        assertThat(maxSatisfied(new int[]{1}, new int[]{0}, 1)).isEqualTo(1);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int answer = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                answer += customers[i];
                customers[i] = 0;
            }
        }
        int max = 0;
        int cur = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int customer : customers) {
            q.offer(customer);
            cur += customer;
            if (q.size() > minutes) {
                cur -= q.poll();
            }
            max = Math.max(max, cur);
        }
        return answer + max;
    }

}
