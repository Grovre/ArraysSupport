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

    public static void countingSort(@NonNull final short[] arr) {
        if (arr.length < 2)
            return;

        short[] minmax = ArraysSupport.minmax(arr);
        short offset = (short) (minmax[0] < 0 ? -minmax[0] : 0); // In case there are negatives
        int[] map = new int[minmax[1] + offset + 1];
        for (short n : arr)
            map[n+offset]++;

        for (int mapI = 0, arrI = 0; mapI < map.length; mapI++) {
            while (map[mapI] > 0) {
                arr[arrI++] = (short) (mapI - offset);
                map[mapI]--;
            }
        }
    }

    public static void countingSort(@NonNull final byte[] arr) {
        if (arr.length < 2)
            return;

        byte[] minmax = ArraysSupport.minmax(arr);
        byte offset = (byte) (minmax[0] < 0 ? -minmax[0] : 0); // In case there are negatives
        int[] map = new int[minmax[1] + offset + 1];
        for (byte n : arr)
            map[n+offset]++;

        for (int mapI = 0, arrI = 0; mapI < map.length; mapI++) {
            while (map[mapI] > 0) {
                arr[arrI++] = (byte) (mapI - offset);
                map[mapI]--;
            }
        }
    }

    // This one was actually fun refactoring
    public static void countingSort(@NonNull final boolean[] arr) {
        if (arr.length < 2)
            return;

        int[] map = new int[2];
        for (boolean b : arr)
            // Wish this was C++ when it comes to working with booleans
            map[b ? 1 : 0]++; // if true then 1 else 0

        int i = 0;
        while (map[0] > 0) {
            arr[i++] = false;
            map[0]--;
        }
        while (map[1] > 0) {
            arr[i++] = true;
            map[1]--;
        }
    }
}
