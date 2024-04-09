package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 32.29% of users with Java
 */
public class Q2073TimeNeededToBuyTickets {

    @Test
    public void test() {
        assertThat(timeRequiredToBuy(new int[]{2, 3, 2}, 2)).isEqualTo(6);
        assertThat(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0)).isEqualTo(8);
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            int ticket = tickets[i];
            Person person = new Person(ticket, k == i);
            q.offer(person);
        }
        int time = 0;
        while (!q.isEmpty()) {
            Person poll = q.poll();
            time++;
            if (--poll.ticketsToBuy == 0) {
                if (poll.isTheGuy) {
                    return time;
                }
                continue;
            }
            q.offer(poll);
        }
        return -1;
    }

    static class Person {
        final boolean isTheGuy;
        int ticketsToBuy;

        public Person(int ticketsToBuy, boolean isTheGuy) {
            this.ticketsToBuy = ticketsToBuy;
            this.isTheGuy = isTheGuy;
        }
    }

}
