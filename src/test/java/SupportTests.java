import github.grovre.ArraysSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupportTests {

    @Test
    void supportTester() {

        int[] arr = new int[]{0, 1, 2, 3, 2, 1, 0};
        assertEquals(1, ArraysSupport.indexOf(arr, 1));
        assertEquals(5, ArraysSupport.lastIndexOf(arr, 1));

        arr = new int[]{1_670, 8_750, 8_873, 3_482, 4_283, 1_253, 3_461, 9_502, 3_088, 2_091, 8_502, 4_158, 2_231, 7_467, 8_885, 1_533};
        assertEquals(1_253, ArraysSupport.min(arr));
        assertEquals(9_502, ArraysSupport.max(arr));

        arr = ArraysSupport.generate(i -> i * 100, 100);
        assertEquals(100, arr.length);
        for (int n : new int[]{0, 1, 2})
            assertEquals(n * 100, arr[n]);


    }
}
