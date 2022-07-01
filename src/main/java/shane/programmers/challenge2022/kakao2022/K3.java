package shane.programmers.challenge2022.kakao2022;
import java.util.*;

public class K3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    static class Car implements Comparable<Car> {
        String plateNumber;
        Integer inTime;
        int totalParkingMin;
        int fee;

        public Car(String plate) {
            this.plateNumber = plate;
            this.fee = 0;
        }

        public void in(int inTime) {
            this.inTime = inTime;
        }

        public void out(int outTime) {
            this.totalParkingMin += outTime - this.inTime;
            this.inTime = null;
        }

        public void pay(int[] fees) {
            int baseTime = fees[0];
            int baseFee = fees[1];
            int unitTime = fees[2];
            int unitPrice = fees[3];
            if (baseTime >= totalParkingMin) {
                this.fee = baseFee;
            } else {
                int overTime = totalParkingMin - baseTime;
                int unit = overTime % unitTime == 0 ? overTime / unitTime : overTime / unitTime + 1;
                this.fee = unit * unitPrice + baseFee;
            }
        }

        @Override
        public int compareTo(Car o) {
            return this.plateNumber.compareTo(o.plateNumber);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new HashMap<>();
        Set<String> notOutCars = new HashSet<>();
        for (String rec : records) {
            String[] data = rec.split(" ");
            String time = data[0];
            int timeInMin = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
            String plate = data[1];
            String status = data[2];
            switch (status) {
                case "IN":
                    Car car = map.get(plate);
                    if (car == null) {
                        car = new Car(plate);
                        map.put(plate, car);
                    }
                    car.in(timeInMin);
                    notOutCars.add(plate);
                    break;
                case "OUT":
                    map.get(plate).out(timeInMin);
                    notOutCars.remove(plate);
                    break;
            }
        }
        // 아직 안나간 애들 처리
        for (String plate : notOutCars) {
            map.get(plate).out(60 * 23 + 59);
        }

        List<Car> list = new ArrayList<>();
        for (String key : map.keySet()) {
            Car car = map.get(key);
            car.pay(fees);
            list.add(car);
        }
        return list.stream().sorted().mapToInt(c -> c.fee).toArray();
    }

}
