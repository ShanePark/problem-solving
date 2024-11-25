package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime7msBeats84.75%
 */
public class Q773SlidingPuzzle {

    @Test
    public void test() {
        assertThat(slidingPuzzle(Ps.intArray("[[1,2,3],[4,0,5]]"))).isEqualTo(1);
        assertThat(slidingPuzzle(Ps.intArray("[[1,2,3],[5,4,0]]"))).isEqualTo(-1);
        assertThat(slidingPuzzle(Ps.intArray("[[4,1,2],[5,0,3]]"))).isEqualTo(5);
    }

    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        String start = arrToString(board);
        visited.add(start);
        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String poll = q.poll();
                if ("123450".equals(poll))
                    return step;
                List<String> moves = getMoves(poll);
                for (String next : moves) {
                    if (!visited.add(next)) {
                        continue;
                    }
                    q.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getMoves(String str) {
        int zeroIndex = str.indexOf('0');
        List<String> answer = new ArrayList<>();
        switch (zeroIndex) {
            case 0:
                answer.add(down(str, zeroIndex));
                answer.add(right(str, zeroIndex));
                break;
            case 1:
                answer.add(left(str, zeroIndex));
                answer.add(down(str, zeroIndex));
                answer.add(right(str, zeroIndex));
                break;
            case 2:
                answer.add(left(str, zeroIndex));
                answer.add(down(str, zeroIndex));
                break;
            case 3:
                answer.add(up(str, zeroIndex));
                answer.add(right(str, zeroIndex));
                break;
            case 4:
                answer.add(left(str, zeroIndex));
                answer.add(up(str, zeroIndex));
                answer.add(right(str, zeroIndex));
                break;
            case 5:
                answer.add(up(str, zeroIndex));
                answer.add(left(str, zeroIndex));
                break;
        }
        return answer;
    }

    private String right(String str, int zeroIndex) {
        return swap(str, zeroIndex, zeroIndex + 1);
    }

    private String left(String str, int zeroIndex) {
        return swap(str, zeroIndex, zeroIndex - 1);
    }

    private String down(String str, int zeroIndex) {
        return swap(str, zeroIndex, zeroIndex + 3);
    }

    private String up(String str, int zeroIndex) {
        return swap(str, zeroIndex, zeroIndex - 3);
    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }

    private String arrToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int i : ints) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

}
