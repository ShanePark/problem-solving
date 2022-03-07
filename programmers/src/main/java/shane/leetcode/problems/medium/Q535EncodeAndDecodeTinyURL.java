package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q535EncodeAndDecodeTinyURL {

    @Test
    void test() {
        Codec codec = new Codec();
        String str = "https://leetcode.com/problems/design-tinyurl";
        String encode = codec.encode(str);
        System.out.println("encode = " + encode);
        String decoded = codec.decode(encode);
        System.out.println("decoded = " + decoded);

        Assertions.assertThat(codec.decode(codec.encode("ftp://174.123.452.34/directory/file"))).isEqualTo("ftp://174.123.452.34/directory/file");
    }

    public class Codec {

        Map<String, String> map = new HashMap<>();
        int cnt = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(String.valueOf(cnt), longUrl);
            return String.valueOf(cnt++);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

}
