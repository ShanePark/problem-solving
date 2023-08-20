package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1203SortItemsByGroupsRespectingDependencies2 {

    @Test
    public void test() {
        assertThat(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, Ps.intList("[[],[6],[5],[6],[3,6],[],[],[]]")))
                .isEqualTo(new int[]{7, 0, 5, 2, 6, 3, 4, 1});
    }

    @Test
    public void test2() {
        assertThat(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, Ps.intList("[[],[6],[5],[6],[3],[],[4],[]]")))
                .isEqualTo(new int[]{});
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        Map<Integer, List<Integer>> itemMap = new HashMap<>();
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            itemMap.put(i, new ArrayList<>());
        }

        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        int[] groups = new int[m];
        for (int i = 0; i < m; i++) {
            groupMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemMap.get(prev).add(i);
                items[i]++;

                int currentGroup = group[i];
                int prevGroup = group[prev];
                if (currentGroup != prevGroup) {
                    groupMap.get(prevGroup).add(currentGroup);
                    groups[currentGroup]++;
                }
            }
        }

        List<Integer> itemOrder = topologicalSort(itemMap, items);
        List<Integer> groupOrder = topologicalSort(groupMap, groups);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[]{};
        }

        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        itemOrder.forEach(item -> orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item));

        return groupOrder.stream()
                .flatMap(g -> orderedGroups.getOrDefault(g, new ArrayList<>()).stream())
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private List<Integer> topologicalSort(Map<Integer, List<Integer>> map, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = map.keySet().stream()
                .filter(k -> arr[k] == 0)
                .collect(Collectors.toCollection(Stack::new));

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            answer.add(cur);

            for (Integer prev : map.get(cur)) {
                arr[prev]--;
                if (arr[prev] == 0) {
                    stack.add(prev);
                }
            }
        }

        if (answer.size() < map.size()) {
            return Collections.emptyList();
        }
        return answer;
    }

}
