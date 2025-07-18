package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2163MinimumDifferenceInSumsAfterRemovalOfElements {

    @Test
    public void est() {
        assertThat(minimumDifference(new int[]{3, 1, 2})).isEqualTo(-1);
        assertThat(minimumDifference(new int[]{7, 9, 5, 8, 1, 3})).isEqualTo(1);
    }

    public long minimumDifference(int[] nums) {
        int segmentSize = nums.length / 3;
        long[] left = new long[segmentSize + 1];
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < segmentSize; i++) {
            sum += nums[i];
            maxHeap.add(nums[i]);
        }
        left[0] = sum;
        for (int i = segmentSize; i < segmentSize * 2; i++) {
            sum += nums[i];
            maxHeap.add(nums[i]);
            sum -= maxHeap.poll();
            left[i - (segmentSize - 1)] = sum;
        }

        long rightSum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = segmentSize * 3 - 1; i >= segmentSize * 2; i--) {
            rightSum += nums[i];
            minHeap.add(nums[i]);
        }
        long answer = left[segmentSize] - rightSum;
        for (int i = segmentSize * 2 - 1; i >= segmentSize; i--) {
            rightSum += nums[i];
            minHeap.add(nums[i]);
            rightSum -= minHeap.poll();
            answer = Math.min(answer, left[i - segmentSize] - rightSum);
        }
        return answer;
    }

}
