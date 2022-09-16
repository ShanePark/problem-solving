package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1770MaximumScoreFromPerformingMultiplicationOperations {

    @Test
    public void test() {
        assertThat(maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1})).isEqualTo(14);
        assertThat(maximumScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6})).isEqualTo(102);
    }

    /**
     * 2 sec 391 ms
     */
    @Test
    public void tle() {
        assertThat(maximumScore(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10}
                , new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}))
                .isEqualTo(6861161);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        Queue<Status> q = new LinkedList<>();
        q.offer(new Status(0, nums.length - 1, 0));

        for (int m : multipliers) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Status poll = q.poll();
                q.offer(poll.calcLeft(nums, m));
                q.offer(poll.calcRight(nums, m));
            }
        }

        return q.stream().mapToInt(s -> (int) s.value).max().getAsInt();
    }

    class Status {
        int left;
        int right;
        long value;

        public Status(int left, int right, long value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Status calcLeft(int[] nums, int m) {
            return new Status(left + 1, right, value + nums[left] * m);
        }

        public Status calcRight(int[] nums, int m) {
            return new Status(left, right - 1, value + nums[right] * m);
        }

        @Override
        public String toString() {
            return "Status{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }
}
