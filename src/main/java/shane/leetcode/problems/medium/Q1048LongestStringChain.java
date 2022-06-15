package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1048LongestStringChain {

    @Test
    public void test() {
        assertThat(longestStrChain(new String[]{"a", "ab", "ac", "bd", "abc", "abd", "abdd"})).isEqualTo(4);
        assertThat(longestStrChain(new String[]{"czgxmxrpx", "lgh", "bj", "cheheex", "jnzlxgh", "nzlgh", "ltxdoxc", "bju", "srxoatl", "bbadhiju", "cmpx", "xi", "ntxbzdr", "cheheevx", "bdju", "sra", "getqgxi", "geqxi", "hheex", "ltxdc", "nzlxgh", "pjnzlxgh", "e", "bbadhju", "cmxrpx", "gh", "pjnzlxghe", "oqlt", "x", "sarxoatl", "ee", "bbadju", "lxdc", "geqgxi", "oqltu", "heex", "oql", "eex", "bbdju", "ntxubzdr", "sroa", "cxmxrpx", "cmrpx", "ltxdoc", "g", "cgxmxrpx", "nlgh", "sroat", "sroatl", "fcheheevx", "gxi", "gqxi", "heheex"})).isEqualTo(9);
        assertThat(longestStrChain(new String[]{"a", "b", "ba", "abc", "abd", "bdca"})).isEqualTo(2);
        assertThat(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"})).isEqualTo(4);
        assertThat(longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"})).isEqualTo(5);
        assertThat(longestStrChain(new String[]{"abcd", "dbqca"})).isEqualTo(1);
    }

    @Test
    public void validTest() {
        assertThat(valid("e", "bj")).isFalse();
        assertThat(valid("e", "ea")).isTrue();
        assertThat(valid("e", "eaa")).isFalse();
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Queue<Q> queue = new LinkedList<>();
        int max = 1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            Queue<Q> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Q poll = queue.poll();
                if (poll.lengthOfWord == length - 1 && valid(poll.lastWord, word)) {
                    next.offer(new Q(word, length, poll.count + 1));
                    next.offer(poll);
                } else if (poll.lengthOfWord >= length - 1) {
                    next.offer(poll);
                } else {
                    max = Math.max(max, poll.count);
                }
            }
            next.offer(new Q(word, length, 1));
            queue = next;
        }

        for (Q q : queue) {
            max = Math.max(max, q.count);
        }

        return max;
    }

    /**
     * lastWord : "xbc", word : "xabc" : valid
     * "e", "bj" : false
     *
     * @param lastWord
     * @param word
     * @return
     */
    private boolean valid(String lastWord, String word) {
        if (lastWord.length() != word.length() - 1) {
            return false;
        }
        int dif = 0;
        for (int i = 0; i < lastWord.length(); i++) {
            if (lastWord.charAt(i) != word.charAt(i + dif)) {
                if (dif == 0) {
                    dif++;
                    i--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    class Q {
        String lastWord;
        int lengthOfWord;
        int count;

        public Q(String lastWord, int lengthOfWord, int count) {
            this.lastWord = lastWord;
            this.lengthOfWord = lengthOfWord;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Q{" +
                    "lastWord='" + lastWord + '\'' +
                    ", lengthOfWord=" + lengthOfWord +
                    ", count=" + count +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Q q = (Q) o;
            return lengthOfWord == q.lengthOfWord && count == q.count && Objects.equals(lastWord, q.lastWord);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastWord, lengthOfWord, count);
        }
    }
}
