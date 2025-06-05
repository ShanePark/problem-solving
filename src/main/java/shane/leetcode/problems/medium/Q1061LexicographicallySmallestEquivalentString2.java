package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats96.73%
 */
public class Q1061LexicographicallySmallestEquivalentString2 {

    @Test
    public void test() {
        assertThat(smallestEquivalentString("parker", "morris", "parser")).isEqualTo("makkek");
        assertThat(smallestEquivalentString("hello", "world", "hold")).isEqualTo("hdld");
        assertThat(smallestEquivalentString("leetcode", "programs", "sourcecode")).isEqualTo("aauaaaaada");
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) ('a' + uf.unionFind(baseStr.charAt(i) - 'a')));
        }
        return sb.toString();
    }

    static class UnionFind {
        final int[] arr = new int[26];

        public UnionFind() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public int unionFind(int i) {
            if (arr[i] == i)
                return i;
            return arr[i] = unionFind(arr[i]);
        }

        public void union(int a, int b) {
            int ufA = unionFind(a);
            int ufB = unionFind(b);
            int min = Math.min(ufA, ufB);
            arr[ufA] = min;
            arr[ufB] = min;
        }
    }

}
