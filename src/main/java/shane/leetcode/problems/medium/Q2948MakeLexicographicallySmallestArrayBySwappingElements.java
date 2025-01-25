package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

public class Q2948MakeLexicographicallySmallestArrayBySwappingElements {

    @Test
    public void test() {
        assertThat(lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2)).containsExactly(1, 3, 5, 8, 9);
        assertThat(lexicographicallySmallestArray(new int[]{1, 7, 6, 18, 2, 1}, 3)).containsExactly(1, 6, 7, 18, 1, 2);
        assertThat(lexicographicallySmallestArray(new int[]{1, 7, 28, 19, 10}, 3)).containsExactly(1, 7, 28, 19, 10);
        assertThat(lexicographicallySmallestArray(new int[]{5, 6, 7}, 1)).containsExactly(5, 6, 7);
        assertThat(lexicographicallySmallestArray(new int[]{5, 7}, 1)).containsExactly(5, 7);

    }

    @Test
    public void test2() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q2948MakeLexicographicallySmallestArrayBySwappingElements.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
        assertThat(lexicographicallySmallestArray(arr, 13));
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Integer> elements = Arrays.stream(nums)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        UNION union = new UNION(elements.size());

        for (int i = 0; i < elements.size() - 1; i++) {
            int v1 = elements.get(i);
            int v2 = elements.get(i + 1);
            if (v2 - v1 <= limit) {
                union.union(i, i + 1);
            }
        }

        Map<Integer, Integer> valueToRoot = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            int root = union.find(i);
            valueToRoot.put(elements.get(i), root);
        }

        Map<Integer, List<Integer>> rootToIndicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int root = valueToRoot.get(nums[i]);
            rootToIndicesMap.putIfAbsent(root, new ArrayList<>());
            rootToIndicesMap.get(root).add(i);
        }

        for (int root : rootToIndicesMap.keySet()) {
            List<Integer> indices = rootToIndicesMap.get(root);
            List<Integer> values = new ArrayList<>(indices.size());
            for (int idx : indices) {
                values.add(nums[idx]);
            }

            Collections.sort(indices);
            Collections.sort(values);

            for (int i = 0; i < indices.size(); i++) {
                nums[indices.get(i)] = values.get(i);
            }
        }

        return nums;
    }

    static class UNION {
        int[] parent;

        UNION(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int groupX = find(x);
            int groupY = find(y);
            if (groupX != groupY) {
                parent[groupX] = groupY;
            }
        }
    }

}
