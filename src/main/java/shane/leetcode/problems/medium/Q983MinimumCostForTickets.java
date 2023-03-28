package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 5.56%
 * Memory 42.2 MB Beats 13.90%
 */
public class Q983MinimumCostForTickets {

    @Test
    public void test() {
        assertThat(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15})).isEqualTo(11);
        assertThat(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15})).isEqualTo(17);
    }

    public int mincostTickets(int[] days, int[] costs) {
        Queue<Ticket> q = new LinkedList<>();
        q.offer(new Ticket(0, 0));
        for (int day : days) {
            int qSize = q.size();
            int minUntilHere = Integer.MAX_VALUE;
            for (int i = 0; i < qSize; i++) {
                Ticket ticket = q.poll();
                minUntilHere = Math.min(minUntilHere, ticket.cost);
                if (ticket.isValid(day)) {
                    q.offer(ticket);
                }
            }
            q.offer(new Ticket(minUntilHere + costs[0], day));
            q.offer(new Ticket(minUntilHere + costs[1], day + 6));
            q.offer(new Ticket(minUntilHere + costs[2], day + 29));
        }
        return q.stream().sorted(Comparator.comparingInt(t -> t.cost)).findFirst().get().cost;
    }

    class Ticket {
        int cost;
        int validUntil;

        public Ticket(int cost, int validUntil) {
            this.cost = cost;
            this.validUntil = validUntil;
        }

        public boolean isValid(int day) {
            return day <= validUntil;
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "cost=" + cost +
                    ", validUntil=" + validUntil +
                    '}';
        }
    }

}
