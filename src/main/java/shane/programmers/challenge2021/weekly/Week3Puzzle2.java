package shane.programmers.challenge2021.weekly;

import java.util.*;

/**
 * 같은 코드로 채점한 결과가 있습니다. 정확성 테스트 테스트 1 〉 통과 (0.32ms, 72.8MB) 테스트 2 〉 통과 (0.31ms,
 * 59.6MB) 테스트 3 〉 통과 (0.32ms, 60.3MB) 테스트 4 〉 통과 (0.33ms, 68.5MB) 테스트 5 〉 통과
 * (0.30ms, 58MB) 테스트 6 〉 실패 (1.29ms, 69.6MB) 테스트 7 〉 실패 (1.29ms, 72MB) 테스트 8 〉
 * 통과 (1.37ms, 59.8MB) 테스트 9 〉 통과 (1.50ms, 61.9MB) 테스트 10 〉 통과 (4.00ms, 59.8MB)
 * 테스트 11 〉 통과 (5.26ms, 59.4MB) 테스트 12 〉 통과 (3.71ms, 58.8MB) 테스트 13 〉 통과
 * (3.97ms, 60.5MB) 테스트 14 〉 통과 (0.29ms, 58.6MB) 테스트 15 〉 통과 (0.19ms, 70.5MB)
 * 테스트 16 〉 통과 (0.20ms, 67.5MB) 테스트 17 〉 통과 (0.21ms, 61.4MB) 테스트 18 〉 통과
 * (0.21ms, 58.8MB) 테스트 19 〉 통과 (0.20ms, 74.7MB) 테스트 20 〉 통과 (0.20ms, 71.7MB)
 * 테스트 21 〉 통과 (0.19ms, 58.9MB) 테스트 22 〉 통과 (0.16ms, 57.5MB) 채점 결과 정확성: 90.9 합계:
 * 90.9 / 100.0
 */
public class Week3Puzzle2 {
	static int count;

	public static void main(String[] args) {
		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
		System.out.println(solution(game_board, table) == 14);
	}

	public static int solution(int[][] game_board, int[][] table) {
		List<int[][]> board = parse(game_board, 0);
		List<int[][]> blocks = parse(table, 1);
		count = 0;

		for (int[][] hole : board) {
			match(hole, blocks);
		}

		return count;
	}

	public static void match(int[][] hole, List<int[][]> blocks) {
		int width = hole[0].length;
		int height = hole.length;

		// 가지고 있는 블럭들을 순회하며 구멍을 채운다.
		for (int index = 0; index < blocks.size(); index++) {

			int[][] block = blocks.get(index);

			// 1. 높이와 너비가 딱 맞을 경우 정방향과 180도 회전해 체크해보기
			if (hole.length == block.length && hole[0].length == block[0].length) {
				// 정방향 체크
				boolean ok = true;
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if (hole[i][j] == block[i][j]) {
							ok = false;
						}
					}
					if (ok == false)
						break;
				}
				// 180 도 방향 체크
				if (!ok) {
					ok = true;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < width; j++) {
							if (hole[i][j] == block[height - i - 1][width - j - 1]) {
								ok = false;
							}
						}
						if (ok == false)
							break;
					}
				}

				if (ok) {
					// 블럭을 찾았으면 해당 블록을 제거 하고,카운트를 늘린 후 match 메서드를 종료한다.
					int temp = 0;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < width; j++) {
							if (hole[i][j] == 0)
								temp++;
						}
					}
					count += temp;
					blocks.remove(index);
					return;
				}

			}

			// 2. 돌려서 사이즈 맞을경우 체크해보기
			if (hole.length == block[0].length && hole[0].length == block.length) {
				// 블럭 좌측으로 회전
				boolean ok = true;
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if (hole[i][j] == block[j][height - i - 1]) {
							ok = false;
						}
					}
					if (ok == false)
						break;
				}
				// 블럭 우측으로 회전
				if (!ok) {
					ok = true;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < width; j++) {
							if (hole[i][j] == block[width - j - 1][i]) {
								ok = false;
							}
						}
						if (ok == false)
							break;
					}
				}

				if (ok) {
					// 블럭을 찾았으면 해당 블록을 제거 하고,카운트를 늘린 후 match 메서드를 종료한다.
					int temp = 0;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < width; j++) {
							if (hole[i][j] == 0)
								temp++;
						}
					}
					count += temp;
					blocks.remove(index);
					return;
				}
			}

		}

	}

	public static List<int[][]> parse(int[][] board, int k) {
		boolean[][] visited = new boolean[board.length][board.length];

		List<int[][]> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == k && visited[i][j] == false) {
					list.add(process(board, i, j, k, visited));
				}
			}
		}

		return list;
	}

	public static int[][] process(int[][] board, int py, int px, int k, boolean[][] visited) {

		List<int[]> points = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { py, px });

		int x1 = px;
		int x2 = px;
		int y1 = py;
		int y2 = py;

		while (!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[1];
			int y = point[0];
			visited[y][x] = true;
			points.add(new int[] { y, x });
			x1 = Math.min(x1, x);
			x2 = Math.max(x2, x);
			y2 = Math.max(y2, y);
			// check left
			if (point[1] > 0 && board[y][x - 1] == k && visited[y][x - 1] == false) {
				q.add(new int[] { y, x - 1 });
			}

			// check right
			if (point[1] < board[0].length - 1 && board[y][x + 1] == k && visited[y][x + 1] == false) {
				q.add(new int[] { y, x + 1 });
			}

			// check down
			if (point[0] < board.length - 1 && board[y + 1][x] == k && visited[y + 1][x] == false) {
				q.add(new int[] { y + 1, x });
			}
		}

		int height = y2 - y1 + 1;
		int width = x2 - x1 + 1;
		int[][] box = new int[height][width];
		for (int i = 0; i < box.length; i++) {
			Arrays.fill(box[i], k == 1 ? 0 : 1);
		}
		for (int[] point : points) {
			int tempX = point[1];
			int tempY = point[0];
			box[tempY - y1][tempX - x1] = board[tempY][tempX];
		}

		return box;

	}

}
