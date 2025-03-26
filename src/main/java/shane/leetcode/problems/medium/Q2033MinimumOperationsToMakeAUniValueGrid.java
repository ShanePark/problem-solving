package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2033MinimumOperationsToMakeAUniValueGrid {

    @Test
    public void est() {
        assertThat(minOperations(Ps.intArray("[[2,4],[6,8]]"), 2)).isEqualTo(4);
        assertThat(minOperations(Ps.intArray("[[1,5],[2,3]]"), 1)).isEqualTo(5);
        assertThat(minOperations(Ps.intArray("[[1,2],[3,4]]"), 2)).isEqualTo(-1);
    }

    @Test
    public void test2() {
        assertThat(minOperations(Ps.intArray("[[596,904,960,232,120,932,176],[372,792,288,848,960,960,764],[652,92,904,120,680,904,120],[372,960,92,680,876,624,904],[176,652,64,344,316,764,316],[820,624,848,596,960,960,372],[708,120,456,92,484,932,540]]"),
                28)).isEqualTo(473);
        assertThat(minOperations(Ps.intArray("[[529,529,989],[989,529,345],[989,805,69]]"), 92)).isEqualTo(25);
        assertThat(minOperations(Ps.intArray("[[980,476,644,56],[644,140,812,308],[812,812,896,560],[728,476,56,812]]"), 84)).isEqualTo(45);
        assertThat(minOperations(Ps.intArray("[[931,128],[639,712]]"), 73)).isEqualTo(12);
        assertThat(minOperations(Ps.intArray("[[146]]"), 86)).isEqualTo(0);
    }

    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        for (int[] ints : grid) {
            for (int anInt : ints) {
                nums.add(anInt);
            }
        }
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int mod = median % x;
        int answer = 0;
        for (Integer num : nums) {
            if (num % x != mod)
                return -1;
            answer += Math.abs(median - num) / x;
        }
        return answer;
    }

}
