package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Wrong
 */
public class Q564FindTheClosestPalindrome {

    @Test
    public void test() {
        assertThat(nearestPalindromic("12321")).isEqualTo("12221");
        assertThat(nearestPalindromic("1221")).isEqualTo("1111");
        assertThat(nearestPalindromic("12345")).isEqualTo("12321");
        assertThat(nearestPalindromic("123")).isEqualTo("121");
        assertThat(nearestPalindromic("1")).isEqualTo("0");
        assertThat(nearestPalindromic("100")).isEqualTo("99");
        assertThat(nearestPalindromic("11")).isEqualTo("9");
        assertThat(nearestPalindromic("12")).isEqualTo("11");
        assertThat(nearestPalindromic("99")).isEqualTo("101");
        assertThat(nearestPalindromic("999")).isEqualTo("1001");
        assertThat(nearestPalindromic("1111")).isEqualTo("1001");
        assertThat(nearestPalindromic("10001")).isEqualTo("9999");
    }

    @Test
    public void wrong() {
        assertThat(nearestPalindromic("1283")).isEqualTo("1331");
    }

    public String nearestPalindromic(String n) {
        long originalNumber = Long.parseLong(n);
        if (originalNumber < 10) {
            return String.valueOf((char) (n.charAt(0) - 1));
        }
        if (originalNumber == 11) {
            return "9";
        }
        if (String.valueOf(originalNumber).matches("^9+$")) {
            return String.valueOf(originalNumber + 2);
        }
        if (n.charAt(0) == '1' && n.charAt(n.length() - 1) == '1' && n.substring(1, n.length() - 1).matches("^0+$")) {
            return String.valueOf(originalNumber - 2);
        }
        char[] arr = n.toCharArray();
        if (isPalindrome(arr)) {
            int mid = arr[arr.length / 2] - '0';
            if (mid == 0) {
                mid++;
            } else {
                mid--;
            }
            arr[arr.length / 2] = (char) ('0' + mid);
            if (arr.length % 2 == 0) {
                arr[arr.length / 2 - 1] = (char) ('0' + mid);
            }
            return new String(arr);
        }
        for (int i = 0; i < arr.length / 2; i++) {
            char left = arr[i];
            char right = arr[arr.length - i - 1];
            if (left == right)
                continue;
            arr[arr.length - i - 1] = left;
            long leftNum = Long.parseLong(new String(arr));
            arr[arr.length - i - 1] = right;
            arr[i] = right;
            long rightNum = Long.parseLong(new String(arr));
            if (Math.abs(originalNumber - leftNum) == Math.abs(originalNumber - rightNum)) {
                char smaller = left < right ? left : right;
                arr[arr.length - i - 1] = smaller;
                arr[i] = smaller;
            } else if (Math.abs(originalNumber - leftNum) > Math.abs(originalNumber - rightNum)) {
                arr[arr.length - i - 1] = right;
                arr[i] = right;
            } else {
                arr[arr.length - i - 1] = left;
                arr[i] = left;
            }
        }

        String answer = new String(arr);
        long answerNum = Long.parseLong(answer);
        if (originalNumber < answerNum) {
            long oppositeNum = 2 * originalNumber - answerNum;
            String oppositeStr = String.valueOf(oppositeNum);
            if (isPalindrome(oppositeStr.toCharArray())) {
                return oppositeStr;
            }
        }
        return answer;
    }

    private boolean isPalindrome(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
