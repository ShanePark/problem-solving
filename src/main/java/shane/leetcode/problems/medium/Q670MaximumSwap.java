package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats30.39%
 */
public class Q670MaximumSwap {

    @Test
    public void test() {
        assertThat(maximumSwap(98368)).isEqualTo(98863);
        assertThat(maximumSwap(2736)).isEqualTo(7236);
        assertThat(maximumSwap(9973)).isEqualTo(9973);
    }

    public int maximumSwap(int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int[] lastIndex = new int[10];
        for (int i = 0; i < sb.length(); i++) {
            int val = sb.charAt(i) - '0';
            lastIndex[val] = i;
            pq.offer(val);
        }
        for (int i = 0; i < sb.length(); i++) {
            int cur = sb.charAt(i) - '0';
            Integer poll = pq.poll();
            if (cur < poll) {
                sb.setCharAt(lastIndex[poll], (char) ('0' + cur));
                sb.setCharAt(i, (char) ('0' + poll));
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
