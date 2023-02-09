package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 65 ms Beats 30.6%
 * Memory 51.2 MB Beats 78.10%
 */
public class Q904FruitIntoBaskets {

    @Test
    public void test() {
        assertThat(totalFruit(new int[]{0, 1, 2, 2})).isEqualTo(3);
        assertThat(totalFruit(new int[]{1, 2, 1})).isEqualTo(3);
        assertThat(totalFruit(new int[]{1, 2, 3, 2, 2})).isEqualTo(4);
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < fruits.length; i++) {
            int fruit = fruits[i];
            if (cnt.size() == 2 && !cnt.containsKey(fruit)) {
                Integer lastFruit = fruits[i - 1];
                while (cnt.get(lastFruit) > 0) {
                    Integer poll = q.poll();
                    Integer merge = cnt.merge(poll, -1, Integer::sum);
                    if (merge == 0) {
                        cnt.remove(poll);
                        break;
                    }
                }
            }
            cnt.merge(fruit, 1, Integer::sum);
            q.offer(fruit);
            max = Math.max(max, q.size());
        }
        return max;
    }

}
