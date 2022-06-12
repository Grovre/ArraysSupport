import github.grovre.ArraysSupport;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, -5};
        ArraysSupport.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
