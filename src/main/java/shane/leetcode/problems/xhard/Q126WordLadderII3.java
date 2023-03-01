package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q126WordLadderII3 {

    @Test
    public void test() {
        assertThat(findLadders("hot", "dog", List.of("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"))).containsExactlyInAnyOrderElementsOf(Ps.strList("[[\"hot\",\"dot\",\"dog\"],[\"hot\",\"hog\",\"dog\"]]"));
        assertThat(findLadders("a", "c", List.of("a", "b", "c"))).isEqualTo(Ps.strList("[[\"a\",\"c\"]]"));
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))).isEqualTo(Ps.strList("[[\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],[\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]]"));
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))).isEqualTo(Ps.strList("[]"));
    }

    @Test
    public void tleTest() {
        assertThat(findLadders("qa", "sq", List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")))
                .hasSize(51);
    }

    /**
     * it takes ages and even not finished
     */
    @Test
    public void tle2() {
        assertThat(findLadders("cet", "ism", List.of("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim")))
                .isEqualTo(Ps.strList("[]"));
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        Queue<Word> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        HashSet<String> set = new HashSet<>();
        set.add(beginWord);
        q.add(new Word(beginWord, 1, list, set));

        List<List<String>> answer = new ArrayList<>();
        Integer minSize = null;

        while (!q.isEmpty()) {
            Word poll = q.poll();
            List<String> pollList = poll.list;
            Set<String> pollSet = new HashSet<>(poll.set);
            if (minSize != null && poll.depth == minSize)
                continue;
            for (String word : wordList) {
                if (diffOne(poll.word, word) && pollSet.add(word)) {
                    if (endWord.equals(word)) {
                        if (minSize == null)
                            minSize = poll.depth + 1;
                        pollList.add(endWord);
                        answer.add(pollList);
                        break;
                    }
                    ArrayList<String> newList = new ArrayList<>(pollList);
                    newList.add(word);
                    q.add(new Word(word, poll.depth + 1, newList, pollSet));
                }
            }
        }

        return answer;
    }

    class Word {
        String word;
        int depth;
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        public Word(String word, int depth, List<String> list, Set<String> set) {
            this.word = word;
            this.depth = depth;
            this.list = list;
            this.set = set;
        }
    }

    private boolean diffOne(String beginWord, String word) {
        int length = word.length();
        int totalDiff = 0;
        for (int i = 0; i < length; i++) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                totalDiff++;
            }
            if (totalDiff > 1)
                return false;
        }
        return totalDiff == 1;
    }
}
