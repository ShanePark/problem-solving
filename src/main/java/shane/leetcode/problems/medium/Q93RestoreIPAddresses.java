package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 11 ms Beats 25.89%
 * Memory 42.9 MB Beats 45.21%
 */
public class Q93RestoreIPAddresses {

    @Test
    public void test() {
        assertThat(restoreIpAddresses("25525511135")).containsExactlyInAnyOrder("255.255.11.135", "255.255.111.35");
        assertThat(restoreIpAddresses("0000")).containsExactlyInAnyOrder("0.0.0.0");
        assertThat(restoreIpAddresses("101023")).containsExactlyInAnyOrder("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        assertThat(restoreIpAddresses("0")).isEmpty();
        assertThat(restoreIpAddresses("00000")).isEmpty();
        assertThat(restoreIpAddresses("1111111111111")).isEmpty();
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return Collections.emptyList();

        Queue<Ip> q = new LinkedList<>();
        q.offer(new Ip());
        for (char c : s.toCharArray()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Ip poll = q.poll();
                q.addAll(poll.next(c));
            }
        }

        return q.stream()
                .filter(ip -> ip.curIndex == 3)
                .map(ip -> ip.toString())
                .collect(Collectors.toList());
    }

    class Ip {
        String[] arr = new String[4];
        int curIndex = 0;

        public Ip() {
            arr[0] = "";
        }

        public List<Ip> next(char c) {
            List<Ip> list = new ArrayList<>();
            if (arr[curIndex].length() < 3 && !arr[curIndex].startsWith("0")) {
                Ip ip = addCur(c);
                String last = ip.arr[ip.curIndex];
                int lastInt = Integer.parseInt(last);
                if (lastInt <= 255) {
                    list.add(ip);
                }
            }
            if (arr[curIndex].length() > 0 && curIndex < 3) {
                list.add(addNext(c));
            }
            return list;
        }

        private Ip addNext(char c) {
            Ip clone = cloneIp();
            clone.arr[++clone.curIndex] = String.valueOf(c);
            return clone;
        }

        private Ip addCur(char c) {
            Ip clone = cloneIp();
            clone.arr[curIndex] += c;
            return clone;
        }

        private Ip cloneIp() {
            Ip clone = new Ip();
            clone.arr = Arrays.copyOf(this.arr, arr.length);
            clone.curIndex = this.curIndex;
            return clone;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

}
