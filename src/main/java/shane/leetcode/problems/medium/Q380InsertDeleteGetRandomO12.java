package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 28 ms Beats 54.96% of users with Java
 */
public class Q380InsertDeleteGetRandomO12 {

    @Test
    public void test() {
        RandomizedSet set = new RandomizedSet();
        assertThat(set.insert(3)).isTrue();
        assertThat(set.insert(3)).isFalse();
        assertThat(set.getRandom()).isIn(3);
        assertThat(set.getRandom()).isIn(3);
        assertThat(set.insert(1)).isTrue();
        assertThat(set.remove(3)).isTrue();
        assertThat(set.getRandom()).isIn(1);
        assertThat(set.getRandom()).isIn(1);
        assertThat(set.insert(0)).isTrue();
        assertThat(set.remove(0)).isTrue();
    }

    class RandomizedSet {

        private final Map<Integer, Integer> indexValue = new HashMap<>();
        private final Map<Integer, Integer> valueIndex = new HashMap<>();
        private final Random random = new Random();

        private int curSize = 0;

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (valueIndex.containsKey(val))
                return false;
            indexValue.put(curSize, val);
            valueIndex.put(val, curSize);
            curSize++;
            return true;
        }

        public boolean remove(int val) {
            Integer index = valueIndex.get(val);
            if (index == null)
                return false;
            valueIndex.remove(val);
            indexValue.remove(index);

            curSize--;
            // Swap with curSize
            if (curSize == 0 || index == curSize)
                return true;
            int old = indexValue.get(curSize);
            indexValue.put(index, old);
            valueIndex.put(old, index);

            return true;
        }

        public int getRandom() {
            int index = random.nextInt(curSize);
            return indexValue.get(index);
        }

    }

}
