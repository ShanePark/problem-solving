package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 8.76% of users with Java
 */
public class Q1863SumOfAllSubsetXORTotals2 {

    @Test
    public void test() {
        assertThat(subsetXORSum(new int[]{1, 3})).isEqualTo(6);
        assertThat(subsetXORSum(new int[]{5, 1, 6})).isEqualTo(28);
        assertThat(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8})).isEqualTo(480);
    }

    int answer = 0;

    public int subsetXORSum(int[] nums) {
        answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                q.offer(poll);
                poll ^= num;
                q.offer(poll);
                answer += poll;
            }
            q.offer(num);
            answer += num;
        }
        return answer;
    }

}
