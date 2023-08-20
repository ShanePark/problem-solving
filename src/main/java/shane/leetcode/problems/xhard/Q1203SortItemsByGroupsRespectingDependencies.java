package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FAIL: infinite loop
 */
public class Q1203SortItemsByGroupsRespectingDependencies {

    @Test
    public void test() {
        assertThat(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, Ps.intList("[[],[6],[5],[6],[3,6],[],[],[]]")))
                .isEqualTo(new int[]{6, 3, 4, 1, 5, 2, 0, 7});
        assertThat(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, Ps.intList("[[],[6],[5],[6],[3],[],[4],[]]")))
                .isEqualTo(new int[]{});
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Item> items = new HashMap<>();
        List<Group> groups = new ArrayList<>();
        List<Item> unGrouped = new ArrayList<>();
        Map<Item, List<Item>> hasBeforeMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            groups.add(new Group(i));
        }
        for (int i = 0; i < n; i++) {
            Item item = new Item(i);
            items.put(i, item);
            hasBeforeMap.put(item, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            Item item = items.get(i);
            List<Item> before = beforeItems.get(i).stream().map(index -> items.get(index)).collect(Collectors.toList());
            item.addBefore(before);
            for (Item beforeItem : before) {
                List<Item> hasBefore = hasBeforeMap.get(beforeItem);
                hasBefore.add(item);
            }
            if (group[i] < 0) {
                unGrouped.add(item);
                continue;
            }
            Group g = groups.get(group[i]);
            g.addItem(item);
        }

        Collections.sort(unGrouped, Comparator.comparingInt(i -> i.beforeItems.size()));
        Collections.sort(groups, Comparator.comparingInt(g -> g.beforeItems.size()));

        for (Group g : groups) {
            g.arrange();
        }

        List<Item> answer = new ArrayList<>();
        while (answer.size() < n) {
            for (int i = 0; i < unGrouped.size(); i++) {
                Item item = unGrouped.get(i);
                if (!item.beforeItems.isEmpty()) {
                    break;
                }
                answer.add(item);
                for (Item removeTarget : hasBeforeMap.get(item)) {
                    removeTarget.beforeItems.remove(item);
                    removeTarget.group.beforeItems.remove(item);
                }
                unGrouped.remove(i--);
            }
            if (groups.isEmpty())
                continue;
            Group first = groups.get(0);
            if (first.beforeItems.isEmpty()) {
                answer.addAll(first.items);
                groups.remove(first);
            }
        }

        System.err.println("groups = " + groups);
        System.err.println("unGrouped = " + unGrouped);
        return answer.stream().mapToInt(i -> i.index).toArray();
    }

    class Group {
        int index;
        Set<Item> items = new HashSet<>();
        Set<Item> beforeItems = new HashSet<>();

        public Group(int i) {
            this.index = i;
        }

        public void addItem(Item item) {
            items.add(item);
            item.group = this;
            beforeItems.addAll(item.beforeItems);
        }

        @Override
        public String toString() {
            return "Group{" +
                    "index=" + index +
                    ", items=" + items.stream().map(i -> i.index).collect(Collectors.toList()) +
                    ", beforeItems=" + beforeItems +
                    '}';
        }

        public void arrange() {
            // 1. sort items in the group
            Map<Item, Integer> inDegree = new HashMap<>();
            for (Item item : items) {
                inDegree.put(item, 0);
            }
            for (Item item : items) {
                for (Item beforeItem : item.beforeItems) {
                    if (items.contains(beforeItem)) {
                        inDegree.put(item, inDegree.get(item) + 1);
                    }
                }
            }

            Queue<Item> queue = new LinkedList<>();
            for (Item item : items) {
                if (inDegree.get(item) == 0) {
                    queue.add(item);
                }
            }

            List<Item> sortedItems = new ArrayList<>();
            while (!queue.isEmpty()) {
                Item current = queue.poll();
                sortedItems.add(current);
                for (Item item : items) {
                    if (item.beforeItems.contains(current)) {
                        inDegree.put(item, inDegree.get(item) - 1);
                        if (inDegree.get(item) == 0) {
                            queue.add(item);
                        }
                    }
                }
            }

            if (sortedItems.size() != items.size()) {
                return;
            }

            items.clear();
            items.addAll(sortedItems);

            // 2. remove same items from beforeItems if they're on the same group
            beforeItems.removeAll(items);
        }
    }

    class Item {
        int index;
        Group group;
        Set<Item> beforeItems = new HashSet<>();

        public Item(int i) {
            this.index = i;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "index=" + index +
                    ", group=" + (group == null ? null : group.index) +
                    ", beforeItems=" + beforeItems +
                    '}';
        }

        public void addBefore(List<Item> before) {
            this.beforeItems.addAll(before);
        }
    }

}
