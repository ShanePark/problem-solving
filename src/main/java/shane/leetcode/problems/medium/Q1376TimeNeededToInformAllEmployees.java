package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 321 ms Beats 5.60%
 * Memory 99.2 MB Beats 5.4%
 */
public class Q1376TimeNeededToInformAllEmployees {

    @Test
    void test() {
        assertThat(numOfMinutes(1, 0, new int[]{-1}, new int[]{0})).isEqualTo(0);
        assertThat(numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0})).isEqualTo(1);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee(i, informTime[i]);
            employeeMap.put(i, employee);
        }
        for (int i = 0; i < n; i++) {
            if (i == headID)
                continue;
            Employee boss = employeeMap.get(manager[i]);
            Employee worker = employeeMap.get(i);
            boss.addWorker(worker);
        }
        Employee boss = employeeMap.get(headID);
        boss.inform(0);

        return employeeMap.values().stream()
                .max(Comparator.comparingInt(e -> e.informedTime))
                .get().informedTime;
    }

    class Employee {
        private int index;
        private Set<Employee> workers = new HashSet<>();
        private int informSpendTime;
        private int informedTime;

        public Employee(int index, int informSpendTime) {
            this.index = index;
            this.informSpendTime = informSpendTime;
        }

        public void addWorker(Employee worker) {
            workers.add(worker);
        }

        public void inform(int i) {
            this.informedTime = i;
            int nextInform = informedTime + informSpendTime;
            for (Employee worker : workers) {
                worker.inform(nextInform);
            }
        }
    }

}
