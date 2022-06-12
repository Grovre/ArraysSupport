import github.grovre.ArraysSupport;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SupportTests {

    @Test
    void objectTests() {
        Square[] arr = ArraysSupport.generate(Square[]::new, () -> new Square((int) (Math.random() * 1_000) + 1), 1_000);
        arr[(int) (Math.random() * 500) + 500] = new Square(1_001); // 500 - 999
        arr[(int) (Math.random() * 500)] = new Square(0); // 0 - 499
        assertEquals(new Square(1_001), ArraysSupport.max(arr));
        assertEquals(new Square(0), ArraysSupport.min(arr));

        Arrays.sort(arr);
        assertEquals(0, ArraysSupport.indexOf(arr, new Square(0)));
        assertEquals(arr.length-1, ArraysSupport.indexOf(arr, new Square(1_001)));

        arr = IntStream.range(-1_000, 1_000).mapToObj(Square::new).toArray(Square[]::new);
        ArraysSupport.replaceAll(arr, new Square(-1_000), new Square(9_999));
        assertEquals(arr[0], new Square(9_999));
    }

    @Test
    void supportTester() {

        int[] arr = new int[]{0, 1, 2, 3, 2, 1, 0};
        assertEquals(1, ArraysSupport.indexOf(arr, 1));
        assertEquals(5, ArraysSupport.lastIndexOf(arr, 1));

        arr = new int[]{1_670, 8_750, 8_873, 3_482, 4_283, 1_253, 3_461, 9_502, 3_088, 2_091, 8_502, 4_158, 2_231, 7_467, 8_885, 1_533};
        assertEquals(1_253, ArraysSupport.min(arr));
        assertEquals(9_502, ArraysSupport.max(arr));

        arr = ThreadLocalRandom.current().ints(1000, 0, 20).toArray();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        ArraysSupport.countingSort(arr);
        Arrays.sort(arr2);
        assertArrayEquals(arr, arr2);

        boolean[] boolArr = {true, true, false, true, true, false, true, true};
        ArraysSupport.countingSort(boolArr);
        assertArrayEquals(new boolean[]{false, false, true, true, true, true, true, true}, boolArr);

        arr = IntStream.range(0, 1000).toArray();
        arr2 = IntStream.range(1000, 2000).toArray();
        assertTrue(ArraysSupport.disjoint(arr, arr2));
        assertTrue(ArraysSupport.disjoint(arr2, arr));
        arr = IntStream.range(0, 1000).toArray();
        arr2 = IntStream.range(999, 2000).toArray();
        assertFalse(ArraysSupport.disjoint(arr, arr2));
        assertFalse(ArraysSupport.disjoint(arr2, arr));

        arr = new int[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3};
        assertEquals(3, ArraysSupport.frequency(arr, 1));
    }
}
