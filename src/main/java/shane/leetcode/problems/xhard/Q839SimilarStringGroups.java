package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 19 ms Beats 59.92%
 * Memory 42 MB Beats 88.55%
 */
public class Q839SimilarStringGroups {

    @Test
    public void test() {
        assertThat(numSimilarGroups(new String[]{"jmijc", "imjjc", "jcijm", "cmijj", "mijjc"})).isEqualTo(1);
        assertThat(numSimilarGroups(new String[]{"nmiwx", "mniwx", "wminx", "mnixw", "xnmwi"})).isEqualTo(2);
        assertThat(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"})).isEqualTo(2);
        assertThat(numSimilarGroups(new String[]{"omv", "ovm"})).isEqualTo(1);
    }

    public int numSimilarGroups(String[] strs) {
        Arrays.sort(strs);
        final int LENGTH = strs.length;
        int[] union = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            union[i] = i;
        }
        for (int i = 0; i < LENGTH; i++) {
            String cur = strs[i];
            for (int j = 0; j < i; j++) {
                String other = strs[j];
                if (isSimilar(cur, other)) {
                    union(union, i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < LENGTH; i++) {
            set.add(unionFind(union, i));
        }
        return set.size();
    }

    private void union(int[] union, int i, int j) {
        int group1 = unionFind(union, i);
        int group2 = unionFind(union, j);
        if (group1 != group2) {
            union[group2] = group1;
        }
    }

    private int unionFind(int[] union, int i) {
        if (union[i] == i)
            return i;
        int group = unionFind(union, union[i]);
        union[i] = group;
        return group;
    }

    private boolean isSimilar(String cur, String other) {
        int diffCnt = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != other.charAt(i)) {
                diffCnt++;
                if (diffCnt > 2)
                    return false;
            }
        }
        return true;
    }

}
