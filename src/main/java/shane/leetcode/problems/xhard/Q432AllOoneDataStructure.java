package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime60msBeats20.96%
 */
public class Q432AllOoneDataStructure {

    @Test
    public void test() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        assertThat(allOne.getMaxKey()).isEqualTo("hello");
        assertThat(allOne.getMinKey()).isEqualTo("hello");
        allOne.inc("leet");
        assertThat(allOne.getMaxKey()).isEqualTo("hello");
        assertThat(allOne.getMinKey()).isEqualTo("leet");
    }

    @Test
    public void test2() {
        AllOne allOne = new AllOne();
        assertThat(allOne.getMaxKey()).isEqualTo("");
        assertThat(allOne.getMinKey()).isEqualTo("");
    }

    @Test
    public void test3() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        assertThat(allOne.getMaxKey()).isEqualTo("b");
        assertThat(allOne.getMinKey()).isEqualTo("a");
    }

    class AllOne {
        TreeSet<Data> treeSet = new TreeSet<>();
        Map<String, Data> map = new HashMap<>();

        public AllOne() {

        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                Data data = new Data(key);
                map.put(key, data);
                treeSet.add(data);
                return;
            }
            Data data = map.get(key);
            treeSet.remove(data);

            data.inc();
            treeSet.add(data);
        }

        public void dec(String key) {
            Data data = map.get(key);
            if (data == null) {
                throw new IllegalArgumentException();
            }
            treeSet.remove(data);
            data.dec();
            if (data.cnt == 0) {
                map.remove(key);
                return;
            }
            treeSet.add(data);
        }

        public String getMaxKey() {
            if (treeSet.isEmpty())
                return "";
            return treeSet.last().str;
        }

        public String getMinKey() {
            if (treeSet.isEmpty())
                return "";
            return treeSet.first().str;
        }
    }

    class Data implements Comparable<Data> {
        String str;
        int cnt = 1;

        public Data(String str) {
            this.str = str;
        }

        public void inc() {
            this.cnt++;
        }

        public void dec() {
            this.cnt--;
        }

        @Override
        public int compareTo(Data o) {
            int result = Integer.compare(this.cnt, o.cnt);
            if (result == 0) {
                return this.str.compareTo(o.str);
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Data)) return false;
            Data data = (Data) o;
            return Objects.equals(str, data.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "str='" + str + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }

}
