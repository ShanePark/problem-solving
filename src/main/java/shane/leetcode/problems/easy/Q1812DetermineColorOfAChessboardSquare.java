package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1812DetermineColorOfAChessboardSquare {

    @Test
    public void test() {
        assertThat(squareIsWhite("a1")).isEqualTo(false);
        assertThat(squareIsWhite("h3")).isEqualTo(true);
        assertThat(squareIsWhite("c7")).isEqualTo(false);
        assertThat(squareIsWhite("h1")).isEqualTo(true);
        assertThat(squareIsWhite("h8")).isEqualTo(false);
    }

    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
    }
}
