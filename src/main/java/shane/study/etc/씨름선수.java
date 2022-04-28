package shane.study.etc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 씨름선수 {

    @Test
    public void test() {
        assertThat(solution(5, new int[][]{{192, 117}, {190, 110}, {184, 98}, {212, 91}, {177, 89}, {218, 78}, {152, 106}, {182, 64}, {193, 88}, {198, 71}, {216, 111}, {155, 101}, {181, 92}, {173, 77}, {215, 97}})).isEqualTo(3);
        assertThat(solution(5, new int[][]{{172, 67}, {183, 65}, {180, 70}, {170, 72}, {181, 60}})).isEqualTo(3);
    }

    int solution(int n, int[][] people) {
        Arrays.sort(people, Comparator.comparingInt(p -> -p[0]));
        List<뚱땡> 사람들 = new ArrayList<>();
        for (int[] person : people) {
            사람들.add(new 뚱땡(person[1], person[0]));
        }
        System.out.println("사람들 = " + 사람들);
        for (int i = 0; i < 사람들.size(); i++) {
            뚱땡 살인마 = 사람들.get(i);
            for (int j = i + 1; j < 사람들.size(); j++) {
                뚱땡 도전자 = 사람들.get(j);
                if (살인마.몸무게 > 도전자.몸무게 && 살인마.키 > 도전자.키) {
                    사람들.remove(j--);
                }
            }
        }
        System.out.println("사람들 = " + 사람들);

        return 사람들.size();
    }

    class 뚱땡 {
        int 몸무게;
        int 키;

        public 뚱땡(int 무게, int 키) {
            this.몸무게 = 무게;
            this.키 = 키;
        }

        @Override
        public String toString() {
            return "뚱땡{" +
                    "몸무게=" + 몸무게 +
                    ", 키=" + 키 +
                    '}';
        }
    }

}
