package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q537ComplexNumberMultiplication {

    @Test
    public void test() {
        assertThat(complexNumberMultiply("1+-1i", "0+0i")).isEqualTo("0+0i");
        assertThat(complexNumberMultiply("1+1i", "1+1i")).isEqualTo("0+2i");
        assertThat(complexNumberMultiply("1+-1i", "1+-1i")).isEqualTo("0+-2i");
    }

    public String complexNumberMultiply(String num1, String num2) {

        int num1Real = Integer.parseInt(num1.split("\\+")[0]);
        String imaginary = num1.split("\\+")[1];
        int num1Imaginary = Integer.parseInt(imaginary.substring(0, imaginary.length() - 1));

        int num2Real = Integer.parseInt(num2.split("\\+")[0]);
        imaginary = num2.split("\\+")[1];
        int num2Imaginary = Integer.parseInt(imaginary.substring(0, imaginary.length() - 1));

        int real = num1Real * num2Real - num1Imaginary * num2Imaginary;
        int fake = num1Imaginary * num2Real + num2Imaginary * num1Real;

        return real + "+" + fake + "i";
    }

}
