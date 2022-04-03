package shane.leetcode.contest.weekly.w287;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2227EncryptAndDecryptStrings {
    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Encrypter encrypter = new Encrypter(new char[]{'a', 'b', 'c', 'd'}, new String[]{"ei", "zf", "ei", "am"}, new String[]{"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"});
        assertThat(encrypter.encrypt("abcd")).isEqualTo("eizfeiam");
        assertThat(encrypter.decrypt("eizfeiam")).isEqualTo(2);

        Encrypter test = new Encrypter(new char[]{'a', 'b', 'c', 'z'}, new String[]{"aa", "bb", "cc", "zz"}, new String[]{"aa", "aaa", "aaaa", "aaaaa", "aaaaaaa"});
        test.decrypt("aaaa");
        test.decrypt("aa");
        test.decrypt("aaaa");
        test.decrypt("aaaaaaaa");
        test.decrypt("aaaaaaaaaaaaaa");
        test.decrypt("aefagafvabfgshdthn");


        Encrypter test2 = new Encrypter(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'},
                new String[]{"ei", "zf", "ei", "am", "gb", "zz", "zz", "ac", "qa", "mn", "aa", "is", "aa", "op", "pq", "qr", "rs", "st", "tu", "uv", "aa", "sz", "bb", "aa", "ac", "aa"},
                new String[]{"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"});
        assertThat(test2.encrypt("abce")).isEqualTo("eizfeigb");
        assertThat(test2.encrypt("aaaa")).isEqualTo("eieieiei");
        assertThat(test2.encrypt("dddd")).isEqualTo("amamamam");
        assertThat(test2.encrypt("zzzz")).isEqualTo("aaaaaaaa");
        assertThat(test2.decrypt("eizfeiam")).isEqualTo(2);
        assertThat(test2.decrypt("eieieiei")).isEqualTo(0);
        assertThat(test2.decrypt("cccccccc")).isEqualTo(0);
        assertThat(test2.decrypt("aaaaeiei")).isEqualTo(0);
        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeMillis() = " + stopWatch.getTotalTimeMillis()); // 23ms failed

    }

    class Encrypter {

        Set<String> dictionary = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        Map<String, List<Character>> opposite = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (String s : dictionary) {
                this.dictionary.add(s);
            }
            for (int i = 0; i < keys.length; i++) {
                map.put(keys[i], values[i]);
                List<Character> list = opposite.getOrDefault(values[i], new ArrayList<>());
                list.add(keys[i]);
                opposite.putIfAbsent(values[i], list);
            }
        }

        public String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word1.length(); i++) {
                sb.append(map.get(word1.charAt(i)));
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            List<String> strings = new ArrayList<>();
            strings.add("");

            for (int i = 0; i < word2.length(); i += 2) {
                List<Character> list = opposite.get(word2.substring(i, i + 2));
                if (list == null || list.isEmpty()) {
                    return 0;
                }
                List<String> temp = new ArrayList<>();
                for (Character character : list) {
                    for (String str : strings) {
                        temp.add(str + character);
                    }
                }
                strings = temp;
            }

            int cnt = 0;
            for (String str : strings) {
                if (dictionary.contains(str)) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
