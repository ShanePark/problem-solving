package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime315msBeats5.11%
 */
public class Q632SmallestRangeCoveringElementsFromKLists {

    @Test
    public void test() {
        assertThat(smallestRange(Ps.intList("[" +
                "[-89,1,69,89,90,98]," +
                "[-43,-36,-24,-14,49,61,66,69]," +
                "[73,94,94,96]," +
                "[11,13,76,79,90]," +
                "[-40,-20,1,9,12,12,14]," +
                "[-91,-31,0,21,25,26,28,29,29,30]," +
                "[23,88,89]" +
                ",[31,42,42,57]" +
                ",[-2,6,11,12,12,13,15]" +
                ",[-3,25,34,36,39]" +
                ",[-7,3,29,29,31,32,33]" +
                ",[4,11,14,15,15,18,19]" +
                ",[-34,9,12,19,19,19,19,20]" +
                ",[-26,4,47,53,64,64,64,64,64,65]" +
                ",[-51,-25,36,38,50,54]" +
                ",[17,25,38,38,38,38,40]" +
                ",[-30,12,15,19,19,20,22]" +
                ",[-14,-13,-10,68,69,69,72,74,75]" +
                ",[-39,42,70,70,70,71,72,72,73]" +
                ",[-67,-34,6,26,28,28,28,28,29,30,31]]")))
                .isEqualTo(new int[]{13, 73});
        assertThat(smallestRange(Ps.intList("[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]"))).isEqualTo(new int[]{20, 24});
        assertThat(smallestRange(Ps.intList("[[1,2,3], [1,2,3], [1,2,3]]"))).isEqualTo(new int[]{1, 1});
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<Element> treeSet = new TreeSet<>();
        int[] answer;
        for (int i = 0; i < nums.size(); i++) {
            treeSet.add(new Element(i, nums.get(i).get(0)));
        }

        int min = treeSet.first().value;
        int max = treeSet.last().value;
        answer = new int[]{min, max};
        int minRange = max - min;

        while (true) {
            Element first = treeSet.pollFirst();
            List<Integer> list = nums.get(first.index);
            if (list.isEmpty()) {
                return answer;
            }
            treeSet.add(new Element(first.index, list.remove(0)));
            System.err.println();
            min = treeSet.first().value;
            max = treeSet.last().value;
            if (max - min < minRange) {
                minRange = max - min;
                answer = new int[]{min, max};
            }
            System.err.println();
        }
    }

    static class Element implements Comparable<Element> {
        final int index;
        final int value;

        @Override
        public int compareTo(Element o) {
            if (this.value == o.value) {
                return o.index - this.index;
            }
            return this.value - o.value;
        }

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

}
