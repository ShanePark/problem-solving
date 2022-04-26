package shane.leetcode.contest.biweekly.w73;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2191SortTheJumbledNumbers {

    @Test
    void test() {
        assertThat(sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})).containsExactly(338, 38, 991);
        assertThat(sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{789, 456, 123})).containsExactly(123, 456, 789);
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Num> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Num(nums[i], mapping, i));
        }
        list.sort((o1, o2) -> {
            if (o1.newNum == o2.newNum) {
                return o1.originalIndex - o2.originalIndex;
            } else {
                return o1.newNum - o2.newNum;
            }
        });
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).original;
        }
        return answer;
    }

    class Num {
        int original;
        int newNum;
        int originalIndex;

        public Num(int original, int[] mapping, int originalIndex) {
            this.original = original;
            this.originalIndex = originalIndex;
            String str = String.valueOf(original);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                sb.append(mapping[str.charAt(i) - '0']);
            }
            this.newNum = Integer.parseInt(sb.toString());
        }

        @Override
        public String toString() {
            return "Num{" +
                    "original=" + original +
                    ", newNum=" + newNum +
                    ", originalIndex=" + originalIndex +
                    '}';
        }
    }

}
