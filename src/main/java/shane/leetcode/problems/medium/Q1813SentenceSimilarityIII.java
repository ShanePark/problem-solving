package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats96.43%
 */
public class Q1813SentenceSimilarityIII {

    @Test
    public void test() {
        assertThat(areSentencesSimilar("Luky", "Lucccky")).isFalse();
        assertThat(areSentencesSimilar("My name is Haley", "My Haley")).isTrue();
        assertThat(areSentencesSimilar("My name is Haley", "My name")).isTrue();
        assertThat(areSentencesSimilar("of", "A lot of words")).isFalse();
        assertThat(areSentencesSimilar("Eating right now", "Eating")).isTrue();
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String longer = sentence1.length() > sentence2.length() ? sentence1 : sentence2;
        String shorter = sentence1.length() > sentence2.length() ? sentence2 : sentence1;
        String[] split1 = longer.split(" ");
        String[] split2 = shorter.split(" ");
        int sameEnd = findSameEnd(split2, split1);
        for (int i = 0; i < split2.length; i++) {
            if (sameEnd <= i)
                return true;
            if (!split1[i].equals(split2[i])) {
                return false;
            }
        }
        return true;
    }

    private int findSameEnd(String[] shorter, String[] longer) {
        for (int i = 0; i < shorter.length; i++) {
            String shorterSentence = shorter[shorter.length - 1 - i];
            String longerSentence = longer[longer.length - 1 - i];
            if (!shorterSentence.equals(longerSentence)) {
                return shorter.length - i;
            }
        }
        return 0;
    }

}
