package shane.programmers.skillCheck.level3;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Camera {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]"))).isEqualTo(2);
    }

    static class Car {
        int in;
        int out;

        public Car(int in, int out) {
            this.in = in;
            this.out = out;
        }

        public boolean check(int spot) {
            return (in <= spot && spot <= out) ? true : false;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "in=" + in +
                    ", out=" + out +
                    '}';
        }
    }

    public static int solution(int[][] routes) {
        List<Car> cars = new ArrayList<>();
        for (int[] route : routes) {
            cars.add(new Car(route[0], route[1]));
        }

        cars.sort(Comparator.comparingInt(c -> c.out));

        int cnt = 0;

        while (cars.size() > 0) {
            int nextCameraPosition = cars.get(0).out;
            cnt++;
            int totalCar = cars.size();
            for (int i = 0; i < totalCar; i++) {
                if (cars.get(i).check(nextCameraPosition)) {
                    cars.remove(i--);
                    totalCar--;
                }
            }
        }

        return cnt;
    }
}
