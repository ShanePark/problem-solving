package shane.programmers.challenge2022.kakao2022;

public class K2 {

    public static void main(String[] args) {
//        System.out.println(solution(437674, 3));
        System.out.println(solution(1000011, 10));
    }

    public static int solution(int n, int k) {
        String newNum = changeNumber(n, k);
        String[] numbers = newNum.split("0");
        int cnt = 0;
        for (String num : numbers) {
            if (num.length()>0 && isPrime(Long.parseLong(num)))
                cnt++;
        }
        return cnt;
    }

    public static String changeNumber(int n, int k) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    public static boolean isPrime(long n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
