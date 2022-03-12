package shane.programmers.weekly;

import java.util.*;


/**
 * @author shane
 *	+5 point
 */
public class Week3Puzzle4 {

	public static void main(String[] args) {
//		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
//				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
//		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
//				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
//		System.out.println(solution(game_board, table) == 14);

		System.out.println(solution(
				new int[][] { { 0, 0, 0, 0, 0, 0,  1, 0, 1, 0, 0, 0 }
							, { 1, 1, 1, 1, 1, 1,  0, 0, 0, 1, 0, 0 }
							, { 0, 0, 0, 0, 0, 1,  0, 1, 0, 1, 1, 0 }
							, { 1, 0, 1, 1, 1, 0,  1, 0, 1, 0, 0, 1 }
							, { 0, 1, 0, 0, 0, 0,  1, 0, 1, 0, 0, 0 }
							, { 0, 0, 1, 1, 1, 0,  1, 0, 1, 1, 0, 1 }
							
							, { 0, 1, 0, 0, 0, 1,  1, 0, 0, 0, 1, 0 }
							, { 0, 0, 1, 0, 1, 0,  0, 1, 1, 1, 0, 0 }
							, { 1, 1, 0, 0, 1, 0,  0, 1, 1, 1, 1, 0 }
							, { 0, 0, 1, 1, 0, 1,  0, 1, 1, 1, 0, 0 }
							, { 0, 0, 1, 0, 0, 1,  0, 1, 1, 0, 1, 1 }
							, { 0, 0, 1, 0, 0, 0,  1, 0, 0, 0, 0, 0 } },
				
				new int[][] { { 1, 1, 1, 0, 1, 1,  1, 0, 0, 0, 1, 1 }
							, { 1, 1, 0, 0, 0, 0,  1, 1, 1, 0, 1, 1 }
							, { 1, 0, 1, 0, 1, 0,  0, 0, 0, 1, 1, 0 }
							, { 0, 0, 1, 1, 1, 0,  0, 1, 1, 0, 0, 0 }
							, { 1, 1, 0, 1, 0, 0,  0, 1, 1, 1, 0, 0 }
							, { 1, 0, 0, 0, 0, 0,  0, 0, 1, 0, 0, 0 }
							
							, { 1, 0, 0, 1, 0, 1,  1, 1, 0, 0, 0, 1 }
							, { 1, 1, 0, 1, 0, 1,  1, 1, 0, 0, 0, 1 }
							, { 0, 0, 0, 1, 1, 0,  0, 0, 1, 1, 0, 1 }
							, { 1, 1, 0, 1, 1, 0,  1, 0, 0, 1, 0, 1 }
							, { 1, 1, 1, 0, 0, 0,  1, 0, 1, 1, 0, 1 }
							, { 1, 0, 0, 1, 1, 1,  1, 0, 0, 1, 0, 1 } }));
		// 54
	}

	static int count;

	static class Shape {
		
		int[] startPoint;
		int[][] shapeMap;
		int width;
		int height;
		int size;

		public Shape(int[][] board, int py, int px, int k, boolean[][] visited) {
			List<int[]> points = new ArrayList<>();
			Queue<int[]> q = new LinkedList<>();
			this.startPoint = new int[] { py, px };
			q.add(startPoint);
			int x1 = px, x2 = px;
			int y1 = py, y2 = py;

			while (!q.isEmpty()) {
				int[] point = q.poll();
				int x = point[1], y = point[0];
				visited[y][x] = true;
				points.add(new int[] { y, x });
				x1 = Math.min(x1, x);
				x2 = Math.max(x2, x);
				y2 = Math.max(y2, y);
				// left
				if (x > 0 && (board[y][x - 1] == k) && (visited[y][x - 1] == false))
					q.add(new int[] { y, x - 1 });
				// right
				if ((x < (board.length - 1)) && (board[y][x + 1] == k) && (visited[y][x + 1] == false))
					q.add(new int[] { y, x + 1 });
				// down
				if ((y < board.length - 1) && (board[y + 1][x] == k) && (visited[y + 1][x] == false))
					q.add(new int[] { y + 1, x });
				// up
				if ((y > 0) && (board[y -1][x] == k) && (visited[y - 1][x] == false))
					q.add(new int[] { y - 1, x });
			}

			this.height = y2 - y1 + 1;
			this.width = x2 - x1 + 1;
			shapeMap = new int[height][width];
			for (int[] point : points) {
				shapeMap[point[0] - y1][point[1] - x1] = 1;
			}
			this.size = 0;
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if(shapeMap[i][j]==1)
						size++;
				}
			}

		}

	}

	public static int solution(int[][] game_board, int[][] table) {
		List<Shape> board = toShapeList(game_board, 0);
		List<Shape> blocks = toShapeList(table, 1);
		count = 0;
		
		for (Shape hole : board) {
			match(hole, blocks);
		}

		return count;
	}

	public static List<Shape> toShapeList(int[][] board, int k) {
		boolean[][] visited = new boolean[board.length][board.length];

		List<Shape> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == k && visited[i][j] == false) {
					Shape shape = new Shape(board, i, j, k, visited);
					list.add(shape);
				}
			}
		}

		return list;
	}

	public static void match(Shape hole, List<Shape> blocks) {

		// 가지고 있는 블럭들을 순회하며 구멍을 맞춰본다.
		for (int index = 0; index < blocks.size(); index++) {
			Shape block = blocks.get(index);

			// 같은 크기일때 체크
			if (hole.width == block.width && hole.height == block.height) {
				// 정방향, 180도 방 체크
				if (Arrays.deepEquals(hole.shapeMap, block.shapeMap)
						|| Arrays.deepEquals(hole.shapeMap, rotate(block.shapeMap, 180))) {
					count += hole.size;
					blocks.remove(index);
					return;
				}

			}

			// 돌려서 같은 크기일때 오른쪽, 왼쪽 돌려서 체크
			if (hole.width == block.height && hole.height == block.width) {
				// 90도 체크 , 270도 체크
				if (Arrays.deepEquals(hole.shapeMap, rotate(block.shapeMap, 90))
						|| Arrays.deepEquals(hole.shapeMap, rotate(block.shapeMap, 270))) {
					count += hole.size;
					blocks.remove(index);
					return;
				}
			}

		}

	}

	static int[][] rotate(int[][] arr, int degree) {
		int[][] rotate;
		int n = arr.length;
		int m = arr[0].length;

		switch (degree) {
		case 90:
		case 270:
			rotate = new int[m][n];
			break;
		case 180:
			rotate = new int[n][m];
			break;
		default:
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				switch (degree) {
				case 90:
					rotate[i][j] = arr[n - 1 - j][i];
					break;
				case 180:
					rotate[i][j] = arr[n - 1 - i][m - 1 - j];
					break;
				case 270:
					rotate[i][j] = arr[j][m - 1 - i];
					break;
				}
			}
		}

		return rotate;
	}

}
