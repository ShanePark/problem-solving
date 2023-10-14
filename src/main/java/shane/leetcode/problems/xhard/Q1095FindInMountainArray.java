package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 43.29MB Beats 43.17%of users with Java
 */
public class Q1095FindInMountainArray {

    @Test
    public void test1() {
        assertThat(findInMountainArray(3, new MountainArray() {
            @Override
            public int get(int index) {
                return new int[]{1, 2, 3, 4, 5, 3, 1}[index];
            }

            @Override
            public int length() {
                return 7;
            }
        })).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(findInMountainArray(3, new MountainArray() {
            @Override
            public int get(int index) {
                return new int[]{0, 1, 2, 4, 2, 1}[index];
            }

            @Override
            public int length() {
                return 6;
            }
        })).isEqualTo(-1);
    }

    @Test
    public void test3() {
        assertThat(findInMountainArray(0, new MountainArray() {
            @Override
            public int get(int index) {
                return new int[]{0, 1, 2, 4, 2, 1}[index];
            }

            @Override
            public int length() {
                return 6;
            }
        })).isEqualTo(0);
    }

    @Test
    public void test4() {
        assertThat(findInMountainArray(1, new MountainArray() {
            @Override
            public int get(int index) {
                return new int[]{0, 2, 4, 2, 1}[index];
            }

            @Override
            public int length() {
                return 5;
            }
        })).isEqualTo(4);
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        // 1. find peak
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && mountainArr.get(mid - 1) <= mountainArr.get(mid)) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        int peak = left - 1;

        // find between 0 to peak
        int index = binarySearchUp(mountainArr, 0, peak, target);
        if (index >= 0)
            return index;
        // find between peak+1 to length-1
        return binarySearchDown(mountainArr, peak + 1, length - 1, target);
    }

    private int binarySearchUp(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            }
            if (midValue < target) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        return -1;
    }

    private int binarySearchDown(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            }
            if (midValue < target) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        return -1;
    }

}


interface MountainArray {
    int get(int index);

    int length();
}
