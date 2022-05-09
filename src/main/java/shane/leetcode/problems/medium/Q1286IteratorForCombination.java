package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1286IteratorForCombination {

    @Test
    public void test() {
        CombinationIterator c = new CombinationIterator("abc", 2);
        assertThat(c.next()).isEqualTo("ab");
        assertThat(c.hasNext()).isTrue();
        assertThat(c.next()).isEqualTo("ac");
        assertThat(c.hasNext()).isTrue();
        assertThat(c.next()).isEqualTo("bc");
        assertThat(c.hasNext()).isFalse();
    }

    class CombinationIterator {

        Queue<String> q = new LinkedList<>();
        int length;

        public CombinationIterator(String characters, int combinationLength) {
            char[] arr = characters.toCharArray();
            Arrays.sort(arr);
            this.length = combinationLength;
            dfs(arr, new boolean[arr.length], "", 0);
        }

        private void dfs(char[] arr, boolean[] visited, String s, int i) {
            if (s.length() == this.length) {
                q.offer(s);
                return;
            }
            if (i == arr.length)
                return;
            visited[i] = true;
            dfs(arr, visited, s + arr[i], i + 1);
            visited[i] = false;
            dfs(arr, visited, s, i + 1);

        }

        public String next() {
            return q.poll();
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}
