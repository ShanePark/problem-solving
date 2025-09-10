package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1733MinimumNumberOfPeopleToTeach {

    @Test
    public void test() {
        assertThat(minimumTeachings(2, Ps.intArray("[[1],[2],[1,2]]"), Ps.intArray("[[1,2],[1,3],[2,3]]"))).isEqualTo(1);
        assertThat(minimumTeachings(3, Ps.intArray("[[2],[1,3],[1,2],[3]]"), Ps.intArray("[[1,4],[1,2],[3,4],[2,3]]"))).isEqualTo(2);
    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer>[] langSets = new Set[languages.length + 1];
        for (int i = 0; i < languages.length; i++) {
            langSets[i + 1] = Arrays.stream(languages[i]).boxed().collect(Collectors.toSet());
        }

        Set<Integer> teach = new HashSet<>();
        for (int[] f : friendships) {
            if (!Collections.disjoint(langSets[f[0]], langSets[f[1]]))
                continue;
            teach.addAll(Arrays.asList(f[0], f[1]));
        }

        int[] count = new int[n + 1];
        for (int person : teach) {
            for (int l : langSets[person]) {
                count[l]++;
            }
        }

        return teach.size() - Arrays.stream(count).max().orElse(0);
    }

}
