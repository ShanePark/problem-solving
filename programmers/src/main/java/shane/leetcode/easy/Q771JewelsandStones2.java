package shane.leetcode.easy;

import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

public class Q771JewelsandStones2 {

    public static void main(String[] args) {
        Assertions.assertThat(numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
        Assertions.assertThat(numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i)))
                cnt++;
        }

        return cnt;

    }

}
