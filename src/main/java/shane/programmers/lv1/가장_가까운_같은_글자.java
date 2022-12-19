package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 가장_가까운_같은_글자 {

    @Test
    public void test() {
        assertThat(solution("banana")).containsExactly(-1, -1, -1, 2, 2, 2);
    }

    public int[] solution(String s) {
        int length = s.length();
        int[] answer = new int[length];
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int beforeIndex = arr[c - 'a'];
            answer[i] = beforeIndex == -1 ? -1 : i - beforeIndex;
            arr[c - 'a'] = i;
        }
        return answer;
    }
}
