package shane.programmers.lv2c;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 테이블_해시_함수 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[2,2,6],[1,5,10],[4,2,9],[3,8,3]]"), 2, 2, 3))
                .isEqualTo(4);
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o1[col - 1], o2[col - 1]);
        });
        int xor = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int[] row = data[i - 1];
            int sum = 0;
            for (int n : row) {
                sum += n % i;
            }
            xor ^= sum;
        }
        return xor;
    }
}
