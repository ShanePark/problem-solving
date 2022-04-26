package shane.programmers.lv3;

import java.util.*;

public class FarthestNode {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static class Node {
        List<Node> list;
        Integer number;

        Node() {
        }

        Node(int n) {
            this.number = n;
            list = new ArrayList<>();
        }
        public void add(Node node){
            list.add(node);
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            for (Node node : list) {
                sb.append(" "+node.number);
            }
            return "Node{" +
                    "list=" + sb +
                    ", number=" + number +
                    '}';
        }
    }

    public static int solution(int n, int[][] edge) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        for (int[] ints : edge) {
            int n1 = ints[0], n2 = ints[1];
            Node node1, node2;
            if (set.add(n1)) {
                node1 = new Node(n1);
                map.put(n1, node1);
            }else {
                node1 = map.get(n1);
            }
            if (set.add(n2)) {
                node2 = new Node(n2);
                map.put(n2, node2);
            }else {
                node2 = map.get(n2);
            }
            node1.add(node2);
            node2.add(node1);
        }

        Node first = map.get(1);
        int[] distances = new int[n+1];
        distances[1] = -1;
        calculate(first, distances, 1);

        int max = Arrays.stream(distances).max().getAsInt();
        return (int) Arrays.stream(distances).filter(i -> i==max).count();

    }

    public static void calculate(Node node, int[] distances, int distance) {
        List<Node> list = node.list;
        for (Node node1 : list) {
            if(distances[node1.number] == 0 || distance < distances[node1.number]) {
                distances[node1.number] = distance;
                calculate(node1, distances, distance+1);
            }
        }
    }
}
