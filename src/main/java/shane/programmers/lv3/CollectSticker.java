package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectSticker {

    @Test
    public void test() {
        assertThat(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10})).isEqualTo(36);
        assertThat(solution(new int[]{1, 3, 2, 5, 4})).isEqualTo(8);
        assertThat(solution(new int[]{1, 2, 3})).isEqualTo(3);
        assertThat(solution(new int[]{1, 2})).isEqualTo(2);
        assertThat(solution(new int[]{1})).isEqualTo(1);
    }

    public int solution(int sticker[]) {
        if(sticker.length==1){
            return sticker[0];
        }
        if(sticker.length==2){
            return Math.max(sticker[0], sticker[1]);
        }
        int[] maxWithFirst = maxArr(sticker);
        int[] maxWithoutFirst = maxArr(Arrays.copyOfRange(sticker, 1, sticker.length));

        return Math.max(maxWithFirst[sticker.length - 2], maxWithoutFirst[sticker.length - 2]);
    }

    private int[] maxArr(int[] sticker) {
        int max[] = new int[sticker.length];
        max[0] = sticker[0];
        max[1] = Math.max(sticker[0], sticker[1]);

        for (int i = 2; i < sticker.length; i++) {
            max[i] = Math.max(max[i - 2] + sticker[i], max[i - 1]);
        }
        return max;
    }
}
