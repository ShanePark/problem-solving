package shane.programmers.lv3;

public class N2Tiling {

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        if (n == 2)
            return 2;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }

        return arr[n];
    }

}
