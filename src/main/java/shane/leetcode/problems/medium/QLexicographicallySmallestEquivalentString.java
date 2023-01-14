package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 88.7%
 * Memory 40.6 MB Beats 90.91%
 */
public class QLexicographicallySmallestEquivalentString {

    @Test
    public void test() {
        assertThat(smallestEquivalentString("parker", "morris", "parser")).isEqualTo("makkek");
        assertThat(smallestEquivalentString("hello", "world", "hold")).isEqualTo("hdld");
        assertThat(smallestEquivalentString("leetcode", "programs", "sourcecode")).isEqualTo("aauaaaaada");
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] union = new int[26];
        for (int i = 0; i < 26; i++) {
            union[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            int c1Index = unionFind(union, c1 - 'a');
            int c2Index = unionFind(union, c2 - 'a');
            if (c1Index < c2Index) {
                union[c2Index] = c1Index;
            } else {
                union[c1Index] = c2Index;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) (unionFind(union, baseStr.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }

    private int unionFind(int[] union, int i) {
        if (union[i] == i)
            return i;
        return unionFind(union, union[i]);
    }

}
