package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 929 ms, faster than 5.02% of Java online submissions for Minimum Number of Refueling Stops.
 * Memory Usage: 143.5 MB, less than 5.02% of Java online submissions for Minimum Number of Refueling Stops.
 */
@SuppressWarnings("ALL")
public class Q871MinimumNumberOfRefuelingStops2 {

    @Test
    public void test() {
        assertThat(minRefuelStops(100, 10, Ps.intArray("[[10,60],[20,30],[30,30],[60,40]]"))).isEqualTo(2);
        assertThat(minRefuelStops(100, 1, Ps.intArray("[[10,100]]"))).isEqualTo(-1);
        assertThat(minRefuelStops(1, 1, Ps.intArray("[]"))).isEqualTo(0);
    }

    /**
     * 46 ms
     */
    @Test
    public void tle() {
        assertThat(minRefuelStops(1000, 1, Ps.intArray("[[1,186],[145,161],[183,43],[235,196],[255,169],[263,200],[353,161],[384,190],[474,44],[486,43],[567,48],[568,96],[592,36],[634,181],[645,167],[646,69],[690,52],[732,28],[800,42],[857,55],[922,63],[960,141],[973,13],[977,112],[997,162]]")))
                .isEqualTo(6);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Car> q = new LinkedList<>();
        q.offer(new Car(startFuel));
        for (int[] station : stations) {
            int size = q.size();
            if (size == 0) {
                return -1;
            }
            List<Car> list = new ArrayList<>();
            while (!q.isEmpty()) {
                Car car = q.poll();
                if (car.canReach(station)) {
                    list.add(car.moveToStation(station));
                    car.skipStation(station);
                    list.add(car);
                }
            }
            Map<Integer, Car> map = new HashMap<>();
            for (Car car : list) {
                Car cntMin = map.get(car.cnt);
                if (cntMin == null || cntMin.fuel < car.fuel) {
                    map.put(car.cnt, car);
                }
            }
            q.addAll(map.values());
        }

        Optional<Car> min = q.stream().filter(c -> c.canReach(target)).min(Comparator.comparingInt(c -> c.cnt));
        return min.isPresent() ? min.get().cnt : -1;
    }

    class Car {
        long fuel;
        int position = 0;
        int cnt = 0;

        public Car(int fuel) {
            this.fuel = fuel;
        }

        public Car(long fuel, int position, int cnt) {
            this.fuel = fuel;
            this.position = position;
            this.cnt = cnt;
        }

        public void skipStation(int[] station) {
            this.fuel -= (station[0] - this.position);
            this.position = station[0];
        }

        public Car moveToStation(int[] station) {
            long newFuel = this.fuel - (station[0] - this.position) + station[1];
            int newPosition = station[0];
            int newCount = this.cnt + 1;
            return new Car(newFuel, newPosition, newCount);
        }

        public boolean canReach(int dest) {
            return dest <= this.position + this.fuel;
        }

        public boolean canReach(int[] station) {
            return canReach(station[0]);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "fuel=" + fuel +
                    ", position=" + position +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
