package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1642FurthestBuildingYouCanReach3 {

    @Test
    public void test() throws IOException {
        assertThat(furthestBuilding(new int[]{1, 13, 1, 1, 13, 5, 11, 11}, 10, 8)).isEqualTo(7);
        assertThat(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1)).isEqualTo(4);
        assertThat(furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2)).isEqualTo(7);

        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q1642FurthestBuildingYouCanReach.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        // 49s -> 28s -> 112ms
        assertThat(furthestBuilding(arr, 926413609, 24790)).isEqualTo(72329);
    }


    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (0 < diff) {
                bricks -= diff;
                pq.offer(diff);
                while (ladders > 0 && bricks < 0) {
                    ladders--;
                    bricks += pq.poll();
                }
                if (bricks < 0)
                    return i - 1;
            }
        }
        return heights.length - 1;
    }

}
