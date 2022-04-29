package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1299ReplaceElementsWithGreatestElementOnRightSide {

    @Test
    public void test() {
        assertThat(replaceElements(new int[]{17, 18, 5, 4, 6, 1})).containsExactly(18, 6, 6, 6, 1, -1);
        assertThat(replaceElements(new int[]{400})).containsExactly(-1);
    }

    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : arr) {
            pq.offer(i);
        }

        for (int i = 0; i < arr.length; i++) {
            pq.remove(arr[i]);
            answer[i] = pq.isEmpty() ? -1 : pq.peek();
        }
        return answer;
    }

}
