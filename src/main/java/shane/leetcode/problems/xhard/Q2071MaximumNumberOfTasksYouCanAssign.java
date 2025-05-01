package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my
 */
public class Q2071MaximumNumberOfTasksYouCanAssign {

    @Test
    public void test() {
        assertThat(maxTaskAssign(new int[]{3, 2, 1}, new int[]{0, 3, 3}, 1, 1)).isEqualTo(3);
        assertThat(maxTaskAssign(new int[]{5, 4}, new int[]{0, 0, 0}, 1, 5)).isEqualTo(1);
        assertThat(maxTaskAssign(new int[]{10, 15, 30}, new int[]{0, 10, 10, 10, 10}, 3, 10)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(maxTaskAssign(new int[]{1, 2, 3, 4}, new int[]{0, 1, 2, 3}, 1, 4)).isEqualTo(4);
        assertThat(maxTaskAssign(new int[]{1, 2, 3, 4}, new int[]{2, 3, 4, 5}, 4, 1)).isEqualTo(4);
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0;
        int right = Math.min(tasks.length, workers.length);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int usedPills = 0;
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = workers.length - mid; i < workers.length; ++i) {
                treeMap.merge(workers[i], 1, Integer::sum);
            }

            boolean canAssign = true;
            for (int i = mid - 1; i >= 0; --i) {
                int strongestWorker = treeMap.lastKey();
                if (strongestWorker >= tasks[i]) {
                    if (treeMap.merge(strongestWorker, -1, Integer::sum) == 0)
                        treeMap.remove(strongestWorker);
                    continue;
                }
                Integer key = treeMap.ceilingKey(tasks[i] - strength);
                if (key == null || ++usedPills > pills) {
                    canAssign = false;
                    break;
                }
                if (treeMap.merge(key, -1, Integer::sum) == 0)
                    treeMap.remove(key);
            }
            if (canAssign) {
                left = mid;
                continue;
            }
            right = mid - 1;
        }
        return left;
    }

}
