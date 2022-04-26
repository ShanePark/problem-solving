package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Assertions;

import java.util.*;


/**
 * 01/15/2022 23:03	Accepted	99 ms	145.4 MB	java
 */
public class Q1345JumpGameIV {

    public static void main(String[] args) {
        Assertions.assertEquals(3, minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        Assertions.assertEquals(0, minJumps(new int[]{7}));
        Assertions.assertEquals(1, minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
    }

    /**
     * @param arr
     * @return
     */
    public static int minJumps(int[] arr) {

        if (arr.length == 1)
            return 0;

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = valueMap.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                valueMap.put(arr[i], list);
            }
            list.add(i);
        }

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
                List<Integer> sameNumberIndexes = valueMap.get(arr[integer]);
                if (sameNumberIndexes != null) {
                    for (Integer sameNumberIndex : sameNumberIndexes) {
                        if (dp[sameNumberIndex] == -1) {
                            dp[sameNumberIndex] = step;
                            temp.add(sameNumberIndex);
                        }
                    }
                }
                sameNumberIndexes.clear(); // It was the point. !!! it do not clear it, it do the duplicated jobs a lot.

            }
            step++;
            set = temp;

        }

    }

}
