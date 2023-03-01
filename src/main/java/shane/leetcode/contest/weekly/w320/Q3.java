package shane.leetcode.contest.weekly.w320;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * couldn't pass the first case
 */
public class Q3 {

    @Test
    public void test() {
//        assertThat(minimumFuelCost(Ps.intArray("[[0,1],[2,1],[3,2],[4,2],[4,5],[6,0],[5,7],[8,4],[9,2]]"), 2)).isEqualTo(16);
        assertThat(minimumFuelCost(Ps.intArray("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]"), 2)).isEqualTo(7);
        assertThat(minimumFuelCost(Ps.intArray("[[0,1],[0,2],[1,3],[1,4]]"), 5)).isEqualTo(4);
        assertThat(minimumFuelCost(Ps.intArray("[[0,1],[0,2],[0,3]]"), 5)).isEqualTo(3);
        assertThat(minimumFuelCost(Ps.intArray("[]"), 1)).isEqualTo(0);
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0)
            return 0;
        Map<Integer, Town> towns = new LinkedHashMap<>();
        for (int[] road : roads) {
            int key1 = road[0];
            int key2 = road[1];
            Town town1 = towns.getOrDefault(key1, new Town(key1, seats));
            Town town2 = towns.getOrDefault(key2, new Town(key2, seats));

            towns.put(key1, town1);
            towns.put(key2, town2);

            town1.addNext(key2);
            town2.addNext(key1);
        }

        List<Integer> wayFromCapital = new ArrayList<>();
        wayFromCapital.add(0);
        dfs(towns.get(0), wayFromCapital, towns);

        List<Integer> sortedTowns = towns.values()
                .stream()
                .sorted(Comparator.comparingInt(t -> -t.distance))
                .map(t -> t.index)
                .collect(Collectors.toList());

        int totalFuel = 0;
        for (int i : sortedTowns) {
            Town town = towns.get(i);
            int fuel = town.driveCar(towns, 0);
            totalFuel += fuel;
        }

        return totalFuel;
    }

    private void dfs(Town town, List<Integer> wayFromCapital, Map<Integer, Town> towns) {
        town.wayToCapital(wayFromCapital);
        for (Integer next : town.next) {
            if (!wayFromCapital.contains(next)) {
                wayFromCapital.add(next);
                dfs(towns.get(next), wayFromCapital, towns);
                wayFromCapital.remove(next);
            }
        }
    }

    class Town {
        int index;
        List<Integer> next = new ArrayList<>();
        List<Integer> toCapital = new ArrayList<>();
        int distance;
        int seats;
        int occupied = 1;

        public Town(int index, int seats) {
            this.index = index;
            this.seats = seats;
        }

        public void addNext(int townIndex) {
            next.add(townIndex);
        }

        public void wayToCapital(List<Integer> wayFromCapital) {
            this.toCapital = new ArrayList<>();
            for (int i : wayFromCapital) {
                this.toCapital.add(0, i);
            }
            this.distance = toCapital.size() - 1;
        }

        @Override
        public String toString() {
            return "Town{" +
                    "index=" + index +
                    ", toCapital=" + toCapital +
                    '}';
        }

        public int driveCar(Map<Integer, Town> towns, int currentFuel) {
            if (this.index == 0)
                return currentFuel;

            Town next = towns.get(this.toCapital.get(1));

            if (next.seats - next.occupied >= this.occupied) {
                next.occupied += this.occupied;
                return currentFuel + 1;
            }

            return next.driveCar(towns, currentFuel + 1);
        }
    }

}
