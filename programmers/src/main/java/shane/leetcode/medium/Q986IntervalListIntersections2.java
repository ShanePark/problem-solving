package shane.leetcode.medium;

import com.tistory.shanepark.STool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Failed.
 */
public class Q986IntervalListIntersections2 {
    public static void main(String[] args) {
        String firstList = "[[0,2],[5,10],[13,23],[24,25]]";
        String secondList = "[[1,5],[8,12],[15,24],[25,26]]";
        int[][] result = intervalIntersection(STool.convertToIntArray(firstList), STool.convertToIntArray(secondList));
        for (int[] ints : result) {
            STool.printArray(ints);
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        return null;
    }
}
