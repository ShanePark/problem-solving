package shane.programmers.weekly;

public class Week8MinimalRectangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    public static int solution(int[][] sizes) {
        int minSide = 0, maxSide = 0;
        for (int[] size : sizes) {
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            maxSide = Math.max(max, maxSide);
            minSide = Math.max(min, minSide);
        }
        return maxSide * minSide;
    }

}
