package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 8 〉	실패 (1.53ms, 74.9MB)
 * 채점 결과
 * 정확성: 97.1
 * 합계: 97.1 / 100.0
 */
public class 광물_캐기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"})).isEqualTo(12);
        assertThat(solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"})).isEqualTo(50);
    }

    @Test
    public void fail() {
        assertThat(solution(new int[]{0, 0, 1}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "diamond", "diamond", "diamond", "diamond"})).isEqualTo(85);
    }

    public int solution(int[] picks, String[] minerals) {
        List<Batch> list = new ArrayList<>();
        Batch batch = new Batch();
        for (String mineral : minerals) {
            batch.addMineral(mineral);
            if (batch.isFull()) {
                list.add(batch);
                batch = new Batch();
            }
        }
        if (batch.isNotEmpty())
            list.add(batch);

        int fatigue = 0;

        Collections.sort(list, Comparator.reverseOrder());
        for (Batch b : list) {
            try {
                int axe = getAxe(picks);
                fatigue += b.work(axe);
            } catch (NoMoreAxeException e) {
                return fatigue;
            }
        }

        return fatigue;
    }

    private int getAxe(int[] picks) throws NoMoreAxeException {
        if (picks[0] > 0) {
            picks[0]--;
            return 25;
        }
        if (picks[1] > 0) {
            picks[1]--;
            return 5;
        }
        if (picks[2] > 0) {
            picks[2]--;
            return 1;
        }
        throw new NoMoreAxeException();
    }

    class Batch implements Comparable {
        int dia;
        int iron;
        int stone;

        public void addMineral(String mineral) {
            switch (mineral) {
                case "diamond":
                    dia++;
                    break;
                case "iron":
                    iron++;
                    break;
                case "stone":
                    stone++;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean isFull() {
            return 5 <= getSize();
        }

        public boolean isNotEmpty() {
            return getSize() != 0;
        }

        private int getSize() {
            return dia + iron + stone;
        }

        @Override
        public String toString() {
            return "Batch{" +
                    "dia=" + dia +
                    ", iron=" + iron +
                    ", stone=" + stone +
                    ", size=" + getSize() +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Batch)) {
                throw new IllegalStateException();
            }
            Batch batch2 = (Batch) o;
            if (dia != batch2.dia) {
                return Integer.compare(dia, batch2.dia);
            }
            if (iron != batch2.iron)
                return Integer.compare(iron, batch2.iron);
            return Integer.compare(stone, batch2.stone);
        }

        public int work(int axe) {
            int diaJob = dia * 25 / axe;
            int ironJob = Math.max(iron, iron * 5 / axe);
            int fatigue = diaJob + ironJob + stone;
            return fatigue;
        }
    }

    private class NoMoreAxeException extends Exception {
    }

}
