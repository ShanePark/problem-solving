package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime159msBeats29.82%
 */
public class Q1865FindingPairsWithACertainSum {

    @Test
    public void test() {
        FindSumPairs fsp = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        assertThat(fsp.count(7)).isEqualTo(8);
        fsp.add(3, 2);
        assertThat(fsp.count(8)).isEqualTo(2);
        assertThat(fsp.count(4)).isEqualTo(1);
        fsp.add(0, 1);
        fsp.add(1, 1);
        assertThat(fsp.count(7)).isEqualTo(11);
    }

    class FindSumPairs {
        final Map<Integer, Integer> cnt1 = new HashMap<>();
        final int[] nums2;
        final Map<Integer, Integer> cnt2 = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            for (int i : nums1) {
                cnt1.merge(i, 1, Integer::sum);
            }
            this.nums2 = nums2;
            for (int i : nums2) {
                cnt2.merge(i, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            cnt2.merge(nums2[index], -1, Integer::sum);
            nums2[index] += val;
            cnt2.merge(nums2[index], 1, Integer::sum);
        }

        public int count(int tot) {
            int sum = 0;
            for (Map.Entry<Integer, Integer> e : cnt1.entrySet()) {
                int key = e.getKey();
                if (tot <= key)
                    continue;
                sum += e.getValue() * cnt2.getOrDefault(tot - key, 0);
            }
            return sum;
        }
    }

}
