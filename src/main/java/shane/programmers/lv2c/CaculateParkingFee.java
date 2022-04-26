package shane.programmers.lv2c;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;

public class CaculateParkingFee {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})).containsExactly(14600, 34400, 5000);
        Assertions.assertThat(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})).containsExactly(0, 591);
        Assertions.assertThat(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})).containsExactly(14841);
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Car> map = new HashMap<>();
        for (String record : records) {
            String[] data = record.split(" ");
            int time = Integer.parseInt(data[0].substring(0, 2)) * 60 + Integer.parseInt(data[0].substring(3, 5));
            int carNumber = Integer.parseInt(data[1]);

            Car car = map.get(carNumber);
            if (car == null) {
                car = new Car(carNumber);
                map.put(carNumber, car);
            }

            if ("IN".equals(data[2])) {
                car.in(time);
            } else {
                car.out(time);
            }
        }

        for (Integer key : map.keySet()) {
            Car car = map.get(key);
            if (car.inTime != null) {
                car.out(60 * 23 + 59);
            }
        }

        for (Integer key : map.keySet()) {
            Car car = map.get(key);
            car.calc(fees);
        }

        return map.values().stream().sorted(Comparator.comparingInt(c -> c.number)).mapToInt(c -> c.parkingFee).toArray();

    }

    static class Car {
        int number;
        int parkingFee = 0;
        int totalParkingTime = 0;
        Integer inTime;

        public Car(int number) {
            this.number = number;
        }

        public void in(int inTime) {
            this.inTime = inTime;
        }

        public void out(int outTime) {
            this.totalParkingTime += (outTime - this.inTime);
            this.inTime = null;
        }

        public void calc(int[] fees) {

            totalParkingTime -= fees[0];
            int fee = fees[1];

            if (totalParkingTime > 0) {
                fee += ((totalParkingTime % fees[2] == 0 ? 0 : 1) + totalParkingTime / fees[2]) * fees[3];
            }

            this.parkingFee += fee;

        }

        @Override
        public String toString() {
            return "Car{" +
                    "number=" + number +
                    ", parkingFee=" + parkingFee +
                    ", inTime=" + inTime +
                    '}';
        }
    }

}
