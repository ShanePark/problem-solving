package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2079WateringPlants {

    @Test
    public void test() {
        assertThat(wateringPlants(new int[]{2, 2, 3, 3}, 5)).isEqualTo(14);
        assertThat(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4)).isEqualTo(30);
    }

    public int wateringPlants(int[] plants, int capacity) {
        int cnt = 0;
        int complete = 0;
        int water = capacity;

        while (complete < plants.length) {
            if (plants[complete] <= water) {
                water -= plants[complete++];
                cnt++;
            } else {
                cnt += 2 * complete;
                water = capacity;
            }
        }

        return cnt;
    }
}
