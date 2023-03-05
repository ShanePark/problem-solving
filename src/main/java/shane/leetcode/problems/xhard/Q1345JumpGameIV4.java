package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


/**
 * Runtime 141 ms Beats 16.84%
 * Memory 77.3 MB Beats 20.90%
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
        visited.add(0);
        int step = 0;

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Integer poll = q.poll();
                if (poll == arr.length - 1)
                    return step;
                Set<Integer> next = valueIndexes.get(arr[poll]);
                if (poll + 1 < arr.length && visited.add(poll + 1)) {
                    q.add(poll + 1);
                }
                if (0 < poll && visited.add(poll - 1)) {
                    q.add(poll - 1);
                }
                for (Integer warp : next) {
                    if (visited.add(warp)) {
                        q.offer(warp);
                    }
                }
                next.clear();
            }
            step++;
        }
        throw new IllegalStateException();
    }

}
