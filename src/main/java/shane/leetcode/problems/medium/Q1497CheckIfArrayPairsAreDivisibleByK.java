package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime28msBeats52.67%
 */
public class Q1497CheckIfArrayPairsAreDivisibleByK {

    @Test
    public void test() {
        assertThat(canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3)).isTrue();
        assertThat(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5)).isTrue();
        assertThat(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7)).isTrue();
        assertThat(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10)).isFalse();
    }

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> modCnt = new HashMap<>();
        for (int i : arr) {
            int mod = i % k;
            if (mod < 0) {
                mod += k;
            }
            modCnt.merge(mod, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : modCnt.entrySet()) {
            Integer mod = e.getKey();
            if (mod == 0) {
                if (e.getValue() % 2 == 1) {
                    return false;
                }
                continue;
            }
            int partner = k - mod;
            int partnerCnt = modCnt.getOrDefault(partner, 0);
            if (partnerCnt != e.getValue()) {
                return false;
            }
        }
        return true;
    }

}
