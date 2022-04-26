package shane.programmers.lv3;

public class IntegerTriangle {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));

	}

	public static int solution(int[][] triangle) {
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] += j == 0 ? triangle[i - 1][0]
						: j == triangle[i].length - 1 ? triangle[i - 1][triangle[i - 1].length - 1]
								: Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
			}
		}

		int max = 0;
		for (int n : triangle[triangle.length - 1]) {
			max = Math.max(max, n);
		}
		return max;
	}

}
