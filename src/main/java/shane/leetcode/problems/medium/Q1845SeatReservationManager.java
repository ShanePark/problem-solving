package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 81ms Beats 38.73%of users with Java
 * Memory Details 88.65MB Beats 34.43%of users with Java
 */
public class Q1845SeatReservationManager {

    @Test
    public void test() {
        SeatManager manager = new SeatManager(5);
        assertThat(manager.reserve()).isEqualTo(1);
        assertThat(manager.reserve()).isEqualTo(2);
        manager.unreserve(2);
        assertThat(manager.reserve()).isEqualTo(2);
        assertThat(manager.reserve()).isEqualTo(3);
        assertThat(manager.reserve()).isEqualTo(4);
        assertThat(manager.reserve()).isEqualTo(5);
        manager.unreserve(5);
    }

    class SeatManager {

        final PriorityQueue<Integer> pq;

        public SeatManager(int n) {
            pq = new PriorityQueue<>(n);
            for (int i = 1; i <= n; i++) {
                pq.offer(i);
            }
        }

        public int reserve() {
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }

}
