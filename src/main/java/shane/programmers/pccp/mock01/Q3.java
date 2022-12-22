package shane.programmers.pccp.mock01;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[3, 5]]"))).containsExactly("RR");
        assertThat(solution(STool.convertToIntArray("[[3, 8], [2, 2]]"))).containsExactly("rr", "Rr");
        assertThat(solution(STool.convertToIntArray("[[3, 1], [2, 3], [3, 9]]"))).containsExactly("RR", "Rr", "RR");
        assertThat(solution(STool.convertToIntArray("[[4, 26]]"))).containsExactly("Rr");
    }

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = find(query[0], query[1] - 1);
        }
        return answer;
    }

    private String find(int depth, int index) {
        if (depth == 1)
            return "Rr";

        String parent = find(depth - 1, index / 4);
        if (parent.equals("Rr")) {
            switch (index % 4) {
                case 0:
                    return "RR";
                case 1:
                case 2:
                    return "Rr";
                case 3:
                    return "rr";
            }
        }
        return parent;
    }

}
