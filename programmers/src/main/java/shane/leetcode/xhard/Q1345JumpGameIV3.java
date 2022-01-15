package shane.leetcode.xhard;

import org.junit.jupiter.api.Assertions;

import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class Q1345JumpGameIV3 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        Assertions.assertEquals(0, minJumps(new int[]{7}));
        Assertions.assertEquals(1, minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        Assertions.assertEquals(2, minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11}));
    }


    public static int minJumps(int[] arr) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = valueMap.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                valueMap.put(arr[i], list);
            }
            list.add(i);
        }

        Queue<Integer> q = new LinkedList();
        q.offer(0);
        dp[0] = 0;
        int step = 0;

        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == arr.length - 1)
                    return step;
                List<Integer> next = valueMap.get(arr[i]);
                next.add(i - 1);
                next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < arr.length && dp[j] == -1) {
                        dp[j] = step + 1;
                        q.offer(j);
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;

    }

}
