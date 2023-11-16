package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 32.73%of users with Java
 * Memory Details 40.73MB Beats 41.82%of users with Java
 */
public class Q1980FindUniqueBinaryString {

    @Test
    public void test() {
        assertThat(findDifferentBinaryString(new String[]{"00", "01"})).isEqualTo("10");
        assertThat(findDifferentBinaryString(new String[]{"01", "10"})).isEqualTo("00");
        assertThat(findDifferentBinaryString(new String[]{"111", "011", "001"})).isEqualTo("000");
    }

    public String findDifferentBinaryString(String[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String num : nums) {
            Integer i = Integer.valueOf(num, 2);
            pq.offer(i);
        }
        int until = (int) Math.pow(2, nums[0].length());
        for (int i = 0; i < until; i++) {
            Integer poll = pq.poll();
            if (poll == null || poll != i) {
                StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
                int diff = nums[0].length() - sb.length();
                for (int j = 0; j < diff; j++) {
                    sb.insert(0, "0");
                }
                return sb.toString();
            }
        }
        return "";
    }

}
