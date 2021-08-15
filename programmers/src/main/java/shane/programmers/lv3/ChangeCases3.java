package shane.programmers.lv3;

public class ChangeCases3 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 2, 5 }));
	}

	public static int solution(int n, int[] money) {
		int[] memo = new int[n];
		for(int coin : money) {
			memo[coin-1] += 1;
			for(int i=0; i<n; i++) {
				if(i >= coin) {
					memo[i] += memo[i-coin];
				}
			}
		}
		return memo[n-1];
	}

}
