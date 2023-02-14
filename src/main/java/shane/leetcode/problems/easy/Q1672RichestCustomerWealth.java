package shane.leetcode.problems.easy;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Assertions;

public class Q1672RichestCustomerWealth {

    public static void main(String[] args) {
        Assertions.assertEquals(6, maximumWealth(Ps.intArray("[[1,2,3],[3,2,1]]")));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int num = 0;
            for (int i : account) {
                num += i;
            }
            max = Math.max(max, num);
        }
        return max;
    }
}
