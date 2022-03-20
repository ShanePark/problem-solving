package shane.leetcode.contest.biweekly.w74;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2207MaximizeNumberOfSubsequencesInAString {

    @Test
    void test() {
//        assertThat(maximumSubsequenceCount("abdcdbc", "ac")).isEqualTo(4);
//        assertThat(maximumSubsequenceCount("aabb", "ab")).isEqualTo(6);
        assertThat(maximumSubsequenceCount("vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign",
                "rr")).isEqualTo(496);
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
            for (Integer i2 : c2Index) {
                if (i1 < i2)
                    cnt++;
            }
        }

        return cnt + Math.max(c1Index.size(), c2Index.size());

    }

}
