package github.grovre;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
class Sort {

    public static void countingSort(@NonNull final int[] arr) {
        if (arr.length < 2)
            return;

        int[] minmax = ArraysSupport.minmax(arr);
        int offset = minmax[0] < 0 ? -minmax[0] : 0; // In case there are negatives
        int[] map = new int[minmax[1] + offset + 1];
        for (int n : arr)
            map[n+offset]++;

        for (int mapI = 0, arrI = 0; mapI < map.length; mapI++) {
            while (map[mapI] > 0) {
                arr[arrI++] = mapI - offset;
                map[mapI]--;
            }
        }
    }
}
