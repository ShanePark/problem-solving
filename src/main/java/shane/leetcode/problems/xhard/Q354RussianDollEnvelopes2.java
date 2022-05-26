package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q354RussianDollEnvelopes2 {

    @Test
    public void test() {
        assertThat(maxEnvelopes(STool.convertToIntArray("[[1,1]]"))).isEqualTo(1);
        assertThat(maxEnvelopes(STool.convertToIntArray("[[1,30],[16,17],[17,18],[18,19],[19,20]]"))).isEqualTo(4);
        assertThat(maxEnvelopes(STool.convertToIntArray("[[17,18],[20,4],[4,3],[14,6],[16,4],[8,11],[17,11],[18,7],[20,12]]"))).isEqualTo(4);
        assertThat(maxEnvelopes(STool.convertToIntArray("[[46,89],[50,53],[52,68],[72,45],[77,81]]"))).isEqualTo(3);
        assertThat(maxEnvelopes(STool.convertToIntArray(" [[30,50],[12,2],[3,4],[12,15]]"))).isEqualTo(3);
        assertThat(maxEnvelopes(STool.convertToIntArray(" [[5,4],[6,4],[6,7],[2,3]]"))).isEqualTo(3);
        assertThat(maxEnvelopes(STool.convertToIntArray(" [[1,1],[1,1],[1,1]]"))).isEqualTo(1);
        assertThat(maxEnvelopes(STool.convertToIntArray("[[15,8],[2,20],[2,14],[4,17],[8,19],[8,9],[5,7],[11,19],[8,11],[13,11],[2,13],[11,19],[8,11],[13,11],[2,13],[11,19],[16,1],[18,13],[14,17],[18,19]]"))).isEqualTo(5);
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1, a2) -> {
            if (a1[0] == a2[0])
                return Integer.compare(a2[1], a1[1]);
            else
                return Integer.compare(a1[0], a2[0]);
        });
        int memo[] = new int[envelopes.length];
        int cnt = 0;
        for (int[] envelope : envelopes) {
            int i = Arrays.binarySearch(memo, 0, cnt, envelope[1]);
            if (i < 0) {
                i = -i - 1;
            }
            memo[i] = envelope[1];
            if (i == cnt)
                cnt++;
        }

        return cnt;
    }

}
