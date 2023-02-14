package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrong Answer
 */
public class Q312BurstBallons {
    public static void main(String[] args) {
//        Assertions.assertEquals(167, maxCoins(new int[]{3, 1, 5, 8}));
        Assertions.assertEquals(1086136, maxCoins(new int[]{9, 76, 64, 21, 97, 60}));
    }

    public static int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int sum = 0;

        while (list.size() > 0) {
            int target = findTarget(list);
            sum += calc(list, target);
        }

        return sum;
    }

    private static int calc(List<Integer> list, int index) {
        int left = index == 0 ? 1 : list.get(index - 1);
        int middle = list.get(index);
        int right = index == list.size() - 1 ? 1 : list.get(index + 1);
        list.remove(index);
        return left * middle * right;
    }

    private static int findTarget(List<Integer> list) {
        if (list.size() == 1)
            return 0;
        if (list.size() == 2) {
            return list.get(0) < list.get(1) ? 0 : 1;
        }
        for (int i = 0; i <= 100; i++) {
            for (int j = 1; j < list.size() - 1; j++) {
                if (list.get(j) == i) {
                    return j;
                }
            }
        }
        return -1;
    }
}
