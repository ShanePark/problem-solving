package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 59 ms Beats 97.90%
 * Memory 47.6 MB Beats 57.98%
 */
public class Q352DataStreamAsDisjointIntervals {

    @Test
    public void test() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        assertThat(summaryRanges.getIntervals()).isEqualTo(new int[][]{{1, 1}});
        summaryRanges.addNum(3);
        assertThat(summaryRanges.getIntervals()).isEqualTo(new int[][]{{1, 1}, {3, 3}});
        summaryRanges.addNum(7);
        assertThat(summaryRanges.getIntervals()).isEqualTo(new int[][]{{1, 1}, {3, 3}, {7, 7}});
        summaryRanges.addNum(2);
        assertThat(summaryRanges.getIntervals()).isEqualTo(new int[][]{{1, 3}, {7, 7}});
        summaryRanges.addNum(6);
        assertThat(summaryRanges.getIntervals()).isEqualTo(new int[][]{{1, 3}, {6, 7}});
    }

    class SummaryRanges {

        List<Range> list = new ArrayList<>();

        public void addNum(int value) {
            SearchResult searchResult = findIndex(list, value);
            if (searchResult.status == SearchStatus.INCLUDED)
                return;

            Range range = new Range(value);
            int i = searchResult.index;
            list.add(i, range);

            if (0 < i) {
                Range before = list.get(i - 1);
                if (before.to == range.from - 1) {
                    list.remove(i--);
                    before.extend(range);
                    range = before;
                }
            }
            if (i < list.size() - 1) {
                Range next = list.get(i + 1);
                if (range.to == next.from - 1) {
                    list.remove(i + 1);
                    range.extend(next);
                }
            }
        }

        public int[][] getIntervals() {
            int size = list.size();
            int[][] answer = new int[size][2];
            for (int i = 0; i < size; i++) {
                Range range = list.get(i);
                answer[i][0] = range.from;
                answer[i][1] = range.to;
            }
            return answer;
        }

        private SearchResult findIndex(List<Range> list, int value) {
            for (int i = 0; i < list.size(); i++) {
                Range range = list.get(i);
                if (value < range.from) {
                    return new SearchResult(SearchStatus.BEFORE, i);
                } else if (range.from <= value && value <= range.to) {
                    return new SearchResult(SearchStatus.INCLUDED, i);
                }
            }
            return new SearchResult(SearchStatus.NEXT, list.size());
        }
    }

    class Range {
        int from;
        int to;

        public Range(int value) {
            this.from = value;
            this.to = value;
        }

        public void extend(Range next) {
            if (this.to + 1 != next.from)
                throw new IllegalStateException("They are not connected");
            this.to = next.to;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    class SearchResult {
        SearchStatus status;
        int index;

        public SearchResult(SearchStatus status, int index) {
            this.status = status;
            this.index = index;
        }

        @Override
        public String toString() {
            return "SearchResult{" +
                    "status=" + status +
                    ", index=" + index +
                    '}';
        }
    }

    enum SearchStatus {
        INCLUDED, NEXT, BEFORE
    }

}
