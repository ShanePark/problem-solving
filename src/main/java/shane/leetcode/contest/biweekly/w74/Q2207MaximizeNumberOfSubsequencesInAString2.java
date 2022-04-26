package shane.leetcode.contest.biweekly.w74;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TLE
 */
public class Q2207MaximizeNumberOfSubsequencesInAString2 {

    @Test
    void test() {
        Assertions.assertThat(maximumSubsequenceCount("abdcdbc", "ac")).isEqualTo(4);
        Assertions.assertThat(maximumSubsequenceCount("aabb", "ab")).isEqualTo(6);
        Assertions.assertThat(maximumSubsequenceCount("cc", "aa")).isEqualTo(0);
        Assertions.assertThat(maximumSubsequenceCount("aa", "aa")).isEqualTo(3);
        Assertions.assertThat(maximumSubsequenceCount("fwymvreuftzgrcrxczjacqovduqaiig", "yy")).isEqualTo(1);
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

        if (c1 == c2)
            return (long) c1Index.size() * (c1Index.size() - 1) / 2 + c1Index.size();

        int cnt = 0;
        for (Integer i1 : c1Index) {
            for (Integer i2 : c2Index) {
                if (i1 < i2)
                    cnt++;
            }
        }

        return cnt + Math.max(c1Index.size(), c2Index.size());

    }

}
