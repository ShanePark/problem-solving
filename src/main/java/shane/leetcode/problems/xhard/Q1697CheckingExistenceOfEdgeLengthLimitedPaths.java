package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1697CheckingExistenceOfEdgeLengthLimitedPaths {

    @Test
    void test() {
        assertThat(distanceLimitedPathsExist(3, Ps.intArray("[[0,1,2],[1,2,4],[2,0,8],[1,0,16]]"), Ps.intArray("[[0,1,2],[0,2,5]]")))
                .containsExactly(false, true);
        assertThat(distanceLimitedPathsExist(5, Ps.intArray("[[0,1,10],[1,2,5],[2,3,9],[3,4,13]]"), Ps.intArray("[[0,4,14],[1,4,13]]")))
                .containsExactly(true, false);
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[] union = initializeUnion(n);
        int[][] sortedQueries = sortQueries(queries);
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        boolean[] answer = new boolean[queries.length];
        int edgeIdx = 0;

        for (int[] query : sortedQueries) {
            edgeIdx = processEdges(edgeList, union, query[2], edgeIdx);

            int queryId = query[3];
            answer[queryId] = (unionFind(union, query[0]) == unionFind(union, query[1]));
        }

        return answer;
    }

    private int[] initializeUnion(int n) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }
        return union;
    }

    private int[][] sortQueries(int[][] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][4];

        for (int i = 0; i < m; i++) {
            sortedQueries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[2]));

        return sortedQueries;
    }

    private int processEdges(int[][] edgeList, int[] union, int queryLimit, int idx) {
        while (idx < edgeList.length && edgeList[idx][2] < queryLimit) {
            int[] edge = edgeList[idx++];
            union(union, edge[0], edge[1]);
        }
        return idx;
    }

    private void union(int[] union, int u, int v) {
        int uParent = unionFind(union, u);
        int vParent = unionFind(union, v);
        union[uParent] = vParent;
    }

    private int unionFind(int[] union, int u) {
        while (u != union[u]) {
            union[u] = union[union[u]];
            u = union[u];
        }
        return u;
    }

}
