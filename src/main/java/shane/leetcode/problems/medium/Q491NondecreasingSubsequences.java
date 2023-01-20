package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 31 ms Beats 20.55%
 * Memory 62 MB Beats 41.82%
 */
public class Q491NondecreasingSubsequences {

    @Test
    public void test() {
        assertThat(findSubsequences(new int[]{4, 6, 7, 7}))
                .containsExactlyInAnyOrder(List.of(4, 6), List.of(4, 7), List.of(4, 6, 7), List.of(4, 6, 7, 7), List.of(6, 7), List.of(6, 7, 7), List.of(7, 7), List.of(4, 7, 7));
        assertThat(findSubsequences(new int[]{4, 4, 3, 2, 1}))
                .containsExactlyInAnyOrder(List.of(4, 4));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<Status> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int num : nums) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Status poll = q.poll();
                if (poll.lastNumber <= num && set.add(poll.str + " " + num)) {
                    Status next = poll.next(num);
                    answer.add(next.getList());
                    q.offer(next);
                }
                q.offer(poll);
            }
            if (set.add(String.valueOf(num))) {
                q.offer(new Status(num));
            }
        }
        return answer;
    }

    class Status {
        String str;
        List<Integer> list = new ArrayList<>();
        int lastNumber;

        public Status() {
        }

        public Status(int n) {
            this.lastNumber = n;
            this.list.add(n);
            this.str = String.valueOf(n);
        }

        public Status next(int num) {
            Status next = new Status();
            next.str = this.str;
            next.list = new ArrayList<>(this.list);
            next.addNumber(num);
            return next;
        }

        public void addNumber(int num) {
            this.lastNumber = num;
            this.list.add(num);
            this.str += " " + num;
        }

        public List<Integer> getList() {
            return new ArrayList<>(list);
        }
    }

}
