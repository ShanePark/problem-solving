package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 18msBeats79.48%
 */
public class Q826MostProfitAssigningWork {

    @Test
    public void test() {
        assertThat(maxProfitAssignment(new int[]{13, 37, 58}, new int[]{4, 90, 96}, new int[]{34, 73, 45})).isEqualTo(190);
        assertThat(maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7})).isEqualTo(100);
        assertThat(maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25})).isEqualTo(0);
        assertThat(maxProfitAssignment(
                new int[]{64448,79457,42016,11665,2469,91969,46731,54320,5882,93835,21708,50277,16955,45755,72327,12268,15839,18850,10936,86865,31179,70806,862,89380,85395,37685,35989,22400,65446,89518,87777,70913,94050,19520,32338,6472,5200,80772,51039,17062,50872,15560,72431,78446,60361,6777,31654,21757,14900,97226},
                new int[]{55170,24810,99019,14644,60739,86776,3656,85057,88453,42411,63691,60967,64863,28688,57126,98045,43420,1719,81693,43774,89525,86382,83018,5553,3184,1542,40108,39794,79829,30024,96082,41089,60930,38049,63082,94078,7062,33691,18438,35911,30367,21478,97103,32558,53184,24942,53365,48591,38949,88794},
                new int[]{1934,65871,592,76268,61862,74422,53430,95603,70312,43409,30258,54173,99791,21407,42909,96179,64854,77416,24428,68409,21827,4982,72940,99041,52118,94881,31780,84764,7679,56624,41536,87404,39901,61306,81696,61301,46775,19110,95183,84615,2265,56050,69873,14041,41356,18511,15227,5037,23642,36803}))
                .isEqualTo(4769350);
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            int d = difficulty[i];
            int p = profit[i];
            jobs.add(new int[]{d, p});
        }
        Collections.sort(jobs, Comparator.comparingInt(j -> j[0]));
        int[] perDifficulty = new int[100000];
        int cur = 0;
        int curProfit = 0;
        for (int[] job : jobs) {
            int d = job[0];
            while (cur < d) {
                perDifficulty[cur++] = curProfit;
            }
            curProfit = Math.max(curProfit, job[1]);
        }
        while (cur <= worker[worker.length - 1]) {
            perDifficulty[cur++] = curProfit;
        }
        int sum = 0;
        for (int i : worker) {
            sum += perDifficulty[i];
        }
        return sum;
    }

}
