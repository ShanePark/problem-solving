package shane.leetcode.medium;

public class Q1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(minPartitions("55"));
        ;
    }

    public static int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i <= n.length()-1; i++) {
            max = Math.max(max, n.charAt(i) - 48);
        }
        return max;
    }
}
