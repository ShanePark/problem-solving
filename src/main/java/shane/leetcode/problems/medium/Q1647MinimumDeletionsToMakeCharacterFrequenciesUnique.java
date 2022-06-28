package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1647MinimumDeletionsToMakeCharacterFrequenciesUnique {

    @Test
    public void test() {
        assertThat(minDeletions("bbcebab")).isEqualTo(2);
        assertThat(minDeletions("ee")).isEqualTo(0);
        assertThat(minDeletions("abcabc")).isEqualTo(3);
        assertThat(minDeletions("aaaabbbbccccdddd")).isEqualTo(6);
        assertThat(minDeletions("aab")).isEqualTo(0);
        assertThat(minDeletions("aaabbbcc")).isEqualTo(2);
        assertThat(minDeletions("ceabaacb")).isEqualTo(2);
    }

    public int minDeletions(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.offer(arr[i]);
            }
        }
        int before = pq.poll();
        int del = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            int diff = poll - before;
            if (diff >= 0) {
                poll -= diff + 1;
                del += diff + 1;
            }
            if (poll > 0)
                before = poll;
        }
        return del;
    }
}
