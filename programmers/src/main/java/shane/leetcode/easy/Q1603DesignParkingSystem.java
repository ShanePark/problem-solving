package shane.leetcode.easy;

import org.assertj.core.api.Assertions;

public class Q1603DesignParkingSystem {

    public static void main(String[] args) {
        ParkingSystem p = new ParkingSystem(1, 1, 0);
        Assertions.assertThat(p.addCar(1)).isEqualTo(true);
        Assertions.assertThat(p.addCar(2)).isEqualTo(true);
        Assertions.assertThat(p.addCar(3)).isEqualTo(false);
        Assertions.assertThat(p.addCar(1)).isEqualTo(false);
    }

    static class ParkingSystem {
        int[] arr = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            arr[0] = big;
            arr[1] = medium;
            arr[2] = small;
        }

        public boolean addCar(int carType) {
            return (arr[carType - 1] -= 1) >= 0;
        }

    }


}
