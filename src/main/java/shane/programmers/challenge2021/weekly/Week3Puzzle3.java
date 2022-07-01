package shane.programmers.challenge2021.weekly;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.54ms, 70.4MB)
테스트 2 〉	통과 (0.52ms, 69.5MB)
테스트 3 〉	통과 (0.59ms, 61.9MB)
테스트 4 〉	통과 (0.55ms, 73.4MB)
테스트 5 〉	통과 (0.57ms, 70.6MB)
테스트 6 〉	실패 (1.91ms, 74.4MB)
테스트 7 〉	실패 (2.05ms, 60.9MB)
테스트 8 〉	실패 (1.83ms, 72MB)
테스트 9 〉	실패 (2.46ms, 72.4MB)
테스트 10 〉	실패 (4.74ms, 74.6MB)
테스트 11 〉	통과 (6.26ms, 71.7MB)
테스트 12 〉	실패 (4.89ms, 71.4MB)
테스트 13 〉	실패 (7.60ms, 75.1MB)
테스트 14 〉	통과 (0.57ms, 71.4MB)
테스트 15 〉	통과 (0.38ms, 59.3MB)
테스트 16 〉	통과 (0.41ms, 59.8MB)
테스트 17 〉	통과 (0.69ms, 57.8MB)
테스트 18 〉	통과 (0.46ms, 69.2MB)
테스트 19 〉	통과 (0.42ms, 72.1MB)
테스트 20 〉	통과 (0.51ms, 59.1MB)
테스트 21 〉	통과 (0.38ms, 58.7MB)
테스트 22 〉	통과 (0.37ms, 71.4MB)
채점 결과
정확성: 68.2
합계: 68.2 / 100.0
 */
public class Week3Puzzle3 {

	public static void main(String[] args) {
		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
		System.out.println(solution(game_board, table) == 14);
		System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}}
		, new int[][]{{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}}
		 ));
	}

	static int count;

	static class Shape {

		int[][] shapeMap;
		int width;
		int height;
		int size;

		public Shape(int[][] board, int py, int px, int k, boolean[][] visited) {
			List<int[]> points = new ArrayList<>();
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { py, px });
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
				if (x > 0 && board[y][x - 1] == k && visited[y][x - 1] == false)
					q.add(new int[] { y, x - 1 });
				// right
				if (x < board.length - 1 && board[y][x + 1] == k && visited[y][x + 1] == false)
					q.add(new int[] { y, x + 1 });
				// down
				if (y < board.length - 1 && board[y + 1][x] == k && visited[y + 1][x] == false)
					q.add(new int[] { y + 1, x });
			}

			this.height = y2 - y1 + 1;
			this.width = x2 - x1 + 1;
			this.size = points.size();
			shapeMap = new int[height][width];
			for (int[] point : points) {
				shapeMap[point[0] - y1][point[1] - x1] = 1;
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
			if(hole.width==block.width && hole.height==block.height) {
				// 정방향, 180도 방 체크
				if (Arrays.deepEquals(hole.shapeMap, block.shapeMap)
					|| Arrays.deepEquals(hole.shapeMap, rotate(block.shapeMap, 180))) {
					count += hole.size;
					blocks.remove(index);
					return;
				}
				
			}
			
			// 돌려서 같은 크기일때 오른쪽, 왼쪽 돌려서 체크
			if(hole.width==block.height && hole.height==block.width){
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
	                    rotate[i][j] = arr[n-1-j][i];
	                    break;
	                case 180:
	                    rotate[i][j] = arr[n-1-i][m-1-j];
	                    break;
	                case 270:
	                    rotate[i][j] = arr[j][m-1-i];
	                    break;
	            }
	        }
	    }

	    return rotate;
	}

}
