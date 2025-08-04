package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 142
 * ms
 * Beats
 * 5.17%
 */
public class Q904FruitIntoBaskets2 {

    @Test
    public void test() {
        assertThat(totalFruit(new int[]{1, 2, 1})).isEqualTo(3);
        assertThat(totalFruit(new int[]{0, 1, 2, 2})).isEqualTo(3);
        assertThat(totalFruit(new int[]{1, 2, 3, 2, 2})).isEqualTo(4);
    }

    public int totalFruit(int[] fruits) {
        int right = -1;
        Map<Integer, Integer> cnt = new HashMap<>();
        int max = 0;
        for (int fruit : fruits) {
            while (right < fruits.length - 1 && cnt.size() <= 2) {
                cnt.merge(fruits[++right], 1, Integer::sum);
                if (cnt.size() == 3)
                    break;
                max = Math.max(max, cnt.values().stream().mapToInt(Integer::valueOf).sum());
            }
            cnt.merge(fruit, -1, Integer::sum);
            if (cnt.get(fruit) == 0)
                cnt.remove(fruit);
        }
        return max;
    }

}
