package shane.leetcode.contest.biweekly.w74;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TLE
 */
public class Q2207MaximizeNumberOfSubsequencesInAString3 {

    @Test
    void test() {
        Assertions.assertThat(maximumSubsequenceCount("abdcdbc", "ac")).isEqualTo(4);
        Assertions.assertThat(maximumSubsequenceCount("aabb", "ab")).isEqualTo(6);
        Assertions.assertThat(maximumSubsequenceCount("cc", "aa")).isEqualTo(0);
        Assertions.assertThat(maximumSubsequenceCount("aa", "aa")).isEqualTo(3);
        Assertions.assertThat(maximumSubsequenceCount("fwymvreuftzgrcrxczjacqovduqaiig", "yy")).isEqualTo(1);
        Assertions.assertThat(countBigger(2, Arrays.asList(1, 3, 4, 5))).isEqualTo(3);
        Assertions.assertThat(maximumSubsequenceCount("vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign", "rr")).isEqualTo(496);
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        char c1 = pattern.charAt(0);
        char c2 = pattern.charAt(1);

        List<Integer> c1Index = new ArrayList<>();
        List<Integer> c2Index = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == c1)
                c1Index.add(i);
            if (c == c2)
                c2Index.add(i);
        }

        int cnt = 0;
        for (Integer i1 : c1Index) {
            int countSmaller = countBigger(i1, c2Index);
            cnt += countSmaller;
        }

        return cnt + Math.max(c1Index.size(), c2Index.size());

    }

    private int countBigger(int number, List<Integer> list) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (right + left) / 2;
            if (list.get(mid) > number) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.size() - left;
    }

}
