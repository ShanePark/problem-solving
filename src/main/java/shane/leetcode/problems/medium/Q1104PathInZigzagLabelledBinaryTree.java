package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1104PathInZigzagLabelledBinaryTree {

    @Test
    public void test() {
        assertThat(pathInZigZagTree(14)).containsExactly(1, 3, 4, 14);
        assertThat(pathInZigZagTree(26)).containsExactly(1, 2, 6, 10, 26);
    }

    public List<Integer> pathInZigZagTree(int label) {

        int currentLocation = label;

        int level = Integer.toBinaryString(label).length();
        if (level % 2 == 0) {
            int startLevel = (int) Math.pow(2, level - 1);
            int endLevel = (int) Math.pow(2, level) - 1;
            currentLocation = endLevel - (label - startLevel);
        }

        List<Integer> list = up(currentLocation);
        list.set(list.size() - 1, label);
        return list;
    }

    public List<Integer> up(int location) {
        if (location == 0)
            return Collections.emptyList();

        List<Integer> list = new ArrayList<>();

        int level = Integer.toBinaryString(location).length();
        int startLevel = (int) Math.pow(2, level - 1);
        int endLevel = (int) Math.pow(2, level) - 1;

        if (level % 2 == 0) {
            // there is fake number on current location
            int fake = endLevel - (location - startLevel);
            list.add(fake);
            list.addAll(0, up(location / 2));
        } else {
            // current location is real
            list.add(location);
            list.addAll(0, up(location / 2));
        }

        return list;
    }
}
