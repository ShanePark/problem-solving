package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Failed.
 */
public class Q986IntervalListIntersections1 {
    public static void main(String[] args) {
        String firstList = "[[0,2],[5,10],[13,23],[24,25]]";
        String secondList = "[[1,5],[8,12],[15,24],[25,26]]";
        int[][] result = intervalIntersection(STool.convertToIntArray(firstList), STool.convertToIntArray(secondList));
        for (int[] ints : result) {
            STool.printArray(ints);
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Set<Integer> first = toSet(firstList);
        first.retainAll(toSet(secondList));

        List<Integer> list = first.stream().sorted().collect(Collectors.toList());

        if (list.size() == 0) {
            return new int[][]{};
        }

        List<int[]> result = new ArrayList<>();
        int before = list.get(0);
        int remember = before;

        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur != before + 1) {
                result.add(new int[]{remember, before});
                remember = cur;
            }
            before = cur;
        }
        result.add(new int[]{remember, list.get(list.size() - 1)});

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static Set<Integer> toSet(int[][] firstList) {
        Set<Integer> set = new HashSet<>();
        for (int[] ints : firstList) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                set.add(i);
            }
        }
        return set;
    }
}
