package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 28 ms, faster than 65.45% of Java online submissions for Split Array into Consecutive Subsequences.
 * Memory Usage: 73.4 MB, less than 5.45% of Java online submissions for Split Array into Consecutive Subsequences.
 */
public class Q659SplitArrayIntoConsecutiveSubsequences {

    @Test
    public void test() {
        assertThat(isPossible(new int[]{1, 2, 3, 5, 5, 6, 7})).isFalse();
        assertThat(isPossible(new int[]{1, 2, 3, 3, 4, 5})).isTrue();
        assertThat(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5})).isTrue();
        assertThat(isPossible(new int[]{1, 2, 3, 4, 4, 5})).isFalse();
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> {
            Integer l1Last = l1.get(l1.size() - 1);
            Integer l2Last = l2.get(l2.size() - 1);
            if (l1Last == l2Last) {
                return Integer.compare(l1.size(), l2.size());
            }
            return Integer.compare(l1Last, l2Last);
        });
        for (int num : nums) {
            while (!pq.isEmpty()) {
                List<Integer> peek = pq.peek();
                int last = peek.get(peek.size() - 1);
                if (last + 1 < num) {
                    if (peek.size() < 3)
                        return false;
                    pq.poll();
                } else {
                    break;
                }
            }

            if (pq.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                pq.offer(list);
            } else {
                List<Integer> peek = pq.peek();
                int last = peek.get(peek.size() - 1);
                if (last + 1 == num) {
                    List<Integer> poll = pq.poll();
                    poll.add(num);
                    pq.add(poll);
                } else if (last == num) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    pq.offer(list);
                } else {
                    if (pq.size() < 3)
                        return false;
                    pq.poll();
                }
            }
        }

        for (List<Integer> list : pq) {
            if (list.size() < 3) {
                return false;
            }
        }
        return true;
    }
}
