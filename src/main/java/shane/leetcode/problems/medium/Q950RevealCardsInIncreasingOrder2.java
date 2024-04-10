package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 13.35% of users with Java
 */
public class Q950RevealCardsInIncreasingOrder2 {

    @Test
    public void test() {
        assertThat(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})).containsExactly(2, 13, 3, 11, 5, 17, 7);
        assertThat(deckRevealedIncreasing(new int[]{1, 1000})).containsExactly(1, 1000);
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            deque.offerLast(i);
        }
        List<Integer> seq = new ArrayList<>();
        while (!deque.isEmpty()) {
            Integer first = deque.pollFirst();
            seq.add(first);
            if (!deque.isEmpty()) {
                deque.offerLast(deque.pollFirst());
            }
        }
        int[] answer = new int[deck.length];
        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            answer[seq.get(i)] = deck[i];
        }
        return answer;
    }

}
