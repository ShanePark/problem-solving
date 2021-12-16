package shane.leetcode.medium;

import com.tistory.shanepark.STool;
import org.junit.Assert;

public class Q1476SubrectangleQueries {
    public static void main(String[] args) {
        SubrectangleQueries q = new SubrectangleQueries(STool.convertToIntArray("[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]]"));
        Assert.assertEquals(1, q.getValue(0, 2));
        q.updateSubrectangle(0, 0, 3, 2, 5);
        Assert.assertEquals(5, q.getValue(0, 2));
        Assert.assertEquals(5, q.getValue(3, 1));
        q.updateSubrectangle(3, 0, 3, 2, 10);
        Assert.assertEquals(10, q.getValue(3, 1));
        Assert.assertEquals(5, q.getValue(0, 2));
    }

    static class SubrectangleQueries {

        int[][] data;

        public SubrectangleQueries(int[][] rectangle) {
            this.data = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    data[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return data[row][col];
        }
    }

}


