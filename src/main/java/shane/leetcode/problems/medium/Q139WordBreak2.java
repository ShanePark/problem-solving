package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 85.65%
 * Memory 41.1 MB Beats 86.3%
 */
public class Q139WordBreak2 {

    @Test
    public void test() {
        assertThat(wordBreak("leetcode", List.of("lee", "leet", "code"))).isTrue();
        assertThat(wordBreak("leetcode", List.of("leet", "code"))).isTrue();
        assertThat(wordBreak("applepenapple", List.of("apple", "pen"))).isTrue();
        assertThat(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))).isFalse();
    }

    @Test
    public void tle() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        assertThat(wordBreak(s, wordDict)).isFalse();
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        set.add(0);
        pq.add(0);

        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (poll == s.length())
                return true;
            String sub = s.substring(poll);
            for (String word : wordDict) {
                int next = poll + word.length();
                if (!set.contains(next) && sub.startsWith(word)) {
                    set.add(next);
                    pq.offer(next);
                }
            }
        }
        return false;
    }

}
