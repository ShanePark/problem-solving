package shane.programmers.devMatching2022Game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 등급	기준
 * 브론즈	최근 30일간 0원 이상 10,000원 미만 구매 고객
 * 실버	최근 30일간 10,000원 이상 20,000원 미만 구매 고객
 * 골드	최근 30일간 20,000원 이상 50,000원 미만 구매 고객
 * 플래티넘	최근 30일간 50,000원 이상 100,000원 미만 구매 고객
 * 다이아몬드	최근 30일간 100,000원 이상 구매 고객
 * <p>
 * Arrays.toString(months) = [31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]
 */
public class Q1 {

    @Test
    void test() {
        Assertions.assertThat(solution(new String[]{"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"})).containsExactly(315, 9, 11, 20, 10);
        Assertions.assertThat(solution(new String[]{"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"})).containsExactly(245, 30, 30, 30, 30);
    }

    int[] months = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    public int[] solution(String[] purchase) {
        int[] everyday = new int[365];

        for (String s : purchase) {
            String[] data = s.split(" ");
            String[] date = data[0].split("/");
            int day = dateToDay(date);
            int price = Integer.parseInt(data[1]);
            for (int i = day; i < day + 30 && i <= 365; i++) {
                everyday[i - 1] += price;
            }
        }

        int[] answer = new int[5];
        for (int i = 0; i < 365; i++) {
            int cur = everyday[i];
            if (cur < 10000) {
                answer[0]++;
            } else if (cur < 20000) {
                answer[1]++;
            } else if (cur < 50000) {
                answer[2]++;
            } else if (cur < 100000) {
                answer[3]++;
            } else {
                answer[4]++;
            }
        }


        return answer;
    }

    private int dateToDay(String[] date) {
        int month = Integer.parseInt(date[1]);
        int monthToday = month == 1 ? 0 : months[month - 2];
        int day = Integer.parseInt(date[2]);
        return monthToday + day;
    }

}
