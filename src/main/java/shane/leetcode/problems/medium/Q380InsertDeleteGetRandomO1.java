package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 75 ms Beats 28.38%
 * Memory 114.7 MB Beats 12.25%
 */
public class Q380InsertDeleteGetRandomO1 {

    @Test
    public void test() {
        RandomizedSet set = new RandomizedSet();
        assertThat(set.insert(1)).isTrue();
        assertThat(set.remove(2)).isFalse();
        assertThat(set.insert(2)).isTrue();
        assertThat(set.getRandom()).isIn(1, 2);
        assertThat(set.remove(1)).isTrue();
        assertThat(set.insert(2)).isFalse();
        assertThat(set.getRandom()).isEqualTo(2);
    }

    class RandomizedSet {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            int lastIndex = list.size() - 1;
            Integer lastVal = list.get(lastIndex);
            map.put(lastVal, index);
            map.remove(val);
            list.set(index, lastVal);
            list.remove(lastIndex);

            return true;
        }

        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

}
