package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Q846HandOfStraights {

    @Test
    public void test() {
        assertThat(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3)).isTrue();
        assertThat(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4)).isFalse();
        assertThat(isNStraightHand(new int[]{53, 78, 62, 108, 83, 56, 66, 110, 49, 104, 117, 123, 86, 131, 94, 107, 84, 103, 42, 127, 100, 50, 55, 97, 81, 93, 71, 45, 63, 39, 91, 87, 129, 126, 84, 125, 73, 95, 116, 47, 106, 52, 121, 54, 38, 68, 69, 76, 89, 90, 57, 67, 86, 114, 64, 87, 79, 92, 115, 60, 51, 105, 132, 101, 59, 130, 44, 85, 80, 82, 48, 65, 128, 102, 74, 61, 40, 46, 98, 111, 109, 119, 72, 43, 112, 120, 58, 113, 77, 88, 41, 118, 75, 85, 124, 122, 96, 83, 99, 70},
                50)).isTrue();
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> cnt = new TreeMap<>();
        for (int i : hand) {
            cnt.merge(i, 1, Integer::sum);
        }
        for (int n : cnt.keySet()) {
            if (cnt.get(n) <= 0) {
                continue;
            }
            for (int i = groupSize - 1; i >= 0; i--) {
                if (cnt.getOrDefault(n + i, 0) < cnt.get(n))
                    return false;
                cnt.put(n + i, cnt.get(n + i) - cnt.get(n));
            }
        }
        return true;
    }

}
