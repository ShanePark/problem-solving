package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * can't pass first test
 */
public class Q899OrderlyQueue2 {

    @Test
    public void testFailed() {
        assertThat(orderlyQueue("xxqjzq", 2)).isEqualTo("jqqxxz");
    }

    @Test
    public void test() {
        assertThat(orderlyQueue("xmvzi", 2)).isEqualTo("imvxz");
        assertThat(orderlyQueue("hmg", 2)).isEqualTo("ghm");
        assertThat(orderlyQueue("kuh", 1)).isEqualTo("hku");
        assertThat(orderlyQueue("ba", 2)).isEqualTo("ab");
        assertThat(orderlyQueue("v", 1)).isEqualTo("v");
        assertThat(orderlyQueue("baaca", 3)).isEqualTo("aaabc");
        assertThat(orderlyQueue("cba", 1)).isEqualTo("acb");
    }

    public String orderlyQueue(String s, int k) {
        Queue<Character> front = new LinkedList<>();
        Queue<Character> back = new LinkedList<>();
        List<Character> sortedFront = new ArrayList<>();
        PriorityQueue<Character> backPq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            front.offer(c);
            sortedFront.add(c);
        }
        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            back.offer(c);
            backPq.offer(c);
        }

        if (back.size() <= 1) {
            StringBuilder sb = new StringBuilder();
            Stream.concat(front.stream(), back.stream())
                    .sorted(Comparator.naturalOrder())
                    .forEach(c -> sb.append(c));
            return sb.toString();
        }

        Collections.sort(sortedFront);

        int cnt = 0;
        while (front.peek() != sortedFront.get(0) || sortedFront.get(sortedFront.size() - 1) > backPq.peek()) {
            if (cnt++ > 10)
                break;
            List<Character> tmp = new ArrayList<>();
            while (!sortedFront.isEmpty() && sortedFront.get(0) <= backPq.peek()) {
                Character poll = sortedFront.remove(0);
                tmp.add(poll);
            }

            if (sortedFront.isEmpty()) {
                return colToString(front) + colToString(back);
            }
            char removedFromFront = sortedFront.remove(0);
            sortedFront.addAll(tmp);

            front.remove(removedFromFront);
            back.offer(removedFromFront);
            backPq.offer(removedFromFront);

            Character removedFromBack = back.poll();
            backPq.remove(removedFromBack);
            sortedFront.add(removedFromBack);
            front.offer(removedFromBack);
            Collections.sort(sortedFront);
        }

        System.err.println("front = " + front);

        return colToString(front) + colToString(back);

    }

    String colToString(Queue<Character> collection) {
        StringBuilder sb = new StringBuilder();
        collection.stream().forEach(c -> sb.append(c));
        return sb.toString();
    }

}
