package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q950RevealCardsInIncreasingOrder {

    @Test
    public void test() {
        assertThat(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})).containsExactly(2, 13, 3, 11, 5, 17, 7);
        assertThat(deckRevealedIncreasing(new int[]{1, 1000})).containsExactly(1, 1000);
        assertThat(deckRevealedIncreasing(new int[]{1})).containsExactly(1);
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int size = deck.length;
        int[] answer = new int[size];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            q.offer(i);
        }

        int index = 0;
        while (q.size() > 1) {
            answer[q.poll()] = deck[index++];
            q.offer(q.poll());
        }
        answer[q.poll()] = deck[index++];
        return answer;
    }

}
