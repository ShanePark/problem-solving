package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * DFS TLE
 */
public class Q752OpenTheLock {

    @Test
    public void test() {
        assertThat(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888")).isEqualTo(-1);
        assertThat(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202")).isEqualTo(6);
        assertThat(openLock(new String[]{"8888"}, "0009")).isEqualTo(1);
    }

    @Test
    public void tle() {
        String[] deadends = {"7294", "9558", "2053", "4148", "9984", "6265", "0107", "3314", "2456", "1731", "2521", "8421", "4206", "9111", "1917", "6515", "5256", "8916", "5743", "1698", "1337", "5127", "9389", "3882", "6278", "3578", "9971", "0705", "1663", "4122", "5904", "4323", "9622", "2906", "7670", "4812", "0148", "7491", "8896", "9219", "5695", "8985", "5567", "9344", "8447", "8546", "4988", "3322", "0192", "7896", "2559", "1750", "1624", "2535", "1052", "8728", "1639", "1800", "1654", "4528", "5475", "6208", "1954", "6305", "4044", "7440", "2383", "7328", "8876", "1183", "9140", "1266", "6974", "3081", "9633", "9384", "5051", "8626", "8530", "4091", "8387", "1630", "2096", "9801", "9632", "0059", "8599", "0048", "0008", "4879", "8339", "0848", "6542", "4318", "9342", "9904", "5468", "0638", "0545", "6801", "4056", "0504", "5928", "7165", "1171", "3755", "1782", "4917", "1755", "1828", "2747", "4886", "5169", "6584", "2238", "9395", "4690", "9058", "5739", "6084", "9888", "4688", "7224", "1186", "5850", "9865", "1001", "2593", "1108", "2354", "7602", "1721", "1147", "9273", "0146", "1292", "7385", "1710", "8161", "4189", "8154", "9256", "0255", "0152", "8400", "7683", "1730", "6465", "3432", "4031", "1268", "9030", "1838", "8517", "7206", "8293", "0618", "6125", "9195", "0366", "5391", "6712", "1748", "6764", "6379", "9489", "1050", "1469", "8390", "9615", "4510", "0999", "7859", "9012", "4003", "7828", "0963", "7755", "3737", "4548", "8284", "8041", "0462", "4022", "9684", "0039", "1717", "7249", "6005", "7711", "0301", "4073", "4468", "8811", "7076", "5909", "8616", "6223", "0318", "6709", "2722", "2636", "9288", "7322", "8947", "3195", "2594", "2268", "8830", "5035", "9847", "0764", "0797", "8539", "7169", "6723", "8989", "3554", "1559", "9940", "7337", "5833", "9107", "6045", "4280", "8260", "2783", "4757", "5882", "7728", "0820", "6737", "9797", "4151", "2220", "7343", "2640", "4830", "0772", "5016", "6368", "5303", "3830", "8807", "7203", "7852", "1363", "0491", "9533", "6863", "1297", "8243", "1293", "7791", "4120", "3014", "3343", "8065", "6886", "0598", "4524", "4353", "1465", "5504", "4147", "6537", "1034", "3655", "4572", "5935", "1050", "6770", "4763", "0337", "9409", "7739", "6728", "8286", "3178", "7062", "7509", "2534", "3711", "5715", "9844", "4240", "8299", "1617", "4626", "9681", "1486", "8346", "5466", "0820", "2887", "5680", "0571", "3451", "3238", "0804", "6634", "1909", "8368", "4224", "0221", "7466", "9116", "8067", "1952", "7760", "7387", "3389", "6781", "7658", "7310", "6655", "2978", "3220", "2396", "5444", "8469", "9639", "2984", "5995", "8963", "3752", "7030", "5017", "4805", "4804", "1747", "4551", "3512", "2774", "3315", "9987", "3592", "0382", "5033", "4716", "9050", "1966", "9397", "0880", "6403", "5562", "3117", "5860", "4091", "2598", "3635", "0909", "9756", "7367", "2858", "3960", "0409", "7880", "3002", "5250", "6486", "3902", "3392", "5521", "3053", "0799", "2875", "7146", "0783", "4916", "6437", "5769", "7174", "2259", "0690", "6488", "2491", "6030", "4812", "7159", "1269", "9199", "0110", "4186", "3167", "6046", "9214", "4751", "4106", "2047", "4204", "4000", "0731", "4044", "9964", "7390", "5106", "1159", "7825", "0422", "9194", "3566", "7920", "1675", "2109", "1435", "3340", "6202", "9498", "9726", "8776", "2670", "4638", "4684", "6766", "9117", "7139", "8954", "4179", "9321", "0645", "2834", "5078", "4208", "0094", "0218", "5445", "7495", "0184", "5783", "2052", "4483", "8783", "3124", "2823", "6856", "7500", "7582", "9828", "9537", "2865", "5643", "7343", "5126", "0667", "8492", "1863", "6886", "3026", "1306", "5945", "5133", "5632", "4255", "4813", "1362", "1058", "1848", "3259", "9933", "7960", "2613", "9662", "9932", "5843", "0044", "4444", "2648", "8433", "9424", "0683", "8107", "8030", "6900", "4791", "4273", "7336", "1748", "1054", "4555", "4897", "6156", "2527", "5135", "6485", "3616", "2783", "9091", "5476", "3643", "1789", "5704", "8333", "2745", "7280", "9618", "6409", "9416", "1102", "2878"};
        assertThat(openLock(deadends, "0276")).isEqualTo(9);
    }

    int min = Integer.MAX_VALUE;

    public int openLock(String[] deadends, String target) {
        min = Integer.MAX_VALUE;
        Set<Integer> forbidden = new HashSet<>();
        for (String d : deadends) {
            forbidden.add(Integer.parseInt(d));
        }
        HashMap<Integer, Integer> memo = new HashMap<>();
        dfs(forbidden, memo, Integer.parseInt(target), 0, 0, 0, 0, 0);
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    private void dfs(Set<Integer> forbidden, Map<Integer, Integer> memo, int target, int curDistance, int n1, int n2, int n3, int n4) {
        n1 = parse(n1);
        n2 = parse(n2);
        n3 = parse(n3);
        n4 = parse(n4);
        int curNum = n1 * 1000 + n2 * 100 + n3 * 10 + n4;
        if (curNum == target) {
            min = Math.min(min, curDistance);
            return;
        }

        if (forbidden.contains(curNum)) {
            return;
        }
        int old = memo.getOrDefault(curNum, 100);
        if (old <= curDistance) {
            return;
        }
        memo.put(curNum, curDistance);

        int first = curNum / 1000;
        int second = (curNum / 100) % 10;
        int third = (curNum / 10) % 10;
        int fourth = curNum % 10;

        curDistance++;
        // 8 ways
        dfs(forbidden, memo, target, curDistance, first + 1, second, third, fourth);
        dfs(forbidden, memo, target, curDistance, first - 1, second, third, fourth);
        dfs(forbidden, memo, target, curDistance, first, second + 1, third, fourth);
        dfs(forbidden, memo, target, curDistance, first, second - 1, third, fourth);
        dfs(forbidden, memo, target, curDistance, first, second, third + 1, fourth);
        dfs(forbidden, memo, target, curDistance, first, second, third - 1, fourth);
        dfs(forbidden, memo, target, curDistance, first, second, third, fourth + 1);
        dfs(forbidden, memo, target, curDistance, first, second, third, fourth - 1);
    }

    private int parse(int n) {
        if (n < 0)
            return 9;
        if (n == 10)
            return 0;
        return n;
    }

}
