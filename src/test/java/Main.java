import github.grovre.ArraysSupport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        Collections.rotate(list, 5);

        int[] arr = IntStream.rangeClosed(1, 10).toArray();
        ArraysSupport.rotate(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
