package shane.programmers.challenge2021.monthly.sep2021;

import java.util.*;

public class P2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SL", "LR"})));
        System.out.println(Arrays.toString(solution(new String[]{"S"})));
        System.out.println(Arrays.toString(solution(new String[]{"R", "R"})));
    }

    public static int[] solution(String[] grid) {

        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                int[] start = {j, i};
                int x = start[0];
                int y = start[1];
                for (char arrow : "UDLR".toCharArray()) {
                    if (set.contains(String.format("%3d%3d%s", x, y, arrow)))
                        continue;
                    int count = 0;
                    while (set.add(String.format("%3d%3d%s", x, y, arrow))) {
                        int[] newPoint = move(new int[]{x, y}, arrow, grid);
                        x = newPoint[0];
                        y = newPoint[1];
                        arrow = turn(arrow, grid[y].charAt(x));
                        count++;
                    }
                    if (start[0] == x && start[1] == y) {
                        list.add(count);
                    }
                }

            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();

    }

    public static int[] move(int[] before, char arrow, String[] grid) {
        int move[] = arrowToArr(arrow);
        int x = before[0] + move[0];
        int y = before[1] + move[1];
        x = x < 0 ? grid[0].length() - 1 : x >= grid[0].length() ? 0 : x;
        y = y < 0 ? grid.length - 1 : y >= grid.length ? 0 : y;
        return new int[]{x, y};
    }

    public static int[] arrowToArr(char arrow) {
        switch (arrow) {
            case 'L':
                return new int[]{-1, 0};
            case 'R':
                return new int[]{1, 0};
            case 'U':
                return new int[]{0, -1};
            case 'D':
                return new int[]{0, 1};
        }
        return null;
    }

    public static char turn(char arrow, char grid) {
        if (grid == 'S') {
            return arrow;
        } else if (grid == 'L') {
            switch (arrow) {
                case 'U':
                    return 'L';
                case 'D':
                    return 'R';
                case 'L':
                    return 'D';
                case 'R':
                    return 'U';
            }
        } else {
            switch (arrow) {
                case 'U':
                    return 'R';
                case 'D':
                    return 'L';
                case 'L':
                    return 'U';
                case 'R':
                    return 'D';
            }
        }
        return ' ';
    }

}
