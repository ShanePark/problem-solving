package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2528MaximizeTheMinimumPoweredCity {

    @Test
    public void test() {
        assertThat(maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2)).isEqualTo(5);
        assertThat(maxPower(new int[]{4, 4, 4, 4}, 0, 3)).isEqualTo(4);
    }

    public long maxPower(int[] stations, int r, int k) {
        long left = 0;
        long right = k;
        for (int station : stations) {
            right += station;
        }
        while (left <= right) {
            long[] modifiedStations = new long[stations.length];
            for (int i = 0; i < stations.length; i++)
                modifiedStations[i] = stations[i];
            long windowPower = 0, stationsUsed = 0;
            for (int i = 0; i < r; i++)
                windowPower += modifiedStations[i];
            long mid = left + (right - left) / 2;
            for (int i = 0; i < stations.length; i++) {
                int addStationIndex = Math.min(stations.length - 1, i + r);
                if (i + r < stations.length)
                    windowPower += modifiedStations[i + r];
                if (i - r > 0)
                    windowPower -= modifiedStations[i - r - 1];
                long powerDeficit = Math.max(0, mid - windowPower);
                modifiedStations[addStationIndex] += powerDeficit;
                windowPower += powerDeficit;
                stationsUsed += powerDeficit;
            }
            if (stationsUsed <= k) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        return right;
    }

}
