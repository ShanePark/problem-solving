package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Runtime 209 ms Beats 7.68%
 * Memory 74.3 MB Beats 21.11%
 */
@SuppressWarnings("DuplicatedCode")
public class Q1345JumpGameIV4 {

    @Test
    void test() {
        Assertions.assertEquals(3, minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        Assertions.assertEquals(0, minJumps(new int[]{7}));
        Assertions.assertEquals(1, minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        Assertions.assertEquals(2, minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11}));
    }


    public static int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> valueIndexes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueIndexes.compute(arr[i], (k, v) -> valueIndexes.getOrDefault(k, new HashSet<>())).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (poll == arr.length - 1)
                    return step;
                // step back
                if (poll + 1 < arr.length && visited.add(poll + 1)) {
                    q.offer(poll + 1);
                }

                // step forward
                if (0 < poll && visited.add(poll - 1)) {
                    q.offer(poll - 1);
                }

                // teleport
                Set<Integer> warps = valueIndexes.get(arr[poll]);
                Set<Integer> used = new HashSet<>();
                for (Integer warp : warps) {
                    used.add(warp);
                    if (visited.add(warp)) {
                        q.offer(warp);
                    }
                }
                warps.removeAll(used);
            }
            step++;
        }
        return step;
    }

}
