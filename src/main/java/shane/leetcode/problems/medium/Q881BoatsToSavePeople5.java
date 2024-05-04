package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 19 ms Beats 7.17% of users with Java
 */
public class Q881BoatsToSavePeople5 {

    @Test
    public void test() {
        assertThat(numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50)).isEqualTo(11);
        assertThat(numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6)).isEqualTo(3);
        assertThat(numRescueBoats(new int[]{1, 2}, 3)).isEqualTo(1);
        assertThat(numRescueBoats(new int[]{3, 2, 2, 1}, 3)).isEqualTo(3);
        assertThat(numRescueBoats(new int[]{3, 5, 3, 4}, 5)).isEqualTo(4);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        while (left <= right) {
            answer++;
            int cur = 0;
            int onBoard = 0;
            while (onBoard < 2 && left <= right && cur + people[right] <= limit) {
                cur += people[right--];
                onBoard++;
            }
            while (onBoard < 2 && left <= right && cur + people[left] <= limit) {
                cur += people[left++];
                onBoard++;
            }
        }
        return answer;
    }

}
