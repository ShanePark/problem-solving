package shane.leetcode.contest.weekly.w320;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 161 ms Beats 66.67%
 * Memory 172.9 MB Beats 33.33%
 */
public class Q3_2 {

    @Test
    public void test() {
        assertThat(minimumFuelCost(STool.convertToIntArray("[[0,1],[2,1],[3,2],[4,2],[4,5],[6,0],[5,7],[8,4],[9,2]]"), 2)).isEqualTo(16);
        assertThat(minimumFuelCost(STool.convertToIntArray("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]"), 2)).isEqualTo(7);
        assertThat(minimumFuelCost(STool.convertToIntArray("[[0,1],[0,2],[1,3],[1,4]]"), 5)).isEqualTo(4);
        assertThat(minimumFuelCost(STool.convertToIntArray("[[0,1],[0,2],[0,3]]"), 5)).isEqualTo(3);
        assertThat(minimumFuelCost(STool.convertToIntArray("[]"), 1)).isEqualTo(0);
    }

    public long minimumFuelCost(int[][] roads, int seats) {

        Map<Integer, Town> towns = new HashMap<>();
        for (int i = 0; i < roads.length + 1; i++) {
            towns.put(i, new Town(i, seats));
        }

        for (int[] road : roads) {
            Town town1 = towns.get(road[0]);
            Town town2 = towns.get(road[1]);
            town1.addNextTown(town2);
            town2.addNextTown(town1);
        }

        Town capital = towns.get(0);
        long totalCost = 0;

        for (Town town : capital.next) {
            totalCost += town.drive(capital);
        }
        return totalCost;
    }

    class Town {
        final int index;
        final int seats;
        int people = 1;
        List<Town> next = new ArrayList<>();

        public Town(int index, int seats) {
            this.index = index;
            this.seats = seats;
        }

        public void addNextTown(Town town) {
            next.add(town);
        }

        long drive(Town prev) {
            long totalFuel = 0;
            for (Town next : this.next) {
                if (next != prev) {
                    totalFuel += next.drive(this);
                    this.people += next.people;
                }
            }
            return totalFuel + ((this.people - 1) / seats) + 1;
        }
    }

}
