package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class 택배_배달과_수거하기 {

    @Test
    public void test() {
        assertThat(solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0})).isEqualTo(30);
        assertThat(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0})).isEqualTo(16);
        assertThat(solution(1, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0})).isEqualTo(52);
    }

    /**
     * 1sec 60ms
     */
    @Test
    public void tle() {
        int[] arr = new int[100000];
        Arrays.fill(arr, 50);
        assertThat(solution(1, 100000, arr, arr)).isEqualTo(500005000000L);
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Town> deliverStack = new Stack<>();
        Stack<Town> pickupStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0)
                deliverStack.push(new Town(i + 1, deliveries[i]));
            if (pickups[i] > 0)
                pickupStack.push(new Town(i + 1, pickups[i]));
        }

        long answer = 0;
        while (!deliverStack.isEmpty() || !pickupStack.isEmpty()) {
            Status status = Status.calc(deliverStack, pickupStack);
            int maxDistance = calcMaxDistance(deliverStack, pickupStack);
            answer += maxDistance * 2;
            if (status == Status.DELIVER_FIRST) {
                clearStack(cap, deliverStack);
                clearStack(cap, pickupStack);
            }
        }
        return answer;
    }

    private void clearStack(int cap, Stack<Town> stack) {
        int curCap = cap;
        while (curCap > 0 && !stack.isEmpty()) {
            Town peek = stack.peek();
            int min = Math.min(peek.size, curCap);
            peek.size -= min;
            curCap -= min;
            if (peek.size == 0)
                stack.pop();
        }
    }


    private int calcMaxDistance(Stack<Town> deliverStack, Stack<Town> pickupStack) {
        Status status = Status.calc(deliverStack, pickupStack);
        if (status == Status.DELIVER_FIRST)
            return deliverStack.peek().distance;
        return pickupStack.peek().distance;
    }

    enum Status {
        DELIVER_FIRST, PICK_FIRST;

        public static Status calc(Stack<Town> deliverStack, Stack<Town> pickupStack) {
            if (deliverStack.isEmpty())
                return PICK_FIRST;
            if (pickupStack.isEmpty())
                return DELIVER_FIRST;
            Town farthestDeliver = deliverStack.peek();
            Town farthestPeek = pickupStack.peek();
            if (farthestDeliver.distance < farthestPeek.distance) {
                return PICK_FIRST;
            }
            return DELIVER_FIRST;
        }
    }

    class Town {
        int distance;
        int size;

        public Town(int distance, int size) {
            this.distance = distance;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Town{" +
                    "distance=" + distance +
                    ", size=" + size +
                    '}';
        }
    }

}
