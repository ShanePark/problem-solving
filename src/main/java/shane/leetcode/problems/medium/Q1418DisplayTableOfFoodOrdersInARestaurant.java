package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1418DisplayTableOfFoodOrdersInARestaurant {

    @Test
    public void test() {
        assertThat(displayTable(Ps.strList("[[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]")))
                .isEqualTo(Ps.strList("[[\"Table\",\"Beef Burrito\",\"Ceviche\",\"Fried Chicken\",\"Water\"],[\"3\",\"0\",\"2\",\"1\",\"0\"],[\"5\",\"0\",\"1\",\"0\",\"1\"],[\"10\",\"1\",\"0\",\"0\",\"0\"]] "));
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> menus = new HashSet<>();
        Set<Integer> tableNumbers = new HashSet<>();
        Map<Integer, Map<String, Integer>> tables = new HashMap<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String menu = order.get(2);
            tables.putIfAbsent(tableNumber, new HashMap<>());
            Map<String, Integer> table = tables.get(tableNumber);
            table.merge(menu, 1, Integer::sum);
            menus.add(menu);
            tableNumbers.add(tableNumber);
        }

        List<String> menuList = menus.stream().sorted().collect(Collectors.toList());
        List<Integer> tableList = tableNumbers.stream().sorted().collect(Collectors.toList());

        List<List<String>> answer = new ArrayList<>();

        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(menuList);
        answer.add(header);

        for (Integer i : tableList) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(i));
            for (String menu : menuList) {
                row.add(String.valueOf(tables.get(i).getOrDefault(menu, 0)));
            }
            answer.add(row);
        }

        return answer;
    }
}
