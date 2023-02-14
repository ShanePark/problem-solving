package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not My Solution
 * Runtime: 26 ms, faster than 54.40% of Java online submissions for Word Ladder II.
 * Memory Usage: 44.1 MB, less than 78.72% of Java online submissions for Word Ladder II.
 */
@SuppressWarnings("ALL")
public class Q126WordLadderII4 {

    @Test
    public void test() {
        assertThat(findLadders("hot", "dog", List.of("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"))).containsExactlyInAnyOrderElementsOf(Ps.strList("[[\"hot\",\"dot\",\"dog\"],[\"hot\",\"hog\",\"dog\"]]"));
        assertThat(findLadders("a", "c", List.of("a", "b", "c"))).containsExactlyInAnyOrderElementsOf(Ps.strList("[[\"a\",\"c\"]]"));
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))).containsExactlyInAnyOrderElementsOf(Ps.strList("[[\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],[\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]]"));
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))).containsExactlyInAnyOrderElementsOf(Ps.strList("[]"));
    }

    @Test
    public void tleTest() {
        assertThat(findLadders("qa", "sq", List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")))
                .hasSize(51);
    }

    @Test
    public void tle2() {
        assertThat(findLadders("cet", "ism", List.of("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim")))
                .isEqualTo(Ps.strList("[]"));
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> reverseMap = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> nextDepth = new HashSet<>();
        boolean possible = false;

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            for (String next : set) {
                if (diffOne(poll, next)) {
                    Set<String> reverseLadders = reverseMap.computeIfAbsent(next, k -> new HashSet<>());
                    reverseLadders.add(poll);
                    if (endWord.equals(next)) {
                        possible = true;
                    }
                    nextDepth.add(next);
                }
            }
            if (queue.isEmpty()) {
                if (possible)
                    break;
                queue.addAll(nextDepth);
                set.removeAll(nextDepth);
                nextDepth.clear();
            }
        }

        List<List<String>> answer = new ArrayList<>();
        if (!possible)
            return answer;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        findPath(endWord, beginWord, reverseMap, answer, path);
        return answer;
    }


    private void findPath(String endWord, String beginWord, Map<String, Set<String>> reverse, List<List<String>> answer, List<String> path) {
        Set<String> next = reverse.get(endWord);
        if (next == null)
            return;
        for (String word : next) {
            path.add(word);
            if (beginWord.equals(word)) {
                List<String> shortestPath = new ArrayList<>(path);
                Collections.reverse(shortestPath);
                answer.add(shortestPath);
            } else {
                findPath(word, beginWord, reverse, answer, path);
            }
            path.remove(word);
        }
    }

    private boolean diffOne(String beginWord, String word) {
        int totalDiff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                totalDiff++;
            }
            if (totalDiff > 1)
                return false;
        }
        return totalDiff == 1;
    }
}
