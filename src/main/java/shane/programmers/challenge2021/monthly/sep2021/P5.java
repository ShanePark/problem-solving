package shane.programmers.challenge2021.monthly.sep2021;

public class P5 {

    public static void main(String[] args) {
        System.out.println(solution(10) == 3);
        System.out.println(solution(12) == 11);
    }

    public static int solution(int n) {
        for (int i = 2; i < n; i++) {
            if(n % i == 1)
                return i;
        }
        return -1;
    }
}
