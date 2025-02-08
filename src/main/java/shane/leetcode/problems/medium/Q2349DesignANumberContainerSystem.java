package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 84
 * ms
 * Beats
 * 47.95%
 */
public class Q2349DesignANumberContainerSystem {

    @Test
    public void test() {
        NumberContainers nc = new NumberContainers();
        assertThat(nc.find(10)).isEqualTo(-1);
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        assertThat(nc.find(10)).isEqualTo(1);
        nc.change(1, 20);
        assertThat(nc.find(10)).isEqualTo(2);
    }

    /**
     * ["NumberContainers","change","find","change","find","find","find"]
     * [[],[1,10],[10],[1,20],[10],[20],[30]]
     */
    @Test
    public void test2() {
        NumberContainers nc = new NumberContainers();
        nc.change(1, 10);
        assertThat(nc.find(10)).isEqualTo(1);
        nc.change(1, 20);
        assertThat(nc.find(10)).isEqualTo(-1);
        assertThat(nc.find(20)).isEqualTo(1);
        assertThat(nc.find(30)).isEqualTo(-1);
    }

    class NumberContainers {

        final private Map<Integer, Integer> indexes = new HashMap<>();
        final private Map<Integer, TreeSet<Integer>> numbers = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            Integer old = indexes.get(index);
            if (old != null) {
                numbers.get(old).remove(index);
            }
            indexes.put(index, number);
            TreeSet<Integer> tree = numbers.computeIfAbsent(number, k -> new TreeSet<>());
            tree.add(index);
        }

        public int find(int number) {
            TreeSet<Integer> tree = numbers.get(number);
            if (tree == null || tree.isEmpty())
                return -1;
            return tree.first();
        }
    }

}
