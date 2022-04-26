package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2108FindFirstPalindromicStringInTheArray {

    @Test
    public void test() {
        assertThat(firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"})).isEqualTo("ada");
        assertThat(firstPalindrome(new String[]{"xngla", "e", "itrn", "y", "s", "pfp", "rfd"})).isEqualTo("e");
        assertThat(firstPalindrome(new String[]{"knywrurkwbrtpalvuuzbczcwzpdqibcwwyflwiddixemsrwblupyerjgvcpavdjfhmujitcsmdbvhxw", "ovkeowhqvwlndtpxdnimgietvjsqydbuuwmxkfxxgn", "damomwtjugmsrfyvytaheg", "bngqatscosdakdwjz", "jwzcowuantgqlzjrzgpapcugxvviltrhmcwijtpqapmxjfcilrsmsbeffphcxmaozlczncoxxjmuqijhidxqinhywrtah", "ujvoejixvaioikkwzxgtmkchckrigfejjpheiiehpjjefgirkchckmtgxzwkkioiavxijeovju", "kacjvcouuigbhydrryaperxvjetwsycmnlkxujaqngjhhotqskclquklxsozfryfxwiksstmropcdvhgsnosgvltqo", "qrbsdxxolwzmyltproznfgyydxkkejwdiwpvfzvjoxqvwguoerhclytzvolymbxummwsoqtttyttik", "tkekt", "esrshrlfoihhjrouleucwpeubygivoatrfraphgwpvtkanwu", "kwzrfelynncvsrwvaukiinhjdydmlimggjldhflygemzwnjizzlsuqwahsufwmwhfjkjpngdfsudyavtogoaqzknpew", "sdgpcnvsbzxhyjt"}))
                .isEqualTo("ujvoejixvaioikkwzxgtmkchckrigfejjpheiiehpjjefgirkchckmtgxzwkkioiavxijeovju");
    }

    public String firstPalindrome(String[] words) {
        loop:
        for (String word : words) {
            if (word.length() == 1)
                return word;
            int left = 0;
            int right = word.length() - 1;
            while (left < right) {
                if (word.charAt(left++) != word.charAt(right--)) {
                    continue loop;
                }
            }
            return word;
        }
        return "";
    }
}
