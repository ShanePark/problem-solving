package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2103RingsAndRods {

    @Test
    void test() {
        Assertions.assertThat(countPoints("B0B6G0R6R0R6G9")).isEqualTo(1);
        Assertions.assertThat(countPoints("B0R0G0R9R0B0G0")).isEqualTo(1);
        Assertions.assertThat(countPoints("G4")).isEqualTo(0);
    }

    Map<Character, Rod> rods;

    public int countPoints(String rings) {
        rods = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            rods.put((char) (i + '0'), new Rod(i));
        }
        for (int i = 0; i < rings.length(); i += 2) {
            new Ring(rings.substring(i, i + 2));
        }

        return rods.values().stream().mapToInt(r -> r.isComplete() ? 1 : 0).sum();
    }

    class Ring {
        Color color;
        Rod rod;

        Ring(String data) {
            this.color = Color.valueOf(String.valueOf(data.charAt(0)));
            this.rod = rods.get(data.charAt(1));
            rod.addRing(this);
        }
    }

    class Rod {
        int number;
        Set<Color> colors;

        Rod(int number) {
            this.number = number;
            colors = new HashSet<>();
        }

        void addRing(Ring ring) {
            this.colors.add(ring.color);
        }

        boolean isComplete() {
            return this.colors.size() == 3;
        }
    }

    enum Color {
        R, G, B
    }
}

