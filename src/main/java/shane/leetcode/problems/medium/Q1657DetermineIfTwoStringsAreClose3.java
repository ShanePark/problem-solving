package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 40 ms Beats 51.26% of users with Java
 * Memory 45.79 MB Beats 14.80% of users with Java
 */
public class Q1657DetermineIfTwoStringsAreClose3 {

    @Test
    public void test() {
        assertThat(closeStrings("uau", "ssx")).isFalse();
        assertThat(closeStrings("abbccc", "aaaabc")).isFalse();
        assertThat(closeStrings("abc", "bca")).isTrue();
        assertThat(closeStrings("cabbba", "abbccc")).isTrue();
        assertThat(closeStrings("a", "aa")).isFalse();

    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        Set<Character> set = new HashSet<>();
        for (char c : word2.toCharArray()) {
            set.add(c);
        }
        for (char c : word1.toCharArray()) {
            set.remove(c);
        }
        if (!set.isEmpty()) {
            return false;
        }

        PriorityQueue<Integer> pq1 = toPq(word1);
        PriorityQueue<Integer> pq2 = toPq(word2);

        int sum = pq1.poll();
        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            if (sum > 0) {
                sum -= pq2.poll();
                if (sum < 0)
                    return false;
                continue;
            }
            if (pq1.isEmpty())
                return false;
            if (sum == 0) {
                sum = pq1.poll();
            } else {
                sum += pq1.poll();
            }
        }
        return true;
    }

    private PriorityQueue<Integer> toPq(String word1) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[26];
        for (char c : word1.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i : arr) {
            if (i == 0)
                continue;
            pq.offer(i);
        }
        return pq;
    }

}
