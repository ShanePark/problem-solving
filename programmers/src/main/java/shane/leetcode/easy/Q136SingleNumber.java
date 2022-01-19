package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

public class Q136SingleNumber {
    public static void main(String[] args) {
        Assertions.assertEquals(singleNumber(new int[]{2, 2, 1}), 1);
        Assertions.assertEquals(singleNumber(new int[]{4, 1, 2, 1, 2}), 4);
        Assertions.assertEquals(singleNumber(new int[]{1}), 1);
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return -1;
    }
}
