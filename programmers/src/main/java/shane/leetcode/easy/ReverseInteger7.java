package shane.leetcode.easy;

public class ReverseInteger7 {
    public static void main(String[] args) {
        System.out.println(reverse(1234567899));
    }

    public static int reverse(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x)).reverse();
        try {
            if (x < 0) {
                sb.deleteCharAt(sb.length() - 1);
                return -Integer.parseInt(sb.toString());
            } else {
                return Integer.parseInt(sb.toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
