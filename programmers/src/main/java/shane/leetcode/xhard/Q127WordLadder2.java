package shane.leetcode.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q127WordLadder2 {

    @Test
    void test() {
        Assertions.assertThat(ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}))).isEqualTo(5);
        Assertions.assertThat(ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"}))).isEqualTo(0);
        Assertions.assertThat(ladderLength("cob", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "cog"}))).isEqualTo(2);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int cnt = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String poll = q.poll();
                if (poll.equals(endWord)) {
                    return cnt;
                }
                set.remove(poll);
                for (int j = 0; j < beginWord.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        StringBuffer sb = new StringBuffer(poll);
                        sb.setCharAt(j, (char) ('a' + k));
                        if (set.contains(sb.toString())) {
                            q.offer(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                }
            }
            cnt++;
        }

        return 0;

    }

}
