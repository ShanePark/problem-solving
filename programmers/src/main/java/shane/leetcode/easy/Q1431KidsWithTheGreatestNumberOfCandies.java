package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Q1431KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        List<Boolean> result = kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        Assertions.assertEquals(true, result.get(0));
        Assertions.assertEquals(true, result.get(1));
        Assertions.assertEquals(true, result.get(2));
        Assertions.assertEquals(false, result.get(3));
        Assertions.assertEquals(true, result.get(4));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> list = new ArrayList<>();
        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }
        return list;
    }
}
