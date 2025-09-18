package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 320ms
 * Beats73.97%
 */
public class Q3408DesignTaskManager {

    @Test
    public void test() {
        TaskManager taskManager = new TaskManager(List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15)));
        taskManager.add(4, 104, 5);
        taskManager.edit(102, 8);
        assertThat(taskManager.execTop()).isEqualTo(3);
        taskManager.rmv(101);
        taskManager.add(5, 105, 15);
        assertThat(taskManager.execTop()).isEqualTo(5);
    }

    class TaskManager {
        private final TreeSet<Task> tree = new TreeSet<>();
        private final Map<Integer, Task> map = new HashMap<>();

        // userId, taskId, priority
        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                Task t = new Task(task);
                tree.add(t);
                map.put(t.taskId, t);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            tree.add(task);
            map.put(taskId, task);
        }

        public void edit(int taskId, int newPriority) {
            Task task = map.get(taskId);
            tree.remove(task);
            task.priority = newPriority;
            tree.add(task);
        }

        public void rmv(int taskId) {
            Task task = map.remove(taskId);
            tree.remove(task);
        }

        public int execTop() {
            Task top = tree.pollLast();
            if (top == null)
                return -1;
            return top.userId;
        }
    }

    class Task implements Comparable<Task> {
        final int userId;
        final int taskId;
        int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public Task(List<Integer> task) {
            this.userId = task.get(0);
            this.taskId = task.get(1);
            this.priority = task.get(2);
        }

        @Override
        public int compareTo(Task t) {
            if (this.priority == t.priority)
                return this.taskId - t.taskId;
            return this.priority - t.priority;
        }
    }

}
