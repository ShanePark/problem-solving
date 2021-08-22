package shane.programmers.lv3;

import java.util.*;

public class ConnectIslands2 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    public static int solution(int n, int[][] costs) {
        Set<Integer> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, costs);
        int total = 0;
        while (set.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIndex=0;
            int size = list.size();
            int removeCount = 0;
            for (int i = 0; i < size-removeCount; i++) {
                int[] arr = list.get(i);
                if(set.contains(arr[0]) && set.contains(arr[1])){
                    list.remove(i);
                    removeCount++;
                    i--;
                }else if(arr[2] < min){
                    if(set.size()!=0 && !set.contains(arr[0]) && !set.contains(arr[1])){
                        continue;
                    }
                    min = arr[2];
                    minIndex = i;
                }
            }
            int[] arr = list.get(minIndex);
            set.add(arr[0]);
            set.add(arr[1]);
            total += arr[2];
        }
        return total;
    }

}