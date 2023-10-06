package shane.programmers.lv2c;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 이모티콘_할인행사 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[40, 10000], [25, 10000]]"), new int[]{7000, 9000})).containsExactly(1, 5400);
        assertThat(solution(Ps.intArray("[[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]"), new int[]{1300, 1500, 1600, 4900})).containsExactly(4, 13860);
    }

    int plusCount;
    int total;

    public int[] solution(int[][] users, int[] emoticons) {
        this.plusCount = 0;
        this.total = 0;
        List<User> userList = new ArrayList<>();
        for (int[] user : users) {
            userList.add(new User(user[0], user[1]));
        }

        int[] rate = new int[emoticons.length];
        dfs(rate, 0, userList, emoticons);

        return new int[]{plusCount, total};
    }

    private void calc(List<User> userList, int[] rate, int[] emoticons) {
        int money = 0;
        int emoticonPlusCount = 0;
        for (User user : userList) {
            int result = user.calc(rate, emoticons);
            if (result < 0) {
                emoticonPlusCount++;
                continue;
            }
            money += result;
        }

        if (this.plusCount < emoticonPlusCount) {
            this.plusCount = emoticonPlusCount;
            this.total = money;
        } else if (this.plusCount == emoticonPlusCount) {
            this.total = Math.max(this.total, money);
        }
    }

    private void dfs(int[] rate, int index, List<User> userList, int[] emoticons) {
        if (index == rate.length) {
            calc(userList, rate, emoticons);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            rate[index] = i * 10;
            dfs(rate, index + 1, userList, emoticons);
        }
    }

    class User {
        int rate;
        int min;

        public User(int rate, int min) {
            this.rate = rate;
            this.min = min;
        }

        public int calc(int[] discount, int[] emoticons) {
            int sum = 0;
            for (int i = 0; i < discount.length; i++) {
                if (rate <= discount[i]) {
                    sum += emoticons[i] - (emoticons[i] * discount[i] / 100);
                }
            }
            return (min <= sum) ? -1 : sum;
        }
    }

}
