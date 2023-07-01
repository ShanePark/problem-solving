package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 244 ms Beats 11.24%
 * Memory 61.8 MB Beats 5.33%
 */
public class Q864ShortestPathToGetAllKeys {

    @Test
    public void test() {
        assertThat(shortestPathAllKeys(new String[]{"@...a", ".###A", "b.BCc"})).isEqualTo(10);
        assertThat(shortestPathAllKeys(new String[]{"@....", "#####", "b.A.B"})).isEqualTo(-1);
        assertThat(shortestPathAllKeys(new String[]{"@.a..", "###.#", "b.A.B"})).isEqualTo(8);
        assertThat(shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"})).isEqualTo(6);
        assertThat(shortestPathAllKeys(new String[]{"@Aa"})).isEqualTo(-1);
    }

    public int shortestPathAllKeys(String[] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length();
        Block[][] blocks = new Block[HEIGHT][WIDTH];
        int[] start = null;
        int keySize = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                char c = grid[i].charAt(j);
                Block block = Block.of(c);
                blocks[i][j] = block;
                if (c == '@') {
                    start = new int[]{i, j};
                }
                if (block.type == Type.KEY) {
                    keySize++;
                }
            }
        }
        int steps = 0;
        int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Set<Status> visited = new HashSet<>();
        Queue<Status> q = new LinkedList<>();
        Status startStatus = new Status(start[0], start[1], new HashSet<>());

        q.add(startStatus);
        visited.add(startStatus);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Status poll = q.poll();
                int curY = poll.y;
                int curX = poll.x;
                Set<Character> keys = poll.keys;
                if (keys.size() == keySize)
                    return steps;

                for (int[] dir : DIRS) {
                    int nextY = curY + dir[0];
                    int nextX = curX + dir[1];
                    if (nextY < 0 || nextY == HEIGHT || nextX < 0 || nextX == WIDTH) {
                        continue;
                    }
                    Block nextBlock = blocks[nextY][nextX];
                    Status nextStatus;
                    if (nextBlock.type == Type.WALL)
                        continue;
                    if (nextBlock.type == Type.LOCK) {
                        char code = ((Lock) nextBlock).code;
                        if (!keys.contains(code))
                            continue;
                    }
                    Set<Character> nextKeys = new HashSet<>(keys);
                    if (nextBlock.type == Type.KEY) {
                        char code = ((Key) nextBlock).code;
                        nextKeys.add(code);
                    }
                    nextStatus = new Status(nextY, nextX, nextKeys);
                    if (!visited.add(nextStatus)) {
                        continue;
                    }
                    q.offer(nextStatus);
                }
            }

            steps++;
        }

        return -1;
    }

    class Status {
        final int y;
        final int x;
        final Set<Character> keys;

        public Status(int y, int x, Set<Character> keys) {
            this.y = y;
            this.x = x;
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "y=" + y +
                    ", x=" + x +
                    ", keys=" + keys +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Status)) return false;
            Status status = (Status) o;
            return y == status.y && x == status.x && Objects.equals(keys, status.keys);
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x, keys);
        }
    }

    static class Block {
        Type type;

        public Block(Type type) {
            this.type = type;
        }

        public static Block of(char c) {
            if (c == '@' || c == '.') {
                return new Block(Type.EMPTY);
            }
            if (c == '#') {
                return new Block(Type.WALL);
            }
            if ('a' <= c && c <= 'z') {
                return new Key(c);
            }
            if ('A' <= c && c <= 'Z') {
                return new Lock(c);
            }
            throw new IllegalArgumentException();
        }

        @Override
        public String toString() {
            return "Block{" +
                    "type=" + type +
                    '}';
        }
    }

    static class Key extends Block {
        private final char code;

        public Key(char code) {
            super(Type.KEY);
            this.code = Character.toUpperCase(code);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "code=" + code +
                    ", type=" + type +
                    '}';
        }
    }

    static class Lock extends Block {
        private final char code;

        public Lock(char code) {
            super(Type.LOCK);
            this.code = Character.toUpperCase(code);
        }

        @Override
        public String toString() {
            return "Lock{" +
                    "code=" + code +
                    ", type=" + type +
                    '}';
        }
    }

    enum Type {
        WALL, EMPTY, KEY, LOCK
    }

}
