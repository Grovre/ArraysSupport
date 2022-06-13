import github.grovre.ArraysSupport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 1_000).boxed().collect(Collectors.toList());
        Collections.rotate(list, 1);

        int[] arr = IntStream.range(0, 6).toArray();
        ArraysSupport.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
