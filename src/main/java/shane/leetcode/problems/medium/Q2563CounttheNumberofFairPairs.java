package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1123msBeats5.07%
 */
public class Q2563CounttheNumberofFairPairs {

    @Test
    public void test() {
        assertThat(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6)).isEqualTo(6);
        assertThat(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11)).isEqualTo(1);
    }

    @Test
    public void tle() {
        int[] nums = new int[100000];
        assertThat(countFairPairs(nums, 11, 11)).isEqualTo(0);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        List<Long> list = new ArrayList<>();
        long answer = 0;
        for (int num : nums) {
            answer += cnt(list, lower, upper, num);
            binaryInsert(list, num);
        }
        return answer;
    }

    private void binaryInsert(List<Long> list, long num) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < num) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        list.add(left, num);
    }

    private long cnt(List<Long> list, int lower, int upper, int num) {
        int left = 0;
        int right = list.size() - 1;
        int lowerBound = lower - num;
        int upperBound = upper - num;

        int leftIdx = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < lowerBound) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        leftIdx = left;

        left = 0;
        right = list.size() - 1;
        int rightIdx = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= upperBound) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        rightIdx = right;

        return rightIdx - leftIdx + 1;
    }

}
