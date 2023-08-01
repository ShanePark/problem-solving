package shane.study;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 단비는 x 월 y 일에 태어날 예정입니다. 그의 친구인 조이는 단비의 예정일에 관련된 아래와 같은 단서를 찾아내었습니다.
 * 조이는 한 벌의 카드를 가지고 놀이를 하기로 했습니다. 각 카드에는 1부터 6까지의 숫자 중 하나가 적혀있습니다.
 * 조이는 이 카드들을 두 더미로 나누었습니다. 한 더미의 카드는 '더미 A'라 명명되었고, 다른 더미의 카드는 '더미 B'라 명명되었습니다.
 * 1. 조이는 더미 A의 카드 숫자들을 모두 더하면 x가 되고, 더미 B의 카드 숫자들을 모두 더하면 y가 된다는 규칙을 찾았습니다.
 * 2. (더미 A에 있는 카드의 합)을 제곱한 수가 더미 B에 있는 모든 카드의 곱에 2를 곱한 값보다 1 크다는 규칙을 발견했습니다.
 * 조이가 찾아낸 단서를 바탕으로, 단비의 예정일은 언제일까요?
 */
public class DanbiBirth {

    @Test
    public void test() {
        findDanbiBirth();
    }

    private void findDanbiBirth() {
        dfs(1, new HashSet<>());
    }

    private void dfs(int num, Set<Integer> dummy1) {
        if (6 < num)
            return;
        dfs(num + 1, dummy1);

        dummy1.add(num);
        int x = dummy1.stream().mapToInt(Integer::intValue).sum();
        Set<Integer> dummy2 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        dummy2.removeAll(dummy1);
        int dummy2Mul = 1;
        int y = 0;
        for (Integer i : dummy2) {
            dummy2Mul *= i;
            y += i;
        }
        if (x * x == dummy2Mul * 2 + 1) {
            System.out.println("단비의 예정일은 " + x + "월 " + y + "일 입니다.");
        }

        dfs(num + 1, dummy1);
        dummy1.remove(num);
    }

}
