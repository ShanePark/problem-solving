package shane.leetcode.easy;

import org.assertj.core.api.Assertions;

public class Q520DetectCapital {
    public static void main(String[] args) {
        Assertions.assertThat(detectCapitalUse("USA")).isEqualTo(true);
        Assertions.assertThat(detectCapitalUse("FlaG")).isEqualTo(false);
        Assertions.assertThat(detectCapitalUse("ggg")).isEqualTo(true);
        Assertions.assertThat(detectCapitalUse("Leetcode")).isEqualTo(true);
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        // if first Charater is a Capital Letter
        char[] arr = word.toCharArray();
        if (word.charAt(0) < 'a') {
            if (word.charAt(1) < 'a') {
                for (int i=2; i<arr.length; i++) {
                    if ('a' <= arr[i]) {
                        return false;
                    }
                }
            } else {
                for (int i=2; i<arr.length; i++) {
                    if (arr[i] < 'a') {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 1; i <arr.length; i++) {
                if (arr[i] < 'a') {
                    return false;
                }
            }
        }
        return true;
    }

}
