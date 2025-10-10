package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 14ms
 * Beats10.34%
 */
public class Q3147TakingMaximumEnergyFromTheMysticDungeon {

    @Test
    public void test() {
        assertThat(maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3)).isEqualTo(3);
        assertThat(maximumEnergy(new int[]{-2, -3, -1}, 2)).isEqualTo(-1);
    }

    public int maximumEnergy(int[] energy, int k) {
        for (int i = 0; i < k; i++) {
            int start = energy.length - 1 - i;
            calcEnergy(energy, k, start, 0);
        }
        return Arrays.stream(energy).max().orElseThrow();
    }

    private void calcEnergy(int[] energy, int k, int i, int value) {
        if (i < 0)
            return;
        energy[i] += value;
        calcEnergy(energy, k, i - k, energy[i]);
    }

}
