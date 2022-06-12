package github.grovre;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.math3.util.FastMath;


/**
 * This class adds features similar to {@link java.util.Collections}
 * that {@link java.util.Arrays} does not have. Algorithms are
 * created to be as fast as possible. However, that does not guarantee
 * the best speed. Improvements can always be made to this class
 * by creating a pull request on Github:
 * 
 */
@UtilityClass
public class ArraysSupport {

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static int max(@NonNull int[] arr) {
        int max = arr[0];
        for (int n : arr)
            max = FastMath.max(max, n);
        return max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static int min(@NonNull int[] arr) {
        int min = arr[0];
        for(int n : arr)
            min = FastMath.min(min, n);
        return min;
    }
}
