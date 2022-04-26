package shane.leetcode.contest.weekly.w284;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2200FindAllKDistantIndicesInAnArray {

    @Test
    void test(){
        Assertions.assertThat(findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key) {
                keys.add(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (Integer v : keys) {
                if(Math.abs(i - v) <= k) {
                    answer.add(i);
                    break;
                }
            }
        }

        return answer;
    }

}
