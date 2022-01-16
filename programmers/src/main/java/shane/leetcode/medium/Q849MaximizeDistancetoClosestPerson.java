package shane.leetcode.medium;

import org.junit.jupiter.api.Assertions;

public class Q849MaximizeDistancetoClosestPerson {

    public static void main(String[] args) {
        Assertions.assertEquals(2, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        Assertions.assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0}));
        Assertions.assertEquals(1, maxDistToClosest(new int[]{0, 1}));
        Assertions.assertEquals(2, maxDistToClosest(new int[]{0, 0, 1}));
        Assertions.assertEquals(1, maxDistToClosest(new int[]{1, 0, 1}));
        Assertions.assertEquals(2, maxDistToClosest(new int[]{0, 0, 1, 0, 1, 1}));
        Assertions.assertEquals(2, maxDistToClosest(new int[]{0, 1, 1, 1, 0, 0, 1, 0, 0}));
        Assertions.assertEquals(3, maxDistToClosest(new int[]{0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1}));
        Assertions.assertEquals(5, maxDistToClosest(new int[]{1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}));
    }

    public static int maxDistToClosest(int[] seats) {

        int maxLength = 0, maxStartIndex = 0, maxEndIndex = 0;
        int currentLength = 0, currentZeroCount = 0, currentStartIndex = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                currentZeroCount++;
                currentLength = (currentStartIndex == 0 || i == seats.length - 1) ? currentZeroCount : (currentZeroCount + 1) / 2;
                if (maxLength <= currentLength) {
                    maxLength = currentLength;
                    maxStartIndex = currentStartIndex;
                    maxEndIndex = i;
                }
            } else {
                currentZeroCount = 0;
                if (i < seats.length - 1 && seats[i + 1] == 0) {
                    currentStartIndex = i + 1;
                }
            }
        }

        if (maxLength == 1)
            return 1;

        return maxLength;
    }
}
