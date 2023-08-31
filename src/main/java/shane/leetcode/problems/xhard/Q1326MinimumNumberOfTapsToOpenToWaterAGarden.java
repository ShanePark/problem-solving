package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 23ms Beats 5.67%of users with Java
 * Memory Details 44.42MB Beats 27.53%of users with Java
 */
public class Q1326MinimumNumberOfTapsToOpenToWaterAGarden {

    @Test
    public void test() {
        assertThat(minTaps(5, new int[]{3, 4, 1, 1, 0, 0})).isEqualTo(1);
        assertThat(minTaps(5, new int[]{3, 0, 1, 1, 0, 0})).isEqualTo(-1);
        assertThat(minTaps(4, new int[]{0, 1, 0, 0, 1})).isEqualTo(-1);
        assertThat(minTaps(35, new int[]{1, 0, 4, 0, 4, 1, 4, 3, 1, 1, 1, 2, 1, 4, 0, 3, 0, 3, 0, 3, 0, 5, 3, 0, 0, 1, 2, 1, 2, 4, 3, 0, 1, 0, 5, 2})).isEqualTo(6);
        assertThat(minTaps(25, new int[]{3, 0, 1, 5, 4, 1, 4, 2, 4, 4, 3, 3, 3, 0, 3, 2, 5, 1, 5, 5, 2, 3, 1, 0, 2, 4})).isEqualTo(4);
        assertThat(minTaps(7, new int[]{1, 2, 1, 0, 2, 1, 0, 1})).isEqualTo(3);
        assertThat(minTaps(17, new int[]{0, 3, 3, 2, 2, 4, 2, 1, 5, 1, 0, 1, 2, 3, 0, 3, 1, 1})).isEqualTo(3);
        assertThat(minTaps(3, new int[]{0, 0, 0, 0})).isEqualTo(-1);
    }

    public int minTaps(int n, int[] ranges) {
        List<Tab> tabs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int range = ranges[i];
            if (range == 0)
                continue;
            Tab tab = new Tab(i, i - range, i + range, range);
            tabs.add(tab);
        }
        Collections.sort(tabs);

        int currentMax = -1;
        int tabIndex = 0;
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            if (i < currentMax || (i == currentMax && currentMax == n)) {
                continue;
            }
            Tab tabToUse = null;
            for (int j = tabIndex; j < tabs.size(); j++) {
                Tab candidate = tabs.get(j);
                if (i < candidate.from)
                    break;
                if (candidate.contains(i)) {
                    if (tabToUse == null) {
                        tabToUse = candidate;
                    }
                    if (tabToUse.to <= candidate.to) {
                        tabToUse = candidate;
                    }
                }
            }
            if (tabToUse == null)
                return -1;
            currentMax = tabToUse.to;
            tabIndex++;
            answer++;
        }

        return answer;
    }

    class Tab implements Comparable {
        int index;
        int from;
        int to;
        int range;

        @Override
        public String toString() {
            return "Tab{" +
                    "index=" + index +
                    ", from=" + from +
                    ", to=" + to +
                    ", range=" + range +
                    '}';
        }

        public Tab(int index, int from, int to, int range) {
            this.index = index;
            this.from = from;
            this.to = to;
            this.range = range;
        }

        @Override
        public int compareTo(Object o) {
            Tab tab2 = (Tab) o;
            if (this.from == tab2.from) {
                return Integer.compare(-this.to, -tab2.to);
            }
            return Integer.compare(this.from, tab2.from);
        }

        public boolean contains(int i) {
            return from <= i && i <= to;
        }
    }

}
