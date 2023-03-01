package shane.programmers.lv3;

import io.github.shanepark.Ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpeedCam {

    public static void main(String[] args) {
        System.out.println(solution(Ps.intArray("[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]")));
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
        List<Car> list = new ArrayList<>();
        for (int[] route : routes) {
            Car car = new Car(route[0], route[1]);
            list.add(car);
        }

        list.sort((c1, c2) -> c1.out - c2.out);

        int cnt = 0;

        while(list.size() > 0) {
            int camera = list.get(0).out;
            cnt++;
            List<Car> copyList = new ArrayList(list);
            for (Car car : copyList ) {
                if(car.check(camera)){
                    list.remove(car);
                }
            }
        }

        return cnt;
    }

}
