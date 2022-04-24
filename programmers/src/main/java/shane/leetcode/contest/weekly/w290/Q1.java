package shane.leetcode.contest.weekly.w290;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(intersection(STool.convertToIntArray("[[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]"))).containsExactly(3, 4);
        assertThat(intersection(STool.convertToIntArray("[[1,2,3],[4,5,6]]"))).isEmpty();
        assertThat(intersection(STool.convertToIntArray("[[7,34,45,10,12,27,13],[27,21,45,10,12,13]]"))).containsExactly(10, 12, 13, 27, 45);
    }

    public List<Integer> intersection(int[][] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int j : nums[i]) {
                l.add(j);
            }
            list.add(l);
        }
        List<Integer> answer = list.get(0);
        for (List<Integer> l : list) {
            answer.retainAll(l);
        }
        Collections.sort(answer);
        return answer;
    }


}
