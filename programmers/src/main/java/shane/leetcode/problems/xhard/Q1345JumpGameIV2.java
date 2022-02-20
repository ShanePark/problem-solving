package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 	Time Limit Exceeded
 */
@SuppressWarnings("DuplicatedCode")
public class Q1345JumpGameIV2 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        Assertions.assertEquals(0, minJumps(new int[]{7}));
        Assertions.assertEquals(1, minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        Assertions.assertEquals(2, minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11}));
    }

    static int[] dp;

    public static int minJumps(int[] arr) {

        if (arr.length == 1)
            return 0;

        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        int step = 0;

        while (true) {
            Set<Integer> temp = new HashSet<>();
            for (Integer integer : set) {
                if (integer == arr.length - 1) {
                    return step;
                }

                // forward
                if (integer < arr.length - 1 && dp[integer + 1] == -1) {
                    dp[integer + 1] = step;
                    temp.add(integer + 1);
                }

                // backward
                if (integer >= 1 && dp[integer - 1] == -1) {
                    dp[integer - 1] = step;
                    temp.add(integer - 1);
                }

                // jump
                for (int i = 0; i < arr.length; i++) {
                    if (dp[i] > 0)
                        continue;
                    if (arr[i] == arr[integer]) {
                        dp[i] = step;
                        temp.add(i);
                    }
                }

            }
            step++;
            set = temp;

        }

    }

}
