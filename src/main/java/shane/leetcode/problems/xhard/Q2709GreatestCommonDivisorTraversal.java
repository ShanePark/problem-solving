package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2709GreatestCommonDivisorTraversal {

    @Test
    public void test() {
        assertThat(canTraverseAllPairs(new int[]{20, 6})).isTrue();
        assertThat(canTraverseAllPairs(new int[]{2, 3, 6})).isTrue();
        assertThat(canTraverseAllPairs(new int[]{3, 9, 5})).isFalse();
        assertThat(canTraverseAllPairs(new int[]{4, 3, 12, 8})).isTrue();
    }

    /**
     * 521 ms
     */
    @Test
    public void tle() {
        int size = (int) 1e5;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        assertThat(canTraverseAllPairs(arr)).isFalse();
    }

    public boolean canTraverseAllPairs(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Queue<Integer> q = new LinkedList<>();
        q.offer(list.remove(0));

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (gcd(num, poll) > 1) {
                    list.remove(i--);
                    q.offer(num);
                }
            }
        }

        return list.isEmpty();
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }

}
