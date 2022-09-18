package shane.programmers.challenge2022.jobis2022;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q4 {

    @Test
    public void test() {
        assertThat(solution(3, STool.convertToIntArray("[[1,4],[2,2],[1,3],[1,6],[3,-1],[2,-1]]"))).containsExactly(4, 2);
        assertThat(solution(4, STool.convertToIntArray("[[1,3],[1,2],[3,6],[3,-1],[4,5],[2,-1],[3,-1],[1,-1]]"))).containsExactly(6, 3, 5, 2);
        assertThat(solution(5, STool.convertToIntArray("[[1,-1],[2,-1],[3,-1],[4,-1],[5,-1]]"))).containsExactly(-1, -1, -1, -1, -1);
    }

    public int[] solution(int n, int[][] queries) {
        MyStack stack = new MyStack(n);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int index = query[0];
            int num = query[1];
            if (num == -1) {
                Integer pop = stack.pop(index - 1);
                result.add(pop);
            } else {
                stack.push(index - 1, num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    class MyStack {
        private Deque[] deques;
        private Integer center = null;

        public MyStack(int n) {
            deques = new Deque[n];
            for (int i = 0; i < n; i++) {
                deques[i] = new ArrayDeque<Integer>();
            }
        }

        public Integer pop(int index) {
            Deque<Integer> deque = deques[index];
            if (!deque.isEmpty()) {
                return deque.pollLast();
            } else if (center == null) {
                return -1;
            }

            int savedCenter = center;
            center = null;
            for (int i = 1; i < deques.length; i++) {
                Deque<Integer> nextDeque = deques[(index + i) % deques.length];
                if (!nextDeque.isEmpty()) {
                    center = nextDeque.pollFirst();
                    break;
                }
            }
            return savedCenter;
        }

        public void push(int index, int num) {
            if (center == null) {
                center = num;
            } else {
                deques[index].offerLast(num);
            }
        }
    }

}
