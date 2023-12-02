package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 12ms Beats 49.01%of users with Java
 * Memory Details 44.42MB Beats 21.73%of users with Java
 */
public class Q160FindWordsThatCanBeFormedByCharacters {

    @Test
    public void test() {
        assertThat(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach")).isEqualTo(6);
        assertThat(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr")).isEqualTo(10);
        assertThat(countCharacters(new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"}, "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp")).isEqualTo(0);
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            cntMap.merge(c, 1, Integer::sum);
        }

        int cnt = 0;
        loop:
        for (String word : words) {
            int[] arr = new int[26];
            for (char c : word.toCharArray()) {
                arr[c - 'a']++;
                if (cntMap.getOrDefault(c, 0) < arr[c - 'a']) {
                    continue loop;
                }
            }
            cnt += word.length();
        }
        return cnt;
    }

}
