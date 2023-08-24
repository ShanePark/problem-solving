package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 62.57%of users with Java
 * Memory Details 41.14MB Beats 26.09%of users with Java
 */
public class Q68TextJustification {

    @Test
    public void test() {
        assertThat(fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6))
                .isEqualTo(List.of(
                                "Listen",
                                "to    ",
                                "many, ",
                                "speak ",
                                "to   a",
                                "few.  "
                        )
                );
        assertThat(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16))
                .isEqualTo(List.of(
                        "What   must   be",
                        "acknowledgment  ",
                        "shall be        ")
                );
        assertThat(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16))
                .isEqualTo(List.of(
                        "This    is    an",
                        "example  of text",
                        "justification.  "));
        assertThat(fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20))
                .isEqualTo(List.of(
                        "Science  is  what we",
                        "understand      well",
                        "enough to explain to",
                        "a  computer.  Art is",
                        "everything  else  we",
                        "do                  ")
                );
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Line> lines = new ArrayList<>();
        Line line = new Line();
        for (String word : words) {
            if (!line.canAdd(word, maxWidth)) {
                lines.add(line);
                line = new Line();
            }
            line.addString(word);
        }
        lines.add(line);

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i++) {
            Line l = lines.get(i);
            String justify = l.justify(maxWidth);
            answer.add(justify);
        }

        Line lastLine = lines.get(lines.size() - 1);
        String lastString = lastLine.justifyLastLine(maxWidth);
        answer.add(lastString);

        return answer;
    }

    class Line {
        int length = 0;
        List<String> words = new ArrayList<>();

        public void addString(String word) {
            if (length != 0)
                length++;
            this.length += word.length();
            words.add(word);
        }

        public boolean canAdd(String word, int maxWidth) {
            int blank = length == 0 ? 0 : 1;
            return (length + blank + word.length()) <= maxWidth;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "length=" + length +
                    ", words=" + words +
                    '}';
        }

        public String justify(int maxWidth) {
            if (words.size() == 1) {
                StringBuilder sb = new StringBuilder(words.get(0));
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
                return sb.toString();
            }
            int blank = maxWidth - length + (words.size() - 1);
            int mod = blank % (words.size() - 1);
            int div = blank / (words.size() - 1);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.size() - 1; i++) {
                String word = words.get(i);
                sb.append(word);
                for (int j = 0; j < div; j++) {
                    sb.append(" ");
                }
                if (mod > 0) {
                    mod--;
                    sb.append(" ");
                }
            }
            sb.append(words.get(words.size() - 1));
            return sb.toString();
        }

        public String justifyLastLine(int maxWidth) {
            StringBuilder sb = new StringBuilder();
            sb.append(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                String word = words.get(i);
                sb.append(" ").append(word);
            }
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

}
