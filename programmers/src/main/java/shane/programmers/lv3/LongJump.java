package shane.programmers.lv3;

public class LongJump {

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(5));
    }

    static long[] memo;

    public static long solution(int n) {

        memo = new long[1234567];
        memo[1] = 1;
        memo[2] = 2;

        return fib(n);

    }

    private static long fib(int n) {
        if(memo[n] != 0){
            return memo[n];
        }else{
            memo[n] = fib(n-1) + fib(n-2);
        }
        return memo[n] % 1234567;
    }

}
