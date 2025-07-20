package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1948DeleteDuplicateFoldersInSystem {

    @Test
    public void test() {
        assertThat(deleteDuplicateFolder(List.of(List.of("a"), List.of("c"), List.of("d"), List.of("a", "b"), List.of("c", "b"), List.of("d", "a"))))
                .containsExactlyInAnyOrder(List.of("d"), List.of("d", "a"));
        assertThat(deleteDuplicateFolder(List.of(List.of("a"), List.of("c"), List.of("a", "b"), List.of("c", "b"), List.of("a", "b", "x"), List.of("a", "b", "x", "y"), List.of("w"), List.of("w", "y"))))
                .containsExactlyInAnyOrder(List.of("c"), List.of("c", "b"), List.of("a"), List.of("a", "b"));
        assertThat(deleteDuplicateFolder(List.of(List.of("a", "b"), List.of("c", "d"), List.of("c"), List.of("a"))))
                .containsExactlyInAnyOrder(List.of("c"), List.of("c", "d"), List.of("a"), List.of("a", "b"));
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie();
        for (List<String> path : paths) {
            Trie cur = root;
            for (String node : path) {
                cur.children.putIfAbsent(node, new Trie());
                cur = cur.children.get(node);
            }
        }

        Map<String, Integer> freq = new HashMap<>();
        construct(root, freq);
        List<List<String>> answer = new ArrayList<>();
        List<String> path = new ArrayList<>();
        operate(root, freq, path, answer);
        return answer;
    }

    static class Trie {
        String serial;
        Map<String, Trie> children = new HashMap<>();
    }

    private void construct(Trie node, Map<String, Integer> freq) {
        if (node.children.isEmpty())
            return;

        List<String> v = new ArrayList<>();
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            construct(entry.getValue(), freq);
            v.add(entry.getKey() + "(" + entry.getValue().serial + ")");
        }

        Collections.sort(v);
        node.serial = String.join("", v);
        freq.merge(node.serial, 1, Integer::sum);
    }

    private void operate(Trie node, Map<String, Integer> freq, List<String> path, List<List<String>> answer) {
        if (freq.getOrDefault(node.serial, 0) > 1)
            return;

        if (!path.isEmpty()) {
            answer.add(new ArrayList<>(path));
        }

        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            path.add(entry.getKey());
            operate(entry.getValue(), freq, path, answer);
            path.remove(path.size() - 1);
        }
    }

}
