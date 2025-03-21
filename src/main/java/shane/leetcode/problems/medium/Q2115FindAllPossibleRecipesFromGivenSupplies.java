package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 25ms
 * Beats98.03%
 */
public class Q2115FindAllPossibleRecipesFromGivenSupplies {

    @Test
    public void test() {
        assertThat(findAllRecipes(new String[]{"bread"}, List.of(List.of("yeast", "flour")), new String[]{"yeast", "flour", "corn"}))
                .containsExactlyInAnyOrder("bread");
        assertThat(findAllRecipes(new String[]{"bread", "sandwich"}, List.of(List.of("yeast", "flour"), List.of("bread", "meat")), new String[]{"yeast", "flour", "meat"}))
                .containsExactlyInAnyOrder("bread", "sandwich");
        assertThat(findAllRecipes(new String[]{"bread", "sandwich", "burger"}, List.of(List.of("yeast", "flour"), List.of("bread", "meat"), List.of("sandwich", "meat", "bread")), new String[]{"yeast", "flour", "meat"}))
                .containsExactlyInAnyOrder("bread", "sandwich", "burger");
    }

    @Test
    public void test2() {
        assertThat(findAllRecipes(
                new String[]{"ju", "fzjnm", "x", "e", "zpmcz", "h", "q"},
                Ps.strList("[[\"d\"],[\"hveml\",\"f\",\"cpivl\"],[\"cpivl\",\"zpmcz\",\"h\",\"e\",\"fzjnm\",\"ju\"],[\"cpivl\",\"hveml\",\"zpmcz\",\"ju\",\"h\"],[\"h\",\"fzjnm\",\"e\",\"q\",\"x\"],[\"d\",\"hveml\",\"cpivl\",\"q\",\"zpmcz\",\"ju\",\"e\",\"x\"],[\"f\",\"hveml\",\"cpivl\"]]"),
                new String[]{"f", "hveml", "cpivl", "d"}))
                .containsExactlyInAnyOrder("ju", "fzjnm", "q");
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = Arrays.stream(supplies).collect(Collectors.toSet());
        Map<String, List<String>> receipeMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            receipeMap.put(recipes[i], ingredients.get(i));
        }
        Map<String, Boolean> canMake = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (String recipe : recipes) {
            if (canMake(recipe, canMake, receipeMap, suppliesSet, new HashSet<>())) {
                answer.add(recipe);
            }
        }
        return answer;
    }

    private boolean canMake(String recipe, Map<String, Boolean> canMake, Map<String, List<String>> receipeMap, Set<String> suppliesSet, Set<String> visited) {
        if (canMake.containsKey(recipe))
            return canMake.get(recipe);
        if (!receipeMap.containsKey(recipe)) {
            return markFail(recipe, canMake);
        }
        List<String> ingredients = receipeMap.get(recipe);
        visited.add(recipe);
        for (String ingredient : ingredients) {
            if (suppliesSet.contains(ingredient))
                continue;
            if (!receipeMap.containsKey(ingredient)) {
                return markFail(recipe, canMake);
            }
            if (visited.contains(ingredient)) {
                return markFail(recipe, canMake);
            }
            if (!canMake(ingredient, canMake, receipeMap, suppliesSet, visited)) {
                return markFail(recipe, canMake);
            }
        }
        suppliesSet.add(recipe);
        canMake.put(recipe, true);
        return true;
    }

    private static boolean markFail(String recipe, Map<String, Boolean> canMake) {
        canMake.put(recipe, false);
        return false;
    }

}
