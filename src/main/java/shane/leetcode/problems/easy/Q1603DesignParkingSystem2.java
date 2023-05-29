package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1603DesignParkingSystem2 {

    @Test
    void test() {
        ParkingSystem p = new ParkingSystem(1, 1, 0);
        assertThat(p.addCar(1)).isEqualTo(true);
        assertThat(p.addCar(2)).isEqualTo(true);
        assertThat(p.addCar(3)).isEqualTo(false);
        assertThat(p.addCar(1)).isEqualTo(false);
    }

    class ParkingSystem {
        int big;
        int medium;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    return big-- > 0;
                case 2:
                    return medium-- > 0;
                case 3:
                    return small-- > 0;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

}
