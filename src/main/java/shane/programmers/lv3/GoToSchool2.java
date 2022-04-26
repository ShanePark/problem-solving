package shane.programmers.lv3;

public class GoToSchool2 {

	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] { { 2, 2 } }));

	}

	public static int solution(int m, int n, int[][] puddles) {
		// false if you can pass
		boolean[][] puddleMap = new boolean[n][m];
		int[][] memo = new int[n][m];

		for (int i = 0; i < puddles.length; i++) {
			puddleMap[puddles[i][1] - 1][puddles[i][0] - 1] = true;
		}

		// 첫 row 에 1 넣기
		for (int i = 0; i < m; i++) {
			if (puddleMap[0][i] == true)
				break;
			memo[0][i] = 1;
		}
		// 첫 column에 1 넣기
		for (int i = 0; i < n; i++) {
			if (puddleMap[i][0] == true) {
				break;
			}
			memo[i][0] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (puddleMap[i][j] == false) {
					memo[i][j] = memo[i][j - 1]% 1000000007 + memo[i - 1][j]% 1000000007;
				}
			}
		}

		return memo[n - 1][m - 1]% 1000000007;
	}

}
