package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class Q881BoatsToSavePeople {

    @Test
    public void test() {
        assertThat(numRescueBoats(new int[]{1, 2}, 3)).isEqualTo(1);
        assertThat(numRescueBoats(new int[]{3, 2, 2, 1}, 3)).isEqualTo(3);
        assertThat(numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6)).isEqualTo(3);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int person : people) {
            dq.offer(person);
        }

        int cnt = 0;
        while (!dq.isEmpty()) {
            int capacity = limit - dq.pollLast();
            int peopleCount = 1;
            while (peopleCount < 2 && !dq.isEmpty() && capacity >= dq.peekFirst()) {
                capacity -= dq.pollFirst();
                peopleCount++;
            }
            cnt++;
        }

        return cnt;
    }
}
